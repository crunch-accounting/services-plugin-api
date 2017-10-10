package uk.co.crunch.platform.api.rabbit;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface RabbitUser {

    String customRoleName() default "";
    Instance instance() default @Instance;

    String readPrivs() default ".*";
    String writePrivs() default ".*";
    String configPrivs() default ".*";

    @interface Instance {
        String host() default "rabbitmq.service.consul";
        int port() default 15672;
        String customConfigName() default "";
    }
}
