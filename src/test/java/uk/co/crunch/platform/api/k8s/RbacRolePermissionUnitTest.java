package uk.co.crunch.platform.api.k8s;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

@RbacRolePermission(resources = "pods", verbs = {"get", "watch", "list"})
public class RbacRolePermissionUnitTest {

    @Test
    public void testSingle() throws NoSuchMethodException {
        var ann = this.getClass().getAnnotation(RbacRolePermission.class);

        assertThat(ann.apiGroups()).containsExactly("");
        assertThat(ann.resources()).containsExactly("pods");
        assertThat(ann.verbs()).containsExactly("get", "watch", "list");
    }
}
