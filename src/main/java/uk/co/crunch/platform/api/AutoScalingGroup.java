package uk.co.crunch.platform.api;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface AutoScalingGroup {
    int minSize() default 2;
    int desired() default 2;
    int maxSize() default 2;
}
