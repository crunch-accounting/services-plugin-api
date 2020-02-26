package uk.co.crunch.platform.api.cloud.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Additional Spring profiles to be injected at bootstrap time, presumably to add grouping of services into stacks/clusters with shared config
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface CloudConfigProfiles {
    String[] value();
}
