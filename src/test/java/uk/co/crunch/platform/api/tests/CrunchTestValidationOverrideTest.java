package uk.co.crunch.platform.api.tests;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static uk.co.crunch.platform.api.tests.CrunchTestValidationOverrides.*;

@CrunchTestValidationOverride(KOTLIN_STRIKT_MIGRATION)
public class CrunchTestValidationOverrideTest {
    @Test
    @CrunchTestValidationOverride(HAMCREST_USAGE)
    public void testSingle() throws NoSuchMethodException {
        final CrunchTestValidationOverride ann = this.getClass().getMethod("testSingle").getAnnotation(CrunchTestValidationOverride.class);
        assertThat(ann.value()).isEqualTo(new CrunchTestValidationOverrides[]{HAMCREST_USAGE});
    }

    @Test
    public void testClassLevel() {
        final CrunchTestValidationOverride ann = this.getClass().getAnnotation(CrunchTestValidationOverride.class);
        assertThat(ann.value()).isEqualTo(new CrunchTestValidationOverrides[]{KOTLIN_STRIKT_MIGRATION});
    }

    @Test
    @CrunchTestValidationOverride({JUNIT4_ASSERTIONS, HAMCREST_USAGE})
    public void testMultiple() throws NoSuchMethodException {
        final CrunchTestValidationOverride ann = this.getClass().getMethod("testMultiple").getAnnotation(CrunchTestValidationOverride.class);
        assertThat(ann.value()).isEqualTo(new CrunchTestValidationOverrides[]{JUNIT4_ASSERTIONS, HAMCREST_USAGE});
    }
}
