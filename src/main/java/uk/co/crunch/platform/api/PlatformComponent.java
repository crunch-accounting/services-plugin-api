package uk.co.crunch.platform.api;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface PlatformComponent {

    String name();
    String ipProtocol() default "tcp";
    // String groupIdRef() default "";
    int fromPort();
    int toPort();
    // Direction direction() default Direction.INGRESS;
}
