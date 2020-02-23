package uk.co.crunch.platform.api.cloud.config;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CloudConfigProfilesUnitTest {
    @Test
    @CloudConfigProfiles("security")
    public void testSingle() throws NoSuchMethodException {
        final CloudConfigProfiles ann = this.getClass().getMethod("testSingle").getAnnotation(CloudConfigProfiles.class);
        assertThat(ann.value()).isEqualTo(new String[]{"security"});
    }

    @Test
    @CloudConfigProfiles({"a", "b"})
    public void testMultiple() throws NoSuchMethodException {
        final CloudConfigProfiles ann = this.getClass().getMethod("testMultiple").getAnnotation(CloudConfigProfiles.class);
        assertThat(ann.value()).isEqualTo(new String[]{"a", "b"});
    }
}
