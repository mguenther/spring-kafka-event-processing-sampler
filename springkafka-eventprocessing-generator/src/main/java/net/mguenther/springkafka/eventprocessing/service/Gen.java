package net.mguenther.springkafka.eventprocessing.service;

import java.time.Clock;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Math.max;

@FunctionalInterface
public interface Gen<T> {

    T sample();

    default <U> Gen<U> map(final Function<? super T, ? extends U> combinator) {
        return () -> combinator.apply(sample());
    }

    default <U> Gen<U> flatMap(final Function<? super T, Gen<U>> combinator) {
        return combinator.apply(sample());
    }

    default Gen<T> suchThat(final Predicate<? super T> predicate) {
        return () -> Stream
                .iterate(this, t -> t)
                .map(Gen::sample)
                .filter(predicate)
                .findFirst()
                .get();
    }

    static <T> Gen<T> constant(final T value) {
        return () -> value;
    }

    static <T> Gen<T> oneOf(final T... values) {
        return oneOf(Arrays.asList(values));
    }

    static <T> Gen<T> oneOf(final List<T> values) {
        final Random r = new Random();
        return () -> {
            final int index = r.nextInt(values.size());
            return values.get(index);
        };
    }

    static <T> Gen<T> oneOf(final Gen<T>... gs) {
        final List<Gen<T>> listOfGs = Arrays.asList(gs);
        final Random r = new Random();
        return () -> {
            final int index = r.nextInt(listOfGs.size());
            return listOfGs.get(index).sample();
        };
    }

    static <T> Gen<List<T>> listOf(final Gen<T> sourceGen, final int bound) {
        final int sanitizedBound = max(0, bound);
        final Random r = new Random();
        return () -> {
            final int size = r.nextInt(sanitizedBound);
            return Stream
                    .iterate(sourceGen, t -> t)
                    .limit(size)
                    .map(Gen::sample)
                    .collect(Collectors.toList());
        };
    }

    static <T> Gen<List<T>> nonEmptyListOf(final Gen<T> sourceGen, final int bound) {
        return listOf(sourceGen, max(1, bound));
    }

    static <T> Gen<List<T>> listOfN(final Gen<T> sourceGen, final int exactSize) {
        final int sanitizedBound = max(0, exactSize);
        return () -> Stream
                .iterate(sourceGen, t -> t)
                .limit(sanitizedBound)
                .map(Gen::sample)
                .collect(Collectors.toList());
    }

    static Gen<Integer> nonNegativeInteger() {
        final Random r = new Random();
        return () -> {
            final int i = r.nextInt();
            return i < 0 ? -(i + 1) : i;
        };
    }

    static Gen<Double> normalizedDouble() {
        return nonNegativeInteger().map(n -> n / ((double) Integer.MAX_VALUE + 1));
    }

    static Gen<Integer> choose(final int lowerBound, final int upperBoundExclusive) {
        return nonNegativeInteger().map(n -> lowerBound + (n % (upperBoundExclusive - lowerBound)));
    }

    static Gen<Double> choose(final double lowerBound, final double upperBoundExclusive) {
        return normalizedDouble().map(d -> lowerBound + d * (upperBoundExclusive - lowerBound));
    }

    String NUMERIC_CHARS = "0123456789";
    String ALPHABET_UPPER_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String ALPHABET_LOWER_CHARS = ALPHABET_UPPER_CHARS.toLowerCase();
    char[] NON_NUMERIC_ALPHABET = (ALPHABET_LOWER_CHARS + ALPHABET_UPPER_CHARS).toCharArray();
    char[] ALPHANUMERIC_ALPHABET = (ALPHABET_LOWER_CHARS + ALPHABET_UPPER_CHARS + NUMERIC_CHARS).toCharArray();

    static Gen<String> randomStringGen(final int exactLength, final char[] alphabet) {
        return listOfN(choose(0, alphabet.length-1), exactLength)
                .map(list -> list.stream()
                        .map(n -> alphabet[n])
                        .map(String::valueOf)
                        .reduce("", String::concat, String::concat));
    }

    static Gen<String> alphaNumString(final int exactLength) {
        return randomStringGen(exactLength, ALPHANUMERIC_ALPHABET);
    }

    static Gen<String> nonNumericString(final int exactLength) {
        return randomStringGen(exactLength, NON_NUMERIC_ALPHABET);
    }

    static Gen<Long> now() {
        return () -> Instant.now(Clock.systemUTC()).toEpochMilli();
    }
}

