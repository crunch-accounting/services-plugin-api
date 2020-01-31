package uk.co.crunch.platform.api.tyk;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Allows a service to opt-in to allowing external API access through Tyk
// Specify the names of preconfigured Tyk tokens which are required: on Test/PreProd, and Production environments
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface EnableIngressFromOutsidePlatform {
    String[] testTokens() default {"master-test-tokens"};
    String[] productionTokens() default {};  // no universal default for Production
}
