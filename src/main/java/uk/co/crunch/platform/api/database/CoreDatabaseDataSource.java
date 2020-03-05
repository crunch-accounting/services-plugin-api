package uk.co.crunch.platform.api.database;

import uk.co.crunch.platform.api.cloud.config.CloudConfigProfiles;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@CloudConfigProfiles("core-data-client")
public @interface CoreDatabaseDataSource {

    // Grants default to read-only, but we surely have to be able to support the same range as we do for Platform DB
    // Schema name is not configurable either - it's fixed but environment-specific and set by Config

    String grants() default "SELECT";

    boolean dualDataSources() default false;  // Allow both Core and Platform DataSources to co-exist
}
