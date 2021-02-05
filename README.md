# Spring Kafka for Event Processing

[![Build Status](https://travis-ci.org/mguenther/spring-kafka-event-processing-sampler.svg?branch=master)](https://travis-ci.org/mguenther/spring-kafka-event-processing-sampler.svg)

This repository contains a simple solution that demonstrates the integration of Kafka into a Spring Boot application using [Spring for Apache Kafka](https://spring.io/projects/spring-kafka) (2.6.5), while leveraging Apache Avro as serialization framework for encoding events that are persisted to a Kafka log. The code presented in this repository is the joint work of [Boris Fresow](mailto://bfresow@gmail.com) and [Markus Günther](mailto://markus.guenther@gmail.com) as part of an article series on **Building Event-based applications with Spring Kafka** for the German [JavaMagazin](https://jaxenter.de/magazine/java-magazin).

## Modules

This repository is structured into several smaller Maven modules, each highlighting a different aspect.

| Module | Purpose |
| ------ | ------- |
| `springkafka-eventprocessing-serialization` | Contains the Avro schema for turbine metrics and the auto-generated Java types for it. |
| `springkafka-eventprocessing-generator` | Periodically generates turbine metrics and writes them to a Kafka log. Integrates Avro using `TurbineMetricsSerializer`, a custom Kafka serializer that is able to map instances of `TurbineMetrics` to a `byte[]`. |
| `springkafka-eventprocessing-feeder` | Implements a batch consumer that reads `TurbineMetrics` of a Kafka log and processes them. This might be the basis for a simple feeder application that reads and transforms data before committing it to another system, e.g. an Elasticsearch cluster. Integrates Avro using `TurbineMetricsDeserializer`, a custom Kafka deserializer that is able to map `byte[]` to a instance of `TurbineMetrics` for further processing. |

## Prerequisites

Running the showcase requires a working installation of Apache ZooKeeper and Apache Kafka. Please make sure that [Docker](https://docs.docker.com/engine/installation/) as well as [Docker Compose](https://docs.docker.com/compose/install/) are installed on your system.

### Versions

| Application         | Version   | Docker Image            |
| ------------------- | --------- | ----------------------- |
| Apache Kafka        | 2.6.0  | wurstmeister/kafka:2.13-2.6.0     |
| Apache ZooKeeper    | 3.4.13   | wurstmeister/zookeeper |

### Building and Running the Containers

Start the resp. containers using the provided `docker-compose` script (cf. `docker/docker-compose.yml`). Simply issue

```bash
$ docker-compose up
```

for starting Apache Kafka and Apache Zookeeper. Stopping the containers is best done using a separate terminal and issuing the following commands.

```bash
$ docker-compose stop
$ docker-compose rm
```

The final ```rm``` operation deletes the containers and thus clears all state so you can start over with a clean installation.

For simplicity, we restrict the Kafka cluster to a single Kafka broker. However, scaling to more Kafka brokers is easily done via `docker-compose`. You will have to provide a sensible value for `KAFKA_ADVERTISED_HOST_NAME` (other than `localhost`) for this to work, though. 

```bash
$ docker-compose scale kafka=3   # scales up to 3 Kafka brokers
$ docker-compose scale kafka=1   # scales down to 1 Kafka broker after the previous upscale
```

After changing the number of Kafka brokers, give the cluster some time so that all brokers can finish their cluster-join procedure. This should complete in a couple of seconds and you can inspect the output of the resp. Docker containers just to be sure that everything is fine. Kafka Manager should also reflect the change in the number of Kafka brokers after they successfully joined the cluster.

## License

This work is released under the terms of the MIT license.
