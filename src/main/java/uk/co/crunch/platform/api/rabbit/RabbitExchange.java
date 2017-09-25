package uk.co.crunch.platform.api.rabbit;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface RabbitExchange {

    Command[] commands() default {};
    Event[] events() default {};
    String name();

    @interface Command {
        String name();
        String routingKey();
    }

    @interface Event {
        String name();
        String routingKey();
        Queue queue();
    }

    @interface Queue {
        String name();
        String version();
    }
}