package uk.co.crunch.platform.api.k8s;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

@RbacRolePermission(resources = "pods", verbs = {"get", "watch", "list"})
@RbacRolePermission(apiGroups = "a", resources = "configmaps", verbs = "watch")
public class RbacRolePermissionListUnitTest {

    @Test
    public void testSingle() throws NoSuchMethodException {
        var perms = this.getClass().getAnnotation(RbacRolePermissions.class).value();

        assertThat(perms[0].apiGroups()).containsExactly("");
        assertThat(perms[0].resources()).containsExactly("pods");
        assertThat(perms[0].verbs()).containsExactly("get", "watch", "list");

        assertThat(perms[1].apiGroups()).containsExactly("a");
        assertThat(perms[1].resources()).containsExactly("configmaps");
        assertThat(perms[1].verbs()).containsExactly("watch");
    }
}
