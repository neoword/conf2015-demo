package com.homeaway.bigdata;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.homeaway.bigdata.core.MessageEvent;

import io.dropwizard.Configuration;

public class ComplexappConfiguration extends Configuration {
    @NotEmpty
    private String kafkaBrokers;
    @NotEmpty
    private String schemaRegistryUrl;
    @NotEmpty
    private String topic;

    @JsonProperty
    public String getKafkaBrokers() {
        return kafkaBrokers;
    }
    @JsonProperty
    public void setKafkaBrokers(String kafkaBrokers) {
        this.kafkaBrokers = kafkaBrokers;
    }


    @JsonProperty
    public String getSchemaRegistryUrl() {
        return schemaRegistryUrl;
    }
    @JsonProperty
    public void setSchemaRegistryUrl(String schemaRegistryUrl) {
        this.schemaRegistryUrl = schemaRegistryUrl;
    }

    @JsonProperty
    public String getTopic() {
        return topic;
    }
    @JsonProperty
    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Producer<String,MessageEvent> getProducer() {
        Properties props = new Properties();
        // props.put("key.serializer.class", "kafka.serializer.StringEncoder");
        // props.put("serializer.class", "io.confluent.kafka.serializers.KafkaAvroEncoder");
        // props.put("metadata.broker.list", kafkaBrokers);
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaBrokers);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, io.confluent.kafka.serializers.KafkaAvroSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, io.confluent.kafka.serializers.KafkaAvroSerializer.class);
        props.put("schema.registry.url", schemaRegistryUrl);

        // make it async for speed!
        props.put("producer.type", "async");
        // this demarcates us as "us"
        props.put("client.id", "complexapp");
        // maximum queue size
        props.put("queue.buffering.max.messages", "100000");
        // how long to wait before flushing if batch size has not been reached
        props.put("queue.buffering.max.ms", "250");
        // max batch size before sending
        props.put("batch.num.messages", "1000");
        // "packet" size for sending to kafka
        props.put("send.buffer.bytes", "5242880");
        // if queue is full, max time to wait before dropping messages
        props.put("queue.enqueue.timeout.ms", "0");
        // if async, max time to wait on graceful shutdown
        props.put("producer.shutdown.wait.ms", "3000");
        // time to wait before refreshing topic-partition leader metadata
        props.put("topic.metadata.refresh.interval.ms", "600000");

        return new KafkaProducer<String,MessageEvent>(props);
    }
}
