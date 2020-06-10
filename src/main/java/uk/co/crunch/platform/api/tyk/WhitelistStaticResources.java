package uk.co.crunch.platform.api.tyk;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Add anywhere to declare list of paths to whitelist, which will be aggregated to form a single set and passed via Swagger to Tyk. No additional Swagger context will be generated.
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface WhitelistStaticResources {
    String[] value();
}
