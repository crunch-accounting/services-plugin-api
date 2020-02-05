package uk.co.crunch.platform.api.prometheus.alerts;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static uk.co.crunch.platform.api.prometheus.alerts.AlertSeverity.PAGER;
import static uk.co.crunch.platform.api.prometheus.alerts.AlertSeverity.WARNING;

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

    @ZeroToleranceErrorAlertRule(name = "mine", errorLabel = "loginErrors", team = TEAM, description = "desc")
    @ZeroToleranceErrorAlertRule(name = "yours", errorLabel = "xErrors", team = TEAM, severity = PAGER, description = "foop")
    @Test
    public void testRepeatable() throws NoSuchMethodException {
        final ZeroToleranceErrorAlertRule[] rules = this.getClass().getMethod("testRepeatable").getAnnotationsByType(ZeroToleranceErrorAlertRule.class);

        assertThat(rules[0].name()).isEqualTo("mine");
        assertThat(rules[0].errorLabel()).isEqualTo("loginErrors");
        assertThat(rules[0].severity()).isEqualTo(WARNING);
        assertThat(rules[0].team()).isEqualTo(TEAM);
        assertThat(rules[0].description()).isEqualTo("desc");
        assertThat(rules[0].duration()).isEqualTo("1m");
        assertThat(rules[0].timeRange()).isEqualTo("1m");

        assertThat(rules[1].name()).isEqualTo("yours");
        assertThat(rules[1].errorLabel()).isEqualTo("xErrors");
        assertThat(rules[1].severity()).isEqualTo(PAGER);
        assertThat(rules[1].team()).isEqualTo(TEAM);
        assertThat(rules[1].description()).isEqualTo("foop");
        assertThat(rules[1].duration()).isEqualTo("1m");
        assertThat(rules[1].timeRange()).isEqualTo("1m");
    }
}
