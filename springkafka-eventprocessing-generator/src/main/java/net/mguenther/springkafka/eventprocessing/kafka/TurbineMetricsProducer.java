package net.mguenther.springkafka.eventprocessing.kafka;

import net.mguenther.springkafka.eventprocessing.serialization.TurbineMetrics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

/**
 * @author Markus Günther (markus.guenther@gmail.com)
 * @author Boris Fresow (bfresow@gmail.com)
 */
@Component
public class TurbineMetricsProducer {

    private static final Logger log = LoggerFactory.getLogger(TurbineMetricsProducer.class);

    private final String topicName;

    private final KafkaTemplate<Long, TurbineMetrics> kafkaTemplate;

    @Autowired
    public TurbineMetricsProducer(@Value("${turbine-metrics.topic}") final String topicName,
                                  final KafkaTemplate<Long, TurbineMetrics> kafkaTemplate) {
        this.topicName = topicName;
        this.kafkaTemplate = kafkaTemplate;
    }

    public void submit(final TurbineMetrics metrics) {

        kafkaTemplate
                .send(topicName, metrics.getTurbineId(), metrics)
                .addCallback(this::onSuccess, this::onFailure);
    }

    private void onSuccess(final SendResult<Long, TurbineMetrics> result) {
        log.info("TurbineMetrics for turbine {} have been written to topic-partition {}-{} with ingestion timestamp {}.",
                result.getProducerRecord().key(),
                result.getRecordMetadata().topic(),
                result.getRecordMetadata().partition(),
                result.getRecordMetadata().timestamp());
    }

    private void onFailure(final Throwable t) {
        log.warn("Unable to write TurbineMetrics to topic {}.", topicName, t);
    }
}
