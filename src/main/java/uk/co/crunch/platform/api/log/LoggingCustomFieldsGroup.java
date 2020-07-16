package uk.co.crunch.platform.api.log;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface LoggingCustomFieldsGroup {
    String name();
    LoggingCustomField[] value();
}
