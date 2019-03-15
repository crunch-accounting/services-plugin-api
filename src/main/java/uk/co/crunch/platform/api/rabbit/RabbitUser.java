package uk.co.crunch.platform.api.rabbit;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Tells the plugin to generate certain bootstrap entries for config-service.
 * @apiNote All of that is turned off in test mode.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface RabbitUser {

    String customRoleName() default "";

    String readPrivs() default ".*";
    String writePrivs() default ".*";
    String configPrivs() default ".*";
}
