# crunch-services-plugin-api

A set of classes and annotations to allow platform dependencies to be specified - and suitable CloudFormation JSON to be generated - that can't be determined via Maven dependencies.

## Contrived example:

    @PlatformComponent(name="FeatureService", fromPort=8080, toPort=8080),
    @PlatformComponent(name="RabbitMq", fromPort=5672, toPort=5672),
    @PlatformComponent(name="Rds", fromPort=3006, toPort=3006)
    public class MyComponentImpl {
    }

----

## How to configure in your own project:

Add the following to your POM:

    <dependency>
        <groupId>uk.co.crunch</groupId>
        <artifactId>crunch-services-plugin-api</artifactId>
        <version>1.0.1</version>
    </dependency>
