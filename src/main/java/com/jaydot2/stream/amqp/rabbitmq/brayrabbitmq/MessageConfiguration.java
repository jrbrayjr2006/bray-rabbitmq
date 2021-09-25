package com.jaydot2.stream.amqp.rabbitmq.brayrabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;

import java.util.function.Consumer;

@Slf4j
@Configuration
public class MessageConfiguration {

    @Bean
    public Consumer<Flux<String>> consumeFitnessEvent() {
        return input -> input
                .map(message -> {
                    log.info("processing fitness event " + message);
                    return message;
                })
                .subscribe();
    }
}
