package uk.co.crunch.platform.api.publicapi;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface PublicApiVersion {
    int domainApiVersion();

    int publicFacingVersion();
}
