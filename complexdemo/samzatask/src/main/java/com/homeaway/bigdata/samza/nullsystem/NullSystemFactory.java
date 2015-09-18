/**
 *
 */
package com.homeaway.bigdata.samza.nullsystem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.samza.config.Config;
import org.apache.samza.metrics.MetricsRegistry;
import org.apache.samza.system.IncomingMessageEnvelope;
import org.apache.samza.system.OutgoingMessageEnvelope;
import org.apache.samza.system.SystemAdmin;
import org.apache.samza.system.SystemConsumer;
import org.apache.samza.system.SystemFactory;
import org.apache.samza.system.SystemProducer;
import org.apache.samza.system.SystemStreamMetadata;
import org.apache.samza.system.SystemStreamPartition;


/**
 * Null system factory for samza jobs that don't write to anything
 */
public class NullSystemFactory implements SystemFactory {

    @Override
    public SystemAdmin getAdmin(String systemName, Config config) {
        return new SystemAdmin() {

            @Override
            public void createChangelogStream(String arg0, int arg1) {}

            @Override
            public void createCoordinatorStream(String arg0) {}

            @Override
            public Map<SystemStreamPartition, String> getOffsetsAfter(Map<SystemStreamPartition, String> arg0) {
                return new HashMap<>();
            }

            @Override
            public Map<String, SystemStreamMetadata> getSystemStreamMetadata(Set<String> arg0) {
                return new HashMap<>();
            }
        };
    }

    @Override
    public SystemConsumer getConsumer(String systemName, Config config, MetricsRegistry registry) {
        return new SystemConsumer() {

            @Override
            public void stop() {}

            @Override
            public void start() {}

            @Override
            public void register(SystemStreamPartition systemStreamPartition, String offset) {}

            @Override
            public Map<SystemStreamPartition, List<IncomingMessageEnvelope>> poll(Set<SystemStreamPartition> systemStreamPartitions, long timeout)
                throws InterruptedException {
                return new HashMap<>();
            }
        };
    }

    @Override
    public SystemProducer getProducer(String arg0, Config arg1, MetricsRegistry registry) {
        return new SystemProducer() {

            @Override
            public void stop() {}

            @Override
            public void start() {}

            @Override
            public void send(String source, OutgoingMessageEnvelope envelope) {}

            @Override
            public void register(String source) {}

            @Override
            public void flush(String source) {}
        };
    }
}
