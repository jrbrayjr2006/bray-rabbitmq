package com.jaydot2.stream.amqp.rabbitmq.brayrabbitmq.processor;

import com.jaydot2.stream.amqp.rabbitmq.brayrabbitmq.model.SampleMessage;
import com.jaydot2.stream.amqp.rabbitmq.brayrabbitmq.stream.InputStream;
import com.jaydot2.stream.amqp.rabbitmq.brayrabbitmq.stream.OutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(OutputStream.class)
public class MessageProcessor {

    @Autowired
    OutputStream outputStream;

    @SendTo(OutputStream.OUTPUT_CHANNEL)
    public void convertAndSend(SampleMessage message) {
        Message<SampleMessage> outMessage = MessageBuilder.withPayload(message).build();
        outputStream.output().send(outMessage);
    }

}
