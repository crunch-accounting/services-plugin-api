package uk.co.crunch.platform.api.prometheus.alerts;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static uk.co.crunch.platform.api.prometheus.alerts.AlertSeverity.PAGER;

public class ZeroToleranceErrorAlertRuleUnitTest {

    private final static String TEAM = "myteam";

    @ZeroToleranceErrorAlertRule(name = "mine", errorLabel = "loginErrors", team = TEAM, severity = PAGER, description = "desc")
    @Test
    public void testBasicUsage() throws NoSuchMethodException {
        final ZeroToleranceErrorAlertRule ann = this.getClass().getMethod("testBasicUsage").getAnnotation(ZeroToleranceErrorAlertRule.class);

        assertThat(ann.name()).isEqualTo("mine");
        assertThat(ann.errorLabel()).isEqualTo("loginErrors");
        assertThat(ann.severity()).isEqualTo(PAGER);
        assertThat(ann.team()).isEqualTo(TEAM);
        assertThat(ann.description()).isEqualTo("desc");
        assertThat(ann.duration()).isEqualTo("1m");
        assertThat(ann.timeRange()).isEqualTo("1m");
    }
}
