package com.jaydot2.stream.amqp.rabbitmq.brayrabbitmq.controller;

import com.jaydot2.stream.amqp.rabbitmq.brayrabbitmq.model.SampleMessage;
import com.jaydot2.stream.amqp.rabbitmq.brayrabbitmq.processor.MessageProcessor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class SampleController {

    private MessageProcessor processor;

    public SampleController(MessageProcessor processor) {
        this.processor = processor;
    }

    @GetMapping( value = "/", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Map<String, String> home() {
        Map<String, String> result = new HashMap<>();
        result.put("data", "Welcome to the sample application");
        return result;
    }

    @PostMapping( value = "/send", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Map<String, String> postMessageToQueue() {
        Map<String, String> result = new HashMap<>();
        SampleMessage message = new SampleMessage("123456-id", "john", "doe");
        this.processor.convertAndSend(message);
        result.put("queue", "unknown");
        return result;
    }

    @PostMapping( value = "/getMessage", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Object getMessageFromQueue() {
        return null;
    }
}
