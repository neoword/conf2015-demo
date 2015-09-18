/**
 * 2015-current. Copyright HomeAway, Inc. All Rights Reserved.
 */
package com.homeaway.bigdata.kafka.serializers;

import org.apache.avro.generic.IndexedRecord;

import kafka.serializer.Decoder;
import kafka.utils.VerifiableProperties;

/**
 * Kafka encoder that encodes objects using the avro schema service
 */
public class KafkaDecoder implements Decoder<IndexedRecord>{
    // private AvroMessageDecoder decoder;

    public KafkaDecoder(VerifiableProperties vprops) {
        /*
        String topic = vprops.getString("topic");
        this.decoder = new AvroMessageDecoder();
        decoder.init(SamzaUtil.enhanceProperties(vprops.props()), topic);
        */
    }

    @Override
    public IndexedRecord fromBytes(byte[] bytes) {
        /*
        CamusWrapper<Record> wrappedRecord = decoder.decode(bytes);
        return (IndexedRecord) wrappedRecord.getRecord();
        */
        return null;
    }
}
