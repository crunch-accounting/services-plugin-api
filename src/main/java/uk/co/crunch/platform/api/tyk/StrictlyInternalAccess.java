package uk.co.crunch.platform.api.tyk;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Add anywhere to denote that the service must be private, and that a Tyk key is required
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface StrictlyInternalAccess {
    String[] value();
}
