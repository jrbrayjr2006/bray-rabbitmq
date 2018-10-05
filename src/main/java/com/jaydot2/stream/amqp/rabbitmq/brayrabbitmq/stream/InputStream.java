package com.jaydot2.stream.amqp.rabbitmq.brayrabbitmq.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface InputStream {

    static final String INPUT_CHANNEL = "input-channel";

    @Input()
    public SubscribableChannel input();
}
