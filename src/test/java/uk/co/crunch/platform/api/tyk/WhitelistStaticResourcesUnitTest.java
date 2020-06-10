package uk.co.crunch.platform.api.tyk;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WhitelistStaticResourcesUnitTest {
    @WhitelistStaticResources("/onePath")
    @Test
    public void testSingle() throws NoSuchMethodException {
        final WhitelistStaticResources ann = this.getClass().getMethod("testSingle").getAnnotation(WhitelistStaticResources.class);
        assertThat(ann.value()).containsExactly("/onePath");
    }

    @WhitelistStaticResources({"/a", "/b", "/c"})
    @Test
    public void testMultiplePaths() throws NoSuchMethodException {
        final WhitelistStaticResources ann = this.getClass().getMethod("testMultiplePaths").getAnnotation(WhitelistStaticResources.class);
        assertThat(ann.value()).containsExactly("/a", "/b", "/c");
    }
}
