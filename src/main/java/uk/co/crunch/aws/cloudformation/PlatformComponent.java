package uk.co.crunch.aws.cloudformation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface PlatformComponent {

    String name();  // FIXME Must be normalised
    String ipProtocol() default "ip";
    String groupIdRef() default "";
    int fromPort();
    int toPort();
    Direction direction() default Direction.INGRESS;
}
