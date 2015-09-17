/**
 *
 */
package com.homeaway.bigdata.resources;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.errors.SerializationException;

import com.homeaway.bigdata.core.MessageEvent;
import com.homeaway.bigdata.core.Response;

/**
 * Simple jersey resource for logging a NUMBER_OF_REPS messages to a kafka topic
 */
@Path("/log")
@Produces(MediaType.APPLICATION_JSON)
public class LogResource {
    private static final int NUMBER_OF_REPS = 100;

    private Producer<String,MessageEvent> producer;
    private String topic;

    public LogResource(Producer<String,MessageEvent> producer, String topic) {
        this.producer = producer;
        this.topic = topic;
    }

    private int dieroll(int sides) {
        return (int)(Math.random()*sides) + 1;
    }

    @GET
    public Response log() {
        try {
            InetAddress ip = Inet4Address.getLocalHost();
            String hostname = ip.getHostName();
            for(int i=0;i<NUMBER_OF_REPS;++i) {
                long time = System.currentTimeMillis();
                // probability from 3-18
                int weight = dieroll(6) + dieroll(6) + dieroll(6);
                // INT ... such irony
                String msg = String.format("int=%d idx=%d", weight, i);
                // build our event
                MessageEvent messageEvent = MessageEvent.newBuilder()
                    .setTime(time)
                    .setHost(hostname)
                    .setMessage(msg)
                    .build();
                // use this for our key for partitioning (scaling)
                String key = hostname;

                ProducerRecord<String, MessageEvent> record = new ProducerRecord<>(topic, key, messageEvent);
                producer.send(record);
            }
        } catch (SerializationException exception) {
            throw new IllegalStateException("Could not log", exception);
        } catch (UnknownHostException exception) {
            throw new IllegalStateException("Could not log", exception);
        }

        return new Response(System.currentTimeMillis(), "FINISHED");
    }
}
