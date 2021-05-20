package uk.co.crunch.platform.api.publicapi

import io.swagger.annotations.ApiParam
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

internal class PagedRequestUnitTest {

    @Test
    fun `paged requests are annotated with @PagedRequest`() {
        DemoRestControllerWithPagedRequest::class.java
            .getMethod("getPaged", Pageable::class.java)
            .getAnnotation(PagedRequest::class.java)
            .run { assertThat(this).isNotNull }
    }
}

//@RestController
//@RequestMapping("/demo")
class DemoRestControllerWithPagedRequest {

    @PagedRequest
    // @GetMapping("/paged", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getPaged(@ApiParam(hidden = true) pageData: Pageable) = listOf("a", "b", "c")
}

// i.e. org.springframework.data.domain.Pageable
class Pageable
