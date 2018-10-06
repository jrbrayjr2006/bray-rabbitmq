package com.jaydot2.stream.amqp.rabbitmq.brayrabbitmq.stream;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface OutputStream {

    static final String OUTPUT_CHANNEL = "output-channel";

    @Output(OutputStream.OUTPUT_CHANNEL)
    public MessageChannel output();
}
