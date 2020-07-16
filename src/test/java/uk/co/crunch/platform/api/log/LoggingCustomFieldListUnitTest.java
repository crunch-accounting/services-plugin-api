package uk.co.crunch.platform.api.log;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

@LoggingCustomField(name = "foo", values = "bar")
@LoggingCustomField(name = "foop", values = {"barp", "prab"})
public class LoggingCustomFieldListUnitTest {

    @Test
    public void testList() throws NoSuchMethodException {
        final LoggingCustomFieldList anns = this.getClass().getAnnotation(LoggingCustomFieldList.class);

        assertThat(anns.value()[0].name()).isEqualTo("foo");
        assertThat(anns.value()[0].values()).containsExactlyInAnyOrder("bar");
        assertThat(anns.value()[1].name()).isEqualTo("foop");
        assertThat(anns.value()[1].values()).containsExactlyInAnyOrder("barp", "prab");

        assertThat(this.getClass().getMethod("testList").getAnnotation(LoggingCustomField.class)).isNull();
    }
}
