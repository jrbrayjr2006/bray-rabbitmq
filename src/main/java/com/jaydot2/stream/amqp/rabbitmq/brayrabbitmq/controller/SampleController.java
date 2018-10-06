package com.jaydot2.stream.amqp.rabbitmq.brayrabbitmq.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class SampleController {

    @GetMapping( value = "/", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Map<String, String> home() {
        Map<String, String> result = new HashMap<>();
        result.put("data", "Welcome to the sample application");
        return result;
    }

    @PostMapping( value = "/send", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Map<String, String> postMessageToQueue() {
        Map<String, String> result = new HashMap<>();
        result.put("queue", "unknown");
        return result;
    }

    @PostMapping( value = "/getMessage", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Object getMessageFromQueue() {
        return null;
    }
}
