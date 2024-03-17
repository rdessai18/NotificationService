# NotificationService

## Kafka Topic Creation
1. Repository /Users/rjtdessai_18/Desktop/IntelliJ_Projects/Spring_Boot_Projects/Kafka
2. docker images
3. docker ps
4. docker-compose -f zk-single-kafka-single.yml
5. docker-compose -f zk-single-kafka-single.yml ps
6. docker exec -it kafka1 /bin/bash
7. kafka-topics --version
8. kafka-topics --create --topic emailTopic --bootstrap-server localhost:9092

## Logs
NAME      IMAGE                             COMMAND                  SERVICE   CREATED         STATUS          PORTS
kafka1    confluentinc/cp-kafka:7.3.2       "/etc/confluent/dock…"   kafka1    5 minutes ago   Up 35 seconds   0.0.0.0:9092->9092/tcp, 0.0.0.0:9999->9999/tcp, 0.0.0.0:29092->29092/tcp
zoo1      confluentinc/cp-zookeeper:7.3.2   "/etc/confluent/dock…"   zoo1      5 minutes ago   Up 35 seconds   2888/tcp, 0.0.0.0:2181->2181/tcp, 3888/tcp
r