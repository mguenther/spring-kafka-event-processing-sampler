package net.mguenther.springkafka.eventprocessing.kafka;

import net.mguenther.springkafka.eventprocessing.serialization.TurbineMetrics;
import org.apache.avro.io.BinaryEncoder;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.io.EncoderFactory;
import org.apache.avro.specific.SpecificDatumWriter;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;
import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;

import java.io.IOException;
import java.util.Map;

/**
 * @author Markus Günther (markus.guenther@gmail.com)
 * @author Boris Fresow (bfresow@gmail.com)
 */
public class TurbineMetricsSerializer implements Serializer<TurbineMetrics> {

    private final DatumWriter<TurbineMetrics> metricsWriter = new SpecificDatumWriter<>(TurbineMetrics.class);

    @Override
    public void configure(final Map<String, ?> map, final boolean b) {
        // nothing to do here
    }

    @Override
    public byte[] serialize(final String topic, final TurbineMetrics metrics) {
        try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            final BinaryEncoder encoder = EncoderFactory.get().binaryEncoder(out, null);
            metricsWriter.write(metrics, encoder);
            encoder.flush();
            return out.toByteArray();
        } catch (IOException e) {
            throw new SerializationException("Unable to serialize TurbineMetrics to byte[].", e);
        }
    }

    @Override
    public void close() {
        // nothing to do here
    }
}
