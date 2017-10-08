package net.mguenther.springkafka.eventprocessing.service;

import net.mguenther.springkafka.eventprocessing.kafka.TurbineMetricsProducer;
import net.mguenther.springkafka.eventprocessing.serialization.TurbineMetrics;
import net.mguenther.springkafka.eventprocessing.serialization.TurbineState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import static net.mguenther.springkafka.eventprocessing.service.Gen.choose;
import static net.mguenther.springkafka.eventprocessing.service.Gen.now;
import static net.mguenther.springkafka.eventprocessing.service.Gen.oneOf;

/**
 * @author Markus Günther (markus.guenther@gmail.com)
 * @author Boris Fresow (bfresow@gmail.com)
 */
@Service
public class DataGeneratorService {

    private final TurbineMetricsProducer producer;

    @Autowired
    public DataGeneratorService(final TurbineMetricsProducer producer) {
        this.producer = producer;
    }

    @Scheduled(fixedRateString = "${turbine-metrics.rate.in.milliseconds:1000}")
    public void submitRandomTurbineMetricsToKafka() {
        producer.submit(turbineMetricsGen().sample());
    }

    private Gen<TurbineMetrics> turbineMetricsGen() {
        return
            choose(1, 250).map(i -> (long) i).flatMap(turbineId ->
            now().flatMap(timestamp ->
            oneOf(TurbineState.values()).flatMap(turbineState ->
            choose(10.0, 50.0).flatMap(powerOutput ->
            choose(10.0, 50.0).flatMap(windSpeed ->
            choose(-10.0, 30.0).map(temperature -> {
                final TurbineMetrics metrics = new TurbineMetrics();
                metrics.setTurbineId(turbineId);
                metrics.setTimestamp(timestamp);
                metrics.setTurbineState(turbineState);
                metrics.setPowerOutput(powerOutput);
                metrics.setWindSpeed(windSpeed);
                metrics.setTemperature(temperature);
                return metrics;
            }))))));
    }
}
