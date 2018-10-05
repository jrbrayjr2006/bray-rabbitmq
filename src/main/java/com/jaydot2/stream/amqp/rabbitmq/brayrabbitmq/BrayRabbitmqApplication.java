package com.jaydot2.stream.amqp.rabbitmq.brayrabbitmq;

import com.jaydot2.stream.amqp.rabbitmq.brayrabbitmq.stream.InputStream;
import com.jaydot2.stream.amqp.rabbitmq.brayrabbitmq.stream.OutputStream;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableBinding( value = {InputStream.class, OutputStream.class})
public class BrayRabbitmqApplication {

	public static void main(String[] args) {
		SpringApplication.run(BrayRabbitmqApplication.class, args);
	}
}
