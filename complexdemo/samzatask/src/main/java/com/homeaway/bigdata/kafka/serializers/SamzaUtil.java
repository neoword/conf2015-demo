/**
 *
 */
package com.homeaway.bigdata.kafka.serializers;

import java.util.Properties;

/**
 * Utility class for kafka encoder/decoder at homeaway to be used in Samza
 * @author rparra
 */
public class SamzaUtil {
    private SamzaUtil() {}

    public static Properties enhanceProperties(Properties props) {
        /*
        // TODO figure out a way to not hardcode
        // when this was first attempted, apparently samza will 'eagerly' try to convert any serializer setting that ends
        // with .class into a Serde.  That is not what we want to do with these two properties since they are for the
        // HomeAway-specific AvroMessageEncoder/Decoder
        props.setProperty(AvroSchemaLibrary.AVRO_LIBRARY_CLASS_NAME, "com.homeaway.commons.logging.codecs.cache.CacheAvroSchemaLibrary");
        props.setProperty(CacheAvroSchemaLibrary.CACHE_LIBRARY_IMPL_CLASSNAME, "com.homeaway.commons.logging.codecs.http.HttpAvroSchemaLibrary");
        return props;
        */
        return props;
    }
}
