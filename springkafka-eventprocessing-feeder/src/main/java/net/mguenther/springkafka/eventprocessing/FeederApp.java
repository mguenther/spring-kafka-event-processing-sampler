package net.mguenther.springkafka.eventprocessing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Markus Günther (markus.guenther@gmail.com)
 * @author Boris Fresow (bfresow@gmail.com)
 */
@SpringBootApplication
public class FeederApp {

    public static void main(String[] args) {
        SpringApplication.run(FeederApp.class, args);
    }
}
