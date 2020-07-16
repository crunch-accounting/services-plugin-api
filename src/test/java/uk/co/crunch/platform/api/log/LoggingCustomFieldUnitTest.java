package uk.co.crunch.platform.api.log;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

@LoggingCustomField(name = "fook", values = "123")
public class LoggingCustomFieldUnitTest {

    @Test
    public void testSingle() throws NoSuchMethodException {
        final LoggingCustomField ann = this.getClass().getAnnotation(LoggingCustomField.class);

        assertThat(ann.name()).isEqualTo("fook");
        assertThat(ann.values()).containsExactlyInAnyOrder("123");

        assertThat(this.getClass().getMethod("testSingle").getAnnotation(LoggingCustomFieldList.class)).isNull();
    }
}
