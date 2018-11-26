package com.mlamp.cotto.core;

public class Constant {

    // Represent the metrics server URL.
    public static final String METRICS_SERVER_URL = "cotto.metrics.server.url";

    public static final String IS_METRICS_ENABLED = "cotto.is.metrics.enabled";


    // Represent the class name of azkaban metrics reporter.
    public static final String CUSTOM_METRICS_REPORTER_CLASS_NAME = "cotto.metrics.reporter.name";


    public static class JobProperties {
        // The hadoop user the job should run under. If not specified, it will default to submit user.
        public static final String USER_TO_PROXY = "user.to.proxy";
    }

}
