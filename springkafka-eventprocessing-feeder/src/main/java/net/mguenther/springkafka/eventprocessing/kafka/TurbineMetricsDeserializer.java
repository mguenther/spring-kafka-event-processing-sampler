package net.mguenther.springkafka.eventprocessing.kafka;

import net.mguenther.springkafka.eventprocessing.serialization.TurbineMetrics;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.Decoder;
import org.apache.avro.io.DecoderFactory;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.IOException;
import java.util.Map;

/**
 * @author Markus Günther (markus.guenther@gmail.com)
 * @author Boris Fresow (bfresow@gmail.com)
 */
public class TurbineMetricsDeserializer implements Deserializer<TurbineMetrics> {

    private final DatumReader<TurbineMetrics> metricsReader = new SpecificDatumReader<>(TurbineMetrics.class);

    @Override
    public void configure(final Map<String, ?> map, final boolean b) {
        // nothing to do here
    }

    @Override
    public TurbineMetrics deserialize(final String s, final byte[] bytes) {

        final Decoder decoder = DecoderFactory.get().binaryDecoder(bytes, null);
        try {
            return metricsReader.read(null, decoder);
        } catch (IOException e) {
            throw new SerializationException("Unable to deserialize byte[] to TurbineMetrics.", e);
        }
    }

    @Override
    public void close() {
        // nothing to do here
    }
}
