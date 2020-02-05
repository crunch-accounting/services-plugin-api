package uk.co.crunch.platform.api.prometheus.alerts;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface ZeroToleranceErrorAlertRule {
    String name();
    String errorLabel();
    String timeRange() default "1m";
    String duration() default "1m";
    AlertSeverity severity() default AlertSeverity.WARNING;
    String team();
    String description();
    String summary() default "";
}
