kafka-producer-perf-test --payload-file payload.json \
--producer.config ~/data/ccloud/flink0.config \
--num-records 1000000 \
--topic source-topic \
--throughput 200
