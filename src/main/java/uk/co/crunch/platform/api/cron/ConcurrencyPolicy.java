package uk.co.crunch.platform.api.cron;

public enum ConcurrencyPolicy {
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
