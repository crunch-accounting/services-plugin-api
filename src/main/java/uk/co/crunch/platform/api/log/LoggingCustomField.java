package uk.co.crunch.platform.api.log;

import java.lang.annotation.*;

@Repeatable(LoggingCustomFieldList.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface LoggingCustomField {
    String name();
    String[] values();
}
