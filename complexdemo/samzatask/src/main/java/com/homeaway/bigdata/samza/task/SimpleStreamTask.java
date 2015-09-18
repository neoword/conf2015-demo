/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package com.homeaway.bigdata.samza.task;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.avro.generic.GenericData.Record;
import org.apache.samza.system.IncomingMessageEnvelope;
import org.apache.samza.system.OutgoingMessageEnvelope;
import org.apache.samza.system.SystemStream;
import org.apache.samza.task.MessageCollector;
import org.apache.samza.task.StreamTask;
import org.apache.samza.task.TaskCoordinator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This task is very simple. All it does is take messages that it receives, and
 * sends them to a Kafka topic called wikipedia-raw.
 */
public class SimpleStreamTask implements StreamTask {
    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleStreamTask.class);
    private static final SystemStream NULL_SYSTEM = new SystemStream("null","null");
    private static final Pattern REGEX = Pattern.compile("int=([0-9]*) idx=([0-9]*)");

    @Override
    public void process(IncomingMessageEnvelope envelope, MessageCollector collector, TaskCoordinator coordinator) {
        Record record = (Record) envelope.getMessage();
        String message = (String) record.get("message");

        Matcher matcher = REGEX.matcher(message);
        if(matcher.find()) {
            int intelligence=Integer.valueOf(matcher.group(1));
            if(intelligence>16) {
                LOGGER.info("{}", record);
            }
        }

        // for unit-test demonstration purposes
        collector.send(new OutgoingMessageEnvelope(NULL_SYSTEM, message));
    }
}
