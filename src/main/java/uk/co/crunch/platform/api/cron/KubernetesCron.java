package uk.co.crunch.platform.api.cron;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface KubernetesCron {

    String name();

    String schedule();

    // https://kubernetes.io/docs/tasks/job/automated-tasks-with-cron-jobs/#concurrency-policy
    ConcurrencyPolicy concurrencyPolicy() default ConcurrencyPolicy.ALLOW;

    // https://kubernetes.io/docs/concepts/workloads/controllers/jobs-run-to-completion/#controlling-parallelism
    int parallelism() default 1;

    // https://kubernetes.io/docs/concepts/workloads/controllers/jobs-run-to-completion/#pod-backoff-failure-policy
    // default is 6 but we want the Crunch default to be 3
    int backOffLimit() default 3;
}
