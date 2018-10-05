package com.jaydot2.stream.amqp.rabbitmq.brayrabbitmq.stream;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(value = {InputStream.class})
public class StreamHandler implements MessageHandler {

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    InputStream inputStream;


    @ServiceActivator(inputChannel = InputStream.INPUT_CHANNEL)
    @Override
    public void handleMessage(Message<?> message) throws MessagingException {
        String payload = (String)message.getPayload();

        //TODO use object mapper to marshall payload to object
    }
}
