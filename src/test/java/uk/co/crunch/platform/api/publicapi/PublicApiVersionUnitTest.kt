package uk.co.crunch.platform.api.publicapi

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

@PublicApiVersion(domainApiVersion = 2, publicFacingVersion = 1)
internal class PublicApiVersionUnitTest {

    @Test
    fun apiUsage() {
        this.javaClass.getAnnotation(PublicApiVersion::class.java).run {
            assertThat(this.domainApiVersion).isEqualTo(2)
            assertThat(this.publicFacingVersion).isEqualTo(1)
        }
    }
}
