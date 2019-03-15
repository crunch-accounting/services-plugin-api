package uk.co.crunch.platform.api.rabbit;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RabbitApiTest {

    @RabbitUser
    @Test
    public void testRabbitUser() throws NoSuchMethodException {
        final RabbitUser ann = this.getClass().getMethod("testRabbitUser").getAnnotation(RabbitUser.class);

        assertThat(ann.readPrivs()).isEqualTo(".*");
        assertThat(ann.writePrivs()).isEqualTo(".*");
        assertThat(ann.configPrivs()).isEqualTo(".*");
    }

    @RabbitUser(customRoleName="special", readPrivs="consumer\\.lead\\.producer\\.lead\\.create", writePrivs="default|email.*")
    @Test
    public void testRabbitUserLong() throws NoSuchMethodException {
        final RabbitUser ann = this.getClass().getMethod("testRabbitUserLong").getAnnotation(RabbitUser.class);

        assertThat(ann.readPrivs()).isEqualTo("consumer\\.lead\\.producer\\.lead\\.create");
        assertThat(ann.writePrivs()).isEqualTo("default|email.*");
        assertThat(ann.configPrivs()).isEqualTo(".*");
    }
}
