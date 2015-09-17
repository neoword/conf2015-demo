package com.homeaway.bigdata;

import org.apache.kafka.clients.producer.Producer;

import com.homeaway.bigdata.core.MessageEvent;
import com.homeaway.bigdata.health.SimpleHealthCheck;
import com.homeaway.bigdata.resources.LogResource;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class ComplexappApplication extends Application<ComplexappConfiguration> {

    public static void main(final String[] args) throws Exception {
        new ComplexappApplication().run(args);
    }

    @Override
    public String getName() {
        return "complexapp";
    }

    @Override
    public void initialize(final Bootstrap<ComplexappConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final ComplexappConfiguration configuration, final Environment environment) {
        environment.healthChecks().register("simple", new SimpleHealthCheck());
        Producer<String, MessageEvent> producer = configuration.getProducer();
        environment.jersey().register(new LogResource(producer, configuration.getTopic()));
    }

}
