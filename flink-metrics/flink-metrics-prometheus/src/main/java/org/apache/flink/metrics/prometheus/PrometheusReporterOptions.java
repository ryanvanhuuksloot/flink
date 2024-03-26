package org.apache.flink.metrics.prometheus;

import org.apache.flink.annotation.docs.Documentation;
import org.apache.flink.configuration.ConfigConstants;
import org.apache.flink.configuration.ConfigOption;
import org.apache.flink.configuration.ConfigOptions;

/** Config options for the {@link PrometheusReporter}. */
@Documentation.SuffixOption(ConfigConstants.METRICS_REPORTER_PREFIX + "prom")
public class PrometheusReporterOptions implements AbstractPrometheusReporterOptions {
    public static final ConfigOption<Integer> PORT =
            ConfigOptions.key("port")
                    .intType()
                    .defaultValue(9249)
                    .withDescription("The prometheus metrics server port.");
}
