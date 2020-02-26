package uk.co.crunch.platform.api.cloud.config;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

@CloudConfigProfiles("security")
public class CloudConfigSingleProfileUnitTest {
    @Test
    public void testSingle() {
        final CloudConfigProfiles ann = this.getClass().getAnnotation(CloudConfigProfiles.class);
        assertThat(ann.value()).isEqualTo(new String[]{"security"});
    }
}
