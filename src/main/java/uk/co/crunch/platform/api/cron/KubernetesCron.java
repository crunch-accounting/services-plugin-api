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
    ConcurrencyPolicy concurrencyPolicy() default KubernetesCron.ConcurrencyPolicy.ALLOW;

    // https://kubernetes.io/docs/concepts/workloads/controllers/jobs-run-to-completion/#controlling-parallelism
    int parallelism() default 1;

    enum ConcurrencyPolicy {
        ALLOW("Allow"),
        FORBID("Forbid"),
        REPLACE("Replace");

        private final String k8sValue;

        ConcurrencyPolicy(String k8sValue) {
            this.k8sValue = k8sValue;
        }

        public String getK8sValue() {
            return k8sValue;
        }
    }
}
