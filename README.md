# Bray RabbitMQ with Reactive Spring Cloud Stream

## Overview

This sample project has been upgraded to use Reactive Spring Cloud Streams

## Configuration

### Gradle Configuration

There are a few key dependencies that must be included in the `gradle.build` file of the application project.

### Application Configuration

A YAML file is used to configure the desired exchanges and queues when using the Spring Cloud Stream framework.

```yaml
spring:
  cloud:
    stream:
      function:
        definition: consumeFitnessEvent
      bindings:
        fitnessExercise-in-0:
          destination: fitness-events
```

## Implementation Details
This section describes how the application sends and recieves messages.

### Message Consumer

When sending messages using the Spring Stream methodology, an interface is created with has at least one method signature that returns a `org.springframework.messaging.MessageChannel`

```java
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface OutputStream {

    static final String OUTPUT_CHANNEL = "output-channel";

    @Output(OutputStream.OUTPUT_CHANNEL)
    public MessageChannel output();
}
```

The `MessageChannel` can be used to send the message.

### Receiving Messages

When receiving messages using the Spring Stream methodology, an interface is created with has at least one method signature that returns a `org.springframework.messaging.SubscribableChannel`

A sample interface is shown in the code snippet below:

```java
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface InputStream {

    static final String INPUT_CHANNEL = "input-channel";

    @Input(InputStream.INPUT_CHANNEL)
    public SubscribableChannel input();
}
```

### Enabling Binding

The channels must be bound to the context in order for Spring Cloud Stream to work.

An example is shown below:

```java
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
```

### Running the Application

The application can be run by using the gradle command `./gradlew bootRun` in the root of the application project.

## Testing

Below is a sample test.

```java
import com.jaydot2.reactive.reactiveexample.domain.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PersonRepositoryTest {

    PersonRepository personRepository;

    @BeforeEach
    void setUp() {
        personRepository = new PersonRepositoryImpl();
    }

    @Test
    void getByIdBlock() {
        // Given
        Integer id = 1;
        // When
        Mono<Person> personMono = personRepository.getById(id);
        Person person = personMono.block();
        System.out.println(person.toString());

        //Then
        assertThat(person.getFirstName()).isEqualTo("Michael");
    }

    @Test
    void testFluxToMonoList() {
        Flux<Person> personFlux = personRepository.findAll();

        Mono<List<Person>> personMonoList = personFlux.collectList();

        personMonoList.subscribe(list -> {
            list.forEach(person -> {
                System.out.println(person.toString());
            });
        });
    }
}
}

```

## Reference
