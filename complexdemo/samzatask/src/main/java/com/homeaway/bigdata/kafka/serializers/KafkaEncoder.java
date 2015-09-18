/**
 * 2015-current. Copyright HomeAway, Inc. All Rights Reserved.
 */
package com.homeaway.bigdata.kafka.serializers;

import org.apache.avro.generic.IndexedRecord;

import kafka.serializer.Encoder;
import kafka.utils.VerifiableProperties;

/**
 * Kafka encoder that encodes objects using the avro schema service
 */
public class KafkaEncoder implements Encoder<IndexedRecord>{
    // private AvroMessageEncoder encoder;

    public KafkaEncoder(VerifiableProperties vprops) {
        /*
        String topic = vprops.getString("topic");
        this.encoder = new AvroMessageEncoder();
        encoder.init(SamzaUtil.enhanceProperties(vprops.props()), topic);
        */
    }

    @Override
    public byte[] toBytes(IndexedRecord record) {
        /*
        return encoder.toBytes(record);
        */
        return null;
    }
}
