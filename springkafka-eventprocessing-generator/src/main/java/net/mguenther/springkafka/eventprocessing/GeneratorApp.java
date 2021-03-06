package net.mguenther.springkafka.eventprocessing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author Markus Günther (markus.guenther@gmail.com)
 * @author Boris Fresow (bfresow@gmail.com)
 */
@SpringBootApplication
@EnableScheduling
public class GeneratorApp {

    public static void main(String[] args) {
        SpringApplication.run(GeneratorApp.class, args);
    }
}
