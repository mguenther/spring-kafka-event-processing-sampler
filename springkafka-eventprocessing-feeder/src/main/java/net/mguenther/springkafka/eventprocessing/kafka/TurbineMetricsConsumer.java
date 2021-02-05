package net.mguenther.springkafka.eventprocessing.kafka;

import net.mguenther.springkafka.eventprocessing.serialization.TurbineMetrics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Markus Günther (markus.guenther@gmail.com)
 * @author Boris Fresow (bfresow@gmail.com)
 */
@Component
public class TurbineMetricsConsumer {

    private static final Logger log = LoggerFactory.getLogger(TurbineMetricsConsumer.class);

    @KafkaListener(topics = "${turbine-metrics.topic}", groupId = "turbine-metrics-feeder", containerFactory = "batchFactory")
    public void listen(final List<TurbineMetrics> listOfTurbineMetrics, final Acknowledgment acknowledgment) {

        log.info("Received batch of {} turbine metrics data items.", listOfTurbineMetrics.size());

        for (TurbineMetrics metrics : listOfTurbineMetrics) {

            log.info("Received turbine metrics for turbine {} [{}]: {} kW, {} m/s, {} °C",
                    metrics.getTurbineId(),
                    metrics.getTurbineState(),
                    metrics.getPowerOutput(),
                    metrics.getWindSpeed(),
                    metrics.getTemperature());
        }

        acknowledgment.acknowledge();
    }
}
