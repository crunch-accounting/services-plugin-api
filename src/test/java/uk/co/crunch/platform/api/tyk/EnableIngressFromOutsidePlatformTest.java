package uk.co.crunch.platform.api.tyk;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EnableIngressFromOutsidePlatformTest {

    @EnableIngressFromOutsidePlatform
    @Test
    public void testDefaults() throws NoSuchMethodException {
        final EnableIngressFromOutsidePlatform ann = this.getClass().getMethod("testDefaults").getAnnotation(EnableIngressFromOutsidePlatform.class);

        assertThat(ann.testTokens()).containsExactly("master-test-tokens");
        assertThat(ann.productionTokens()).isEmpty();
    }

    @EnableIngressFromOutsidePlatform(productionTokens = {"core", "iosApp", "AndroidApp"})
    @Test
    public void testCoreAndAppAccess() throws NoSuchMethodException {
        final EnableIngressFromOutsidePlatform ann = this.getClass().getMethod("testCoreAndAppAccess").getAnnotation(EnableIngressFromOutsidePlatform.class);

        assertThat(ann.testTokens()).containsExactly("master-test-tokens");
        assertThat(ann.productionTokens()).containsExactlyInAnyOrder("iosApp", "AndroidApp", "core");
    }

    @EnableIngressFromOutsidePlatform(testTokens = {"a", "b"}, productionTokens = {"c"})
    @Test
    public void testCustomisationOfBoth() throws NoSuchMethodException {
        final EnableIngressFromOutsidePlatform ann = this.getClass().getMethod("testCustomisationOfBoth").getAnnotation(EnableIngressFromOutsidePlatform.class);

        assertThat(ann.testTokens()).containsExactlyInAnyOrder("a", "b");
        assertThat(ann.productionTokens()).containsExactlyInAnyOrder("c");
    }
}
