package uk.co.crunch.platform.api.publicapi

import io.swagger.annotations.ApiImplicitParam
import io.swagger.annotations.ApiImplicitParams
import uk.co.crunch.platform.api.publicapi.PageableConstants.MAX_PAGE_SIZE

/**
 * Annotation to be applied to public API requests which are supposed to return paged results for the purpose of
 * generating the swagger documentation of the paging & sorting parameters.
 *
 * This annotation must be added to the public API endpoint definitions that use Spring's `Pageable`.
 */
@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER,
    AnnotationTarget.ANNOTATION_CLASS,
    AnnotationTarget.CLASS
)
@Retention(AnnotationRetention.RUNTIME)
@ApiImplicitParams(
    ApiImplicitParam(
        name = "page",
        value = "The index of the page to retrieve, based at 0.",
        paramType = "query",
        type = "integer",
        format = "int32"
    ),
    ApiImplicitParam(
        name = "size",
        value = "Number of records returned per page. Maximum value allowed is $MAX_PAGE_SIZE.",
        defaultValue = "20",
        paramType = "query",
        type = "integer",
        format = "int32"
    ),
    ApiImplicitParam(
        name = "sort",
        value = "Sorting criteria by a given <code>field</code>.",
        allowMultiple = true,
        paramType = "query",
        type = "string",
        format = "&lt;field&gt;[,asc&#124;desc]"
    )
)
annotation class PagedRequest 
