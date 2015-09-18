/**
 *
 */
package com.homeaway.bigdata.samza.task;

import org.apache.samza.system.IncomingMessageEnvelope;
import org.apache.samza.task.MessageCollector;
import org.apache.samza.task.TaskCoordinator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Unit Test for SimpleStreamTask
 */
@RunWith(MockitoJUnitRunner.class)
public class SimpleStreamTaskTest {
    @Mock
    private IncomingMessageEnvelope envelope;

    @Mock
    private TaskCoordinator coordinator;

    @Mock
    private MessageCollector collector;

    @Test
    public void assertTaskWorks() {
    }

}
