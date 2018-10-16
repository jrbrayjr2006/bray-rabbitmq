package com.jaydot2.stream.amqp.rabbitmq.brayrabbitmq.stream;

//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
import com.jaydot2.stream.amqp.rabbitmq.brayrabbitmq.model.SampleMessage;
import org.junit.Test;
import org.junit.Before;
//import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.test.binder.MessageCollector;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.BlockingQueue;

//import static org.assertj.core.api.Assertions.assertThat;
//import static org.hamcrest.Matchers.is;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.Assert.assertNotNull;
//import static org.springframework.cloud.stream.test.matcher.MessageQueueMatcher.receivesPayloadThat;

//@ExtendWith(SpringExtension.class)
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MessagingTest {

    @Autowired
    OutputStream channels;

    @Autowired
    MessageCollector collector;

    @Before
    public void setUp() {
        //
    }

    //@Test
    public void testMessages() {
        BlockingQueue<Message<?>> messages = collector.forChannel(channels.output());

        //assertThat(messages, receivesPayloadThat(is("sample")));
    }

    @Test
    public void shouldSendMessageTest() {
        SampleMessage payload = new SampleMessage("some-id", "MyFirstName", "MyLastName");  //TODO flesh this out
        channels.output().send(MessageBuilder.withPayload(payload).build());
        Message received = (Message) collector.forChannel(channels.output()).poll();
        assertNotNull(received.getPayload());
    }
}
