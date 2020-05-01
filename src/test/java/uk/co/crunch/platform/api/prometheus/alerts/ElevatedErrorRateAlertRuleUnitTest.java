package uk.co.crunch.platform.api.prometheus.alerts;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static uk.co.crunch.platform.api.prometheus.alerts.AlertSeverity.PAGER;
import static uk.co.crunch.platform.api.prometheus.alerts.AlertSeverity.WARNING;

public class ElevatedErrorRateAlertRuleUnitTest {

    private final static String TEAM = "myteam";

    @ElevatedErrorRateAlertRule(ratePerSecondThreshold = 5, name = "mine", errorLabel = "loginErrors", team = TEAM, severity = PAGER, description = "desc")
    @Test
    public void testBasicUsage() throws NoSuchMethodException {
        final ElevatedErrorRateAlertRule ann = this.getClass().getMethod("testBasicUsage").getAnnotation(ElevatedErrorRateAlertRule.class);

        assertThat(ann.ratePerSecondThreshold()).isEqualTo(5);
        assertThat(ann.name()).isEqualTo("mine");
        assertThat(ann.errorLabel()).isEqualTo("loginErrors");
        assertThat(ann.severity()).isEqualTo(PAGER);
        assertThat(ann.team()).isEqualTo(TEAM);
        assertThat(ann.description()).isEqualTo("desc");
        assertThat(ann.duration()).isEqualTo("5m");
        assertThat(ann.timeRange()).isEqualTo("5m");
    }

    @ElevatedErrorRateAlertRule(ratePerSecondThreshold = 3, name = "mine", errorLabel = "loginErrors", team = TEAM, description = "desc")
    @ElevatedErrorRateAlertRule(ratePerSecondThreshold = 2, name = "yours", errorLabel = "xErrors", team = TEAM, severity = PAGER, description = "foop")
    @Test
    public void testRepeatable() throws NoSuchMethodException {
        final ElevatedErrorRateAlertRule[] rules = this.getClass().getMethod("testRepeatable").getAnnotationsByType(ElevatedErrorRateAlertRule.class);

        assertThat(rules[0].ratePerSecondThreshold()).isEqualTo(3);
        assertThat(rules[0].name()).isEqualTo("mine");
        assertThat(rules[0].errorLabel()).isEqualTo("loginErrors");
        assertThat(rules[0].severity()).isEqualTo(WARNING);
        assertThat(rules[0].team()).isEqualTo(TEAM);
        assertThat(rules[0].description()).isEqualTo("desc");
        assertThat(rules[0].duration()).isEqualTo("5m");
        assertThat(rules[0].timeRange()).isEqualTo("5m");

        assertThat(rules[1].ratePerSecondThreshold()).isEqualTo(2);
        assertThat(rules[1].name()).isEqualTo("yours");
        assertThat(rules[1].errorLabel()).isEqualTo("xErrors");
        assertThat(rules[1].severity()).isEqualTo(PAGER);
        assertThat(rules[1].team()).isEqualTo(TEAM);
        assertThat(rules[1].description()).isEqualTo("foop");
        assertThat(rules[1].duration()).isEqualTo("5m");
        assertThat(rules[1].timeRange()).isEqualTo("5m");
    }
}
