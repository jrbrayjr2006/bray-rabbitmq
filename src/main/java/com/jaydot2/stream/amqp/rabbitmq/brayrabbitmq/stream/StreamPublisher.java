package com.jaydot2.stream.amqp.rabbitmq.brayrabbitmq.stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

@Service
public class StreamPublisher {

    @Autowired
    OutputStream outputStream;

    @SendTo(OutputStream.OUTPUT_CHANNEL)
    public String convertAndSend(Object obj) {
        return "{}";
    }
}
