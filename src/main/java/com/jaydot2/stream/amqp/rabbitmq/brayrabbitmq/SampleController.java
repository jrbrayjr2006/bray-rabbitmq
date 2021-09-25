package com.jaydot2.stream.amqp.rabbitmq.brayrabbitmq;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@AllArgsConstructor
@RestController("/fitness")
public class SampleController {

    private SampleService sampleService;

    @GetMapping( value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<String> home() {
        return null;
    }

    @PostMapping( value = "/send", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<String> postMessageToQueue() {
        return null;
    }

    @GetMapping( value = "/getMessage", produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<String> getMessagesFromQueue() {
        return null;
    }
}
