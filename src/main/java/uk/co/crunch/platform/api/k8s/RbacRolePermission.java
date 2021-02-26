package uk.co.crunch.platform.api.k8s;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Repeatable(RbacRolePermissions.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
public @interface RbacRolePermission {
    String[] apiGroups() default {""};
    String[] resources();
    String[] verbs();
}
