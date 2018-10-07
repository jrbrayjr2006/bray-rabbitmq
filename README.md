# Bray rabbitmq

## Overview

This is a sample Java Spring based RabbitMQ messaging project.  It is designed to test and demonstrate messaging.

## Configuration

### Gradle Configuration

There are a few key dependencies that must be included in the `gradle.build` file of the application project.

Dependency management should be included to allow curated versions of the dependencies to be incorporated into the project.

```groovy
dependencyManagement {
	imports {
		mavenBom 'org.springframework.cloud:spring-cloud-stream-dependencies:Elmhurst.SR1'
	}
}
```

The example above uses the `Elmhurst.SR1` version of the Spring Cloud Stream dependencies, but other versions could be used as well.

The dependencies that should be included for Spring Cloud Stream are shown in the code snippet below:

```groovy
dependencies {
	...
	implementation('org.springframework.cloud:spring-cloud-starter-stream-rabbit')
	implementation('org.springframework.boot:spring-boot-starter-web')
	...
	// test dependencies
	testImplementation('org.springframework.boot:spring-boot-starter-test')
	testImplementation('org.springframework.cloud:spring-cloud-stream-test-support')
	...
}
```

### Application Configuration

A YAML file is used to configure the desired exchanges and queues when using the Spring Cloud Stream framework.

```yaml
spring:
  cloud:
    stream:
      defaultBinder: local_rabbit
      bindings:
        input-channel:
          destination: jaydot2.input.channel
          binder: local_rabbit
          contentType: application/json
          group: queue
        output-channel:
          destination: jaydot2.output.channel
          binder: local_rabbit
          contentType: application/json
          producer:
            requiredGroups: queue
      binders:
        local_rabbit:
          type: rabbit
          environment:
            spring:
              rabbitmq:
                host: localhost
                port: 5672
                username: guest
                password: guest
```

## Implementation Details
This section describes how the application sends and recieves messages.

### Sending Messages

When sending messages using the Spring Stream methodology, an interface is created with has at least one method signature that returns a `org.springframework.messaging.MessageChannel`
### Receiving Messages

### Running the Application

The application can be run by using the gradle command `./gradlew bootRun` in the root of the application project.

## Testing

## Reference

1. [Messaging with AMQP and RabbitMQ Support](https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-messaging.html#boot-features-amqp)
2. [Introduction to Spring Cloud Stream](https://www.baeldung.com/spring-cloud-stream)
3. [Setting up RabbitMQ with Spring Cloud Stream](https://www.e4developer.com/2018/01/28/setting-up-rabbitmq-with-spring-cloud-stream/)
