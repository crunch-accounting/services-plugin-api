package uk.co.crunch.platform.api.rabbit;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static uk.co.crunch.platform.api.rabbit.RabbitCommands.*;

public class RabbitApiTest {

    @RabbitUser
    @Test
    public void testRabbitUser() throws NoSuchMethodException {
        final RabbitUser ann = this.getClass().getMethod("testRabbitUser").getAnnotation(RabbitUser.class);

//        assertThat(ann.schema()).isEqualTo("blahDb");
        assertThat(ann.instance().host()).isEqualTo("rabbitmq.service.consul");
//        assertThat(ann.grants()).isEqualTo("ALL");

        assertThat( getConfigName(ann) ).isEqualTo("rabbitmq_service_consul");
        assertThat( getRoleName(ann, "yearend") ).isEqualTo("yearend");
        assertThat( getConnectionUrl(ann) ).isEqualTo("http://rabbitmq.service.consul:15672");
        assertThat( getUserCreationStatement(ann) ).isEqualTo("{\"/\":{\"read\":\".*\",\"configure\":\".*\",\"write\":\".*\"}}");
    }

    @RabbitUser(customRoleName="special", readPrivs="consumer\\.lead\\.producer\\.lead\\.create", writePrivs="default|email.*")
    @Test
    public void testRabbitUserLong() throws NoSuchMethodException {
        final RabbitUser ann = this.getClass().getMethod("testRabbitUserLong").getAnnotation(RabbitUser.class);

//        assertThat(ann.schema()).isEqualTo("blahDb");
        assertThat(ann.instance().host()).isEqualTo("rabbitmq.service.consul");
//        assertThat(ann.grants()).isEqualTo("ALL");

        assertThat( getConfigName(ann) ).isEqualTo("rabbitmq_service_consul");
        assertThat( getRoleName(ann, "yearend") ).isEqualTo("special");
        assertThat( getConnectionUrl(ann) ).isEqualTo("http://rabbitmq.service.consul:15672");
        assertThat( getUserCreationStatement(ann) ).isEqualTo("{\"/\":{\"read\":\"consumer\\\\.lead\\\\.producer\\\\.lead\\\\.create\",\"configure\":\".*\",\"write\":\"default|email.*\"}}");
    }
}
