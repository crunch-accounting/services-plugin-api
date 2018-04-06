package uk.co.crunch.platform.api;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class PlatformComponentUnitTest {

    @PlatformComponent(name = "SingleDep", fromPort = 5000, toPort = 5000)
    private static class SampleWithSingleComponentDependency {

    }

    @PlatformComponent(name = "Dep1", fromPort = 5001, toPort = 5001)
    @PlatformComponent(name = "Dep2", fromPort = 5002, toPort = 5002)
    @PlatformComponent(name = "Dep3", fromPort = 5003, toPort = 5003)
    private static class SampleWithMultipleComponentDependencies {

    }

    @Test
    public void testSinglePlatformComponentAnnotation() {
        PlatformComponent platformComponent = SampleWithSingleComponentDependency.class.getAnnotation(PlatformComponent.class);
        assertThat(platformComponent, is(notNullValue()));
        assertThat(platformComponent.name(), is(equalTo("SingleDep")));
        assertThat(platformComponent.fromPort(), is(equalTo(5000)));
        assertThat(platformComponent.toPort(), is(equalTo(5000)));

        PlatformComponents platformComponents = SampleWithSingleComponentDependency.class.getAnnotation(PlatformComponents.class);
        assertThat(platformComponents, is(nullValue()));
    }

    @Test
    public void testMultiplePlatformComponentAnnotation() {
        PlatformComponent platformComponent = SampleWithMultipleComponentDependencies.class.getAnnotation(PlatformComponent.class);
        assertThat(platformComponent, is(nullValue()));

        PlatformComponents platformComponents = SampleWithMultipleComponentDependencies.class.getAnnotation(PlatformComponents.class);
        assertThat(platformComponents, is(notNullValue()));
        PlatformComponent[] components = platformComponents.value();
        assertThat(components.length, is(equalTo(3)));

        assertThat(components[0].name(), is(equalTo("Dep1")));
        assertThat(components[0].fromPort(), is(equalTo(5001)));
        assertThat(components[0].toPort(), is(equalTo(5001)));

        assertThat(components[1].name(), is(equalTo("Dep2")));
        assertThat(components[1].fromPort(), is(equalTo(5002)));
        assertThat(components[1].toPort(), is(equalTo(5002)));

        assertThat(components[2].name(), is(equalTo("Dep3")));
        assertThat(components[2].fromPort(), is(equalTo(5003)));
        assertThat(components[2].toPort(), is(equalTo(5003)));
    }
}
