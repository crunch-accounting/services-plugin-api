package uk.co.crunch.platform.api.database;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface MySqlDataSource {

    String schema();
    String customConfigName() default "";
    Instance instance() default @Instance;
    String grants() default "ALL";

    @interface Instance {
        String host() default "rds.service.consul";
        int port() default 3306;
        String customConfigName() default "";
    }
}
