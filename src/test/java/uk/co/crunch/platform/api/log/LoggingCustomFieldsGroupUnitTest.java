package uk.co.crunch.platform.api.log;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

@LoggingCustomFieldsGroup(name = "buildInfo", value = {@LoggingCustomField(name = "version", values = "1.2.3"), @LoggingCustomField(name = "commit", values = "5451243523ed")})
public class LoggingCustomFieldsGroupUnitTest {

    @Test
    public void testGroup() throws NoSuchMethodException {
        final LoggingCustomFieldsGroup group = this.getClass().getAnnotation(LoggingCustomFieldsGroup.class);

        assertThat(group.name()).isEqualTo("buildInfo");
        assertThat(group.value()[0].name()).isEqualTo("version");
        assertThat(group.value()[0].values()).containsExactlyInAnyOrder("1.2.3");
        assertThat(group.value()[1].name()).isEqualTo("commit");
        assertThat(group.value()[1].values()).containsExactlyInAnyOrder("5451243523ed");
    }
}
