package uk.co.crunch.platform.api.cron;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created to support scheduled tasks where standard expectations (and K8s defaults) of idempotency cannot be met.
 * For example: jobs which cannot overlap with another job of its own kind without risking data corruption or duplication;
 * jobs that may take a significant, highly variable, or unpredictable amount of time to complete
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface NonIdempotentKubernetesCron {

    String name();
    String schedule();

    // https://kubernetes.io/docs/tasks/job/automated-tasks-with-cron-jobs/#concurrency-policy
    ConcurrencyPolicy concurrencyPolicy() default ConcurrencyPolicy.FORBID;

    // https://kubernetes.io/docs/concepts/workloads/controllers/jobs-run-to-completion/#controlling-parallelism
    int parallelism() default 1;

    // https://kubernetes.io/docs/concepts/workloads/controllers/jobs-run-to-completion/#pod-backoff-failure-policy
    // default is 6 but we want the Crunch default to be 3
    int backOffLimit() default 3;
}
