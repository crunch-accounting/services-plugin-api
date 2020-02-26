package uk.co.crunch.platform.api.cloud.config;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

@CloudConfigProfiles({"a", "b"})
public class CloudConfigMultipleProfilesUnitTest {
    @Test
    public void testMultiple() {
        final CloudConfigProfiles ann = this.getClass().getAnnotation(CloudConfigProfiles.class);
        assertThat(ann.value()).isEqualTo(new String[]{"a", "b"});
    }
}
