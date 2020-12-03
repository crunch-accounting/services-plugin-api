package uk.co.crunch.platform.api.tyk;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Add to a REST controller that exposes public-facing endpoints, and that a Tyk key cannot be required
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface PublicRestEndpoints {
}
