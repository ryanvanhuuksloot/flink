package org.apache.flink.metrics.prometheus;

import org.apache.flink.configuration.ConfigOption;
import org.apache.flink.configuration.ConfigOptions;
import org.apache.flink.configuration.description.Description;
import org.apache.flink.configuration.description.LinkElement;

/** Config options for the {@link PrometheusReporter} and {@link PrometheusPushGatewayReporter}. */
public interface AbstractPrometheusReporterOptions {
    ConfigOption<Boolean> FILTER_LABEL_VALUE_CHARACTER =
            ConfigOptions.key("filterLabelValueCharacters")
                    .booleanType()
                    .defaultValue(true)
                    .withDescription(
                            Description.builder()
                                    .text(
                                            "Specifies whether to filter label value characters."
                                                    + " If enabled, all characters not matching [a-zA-Z0-9:_] will be removed,"
                                                    + " otherwise no characters will be removed."
                                                    + " Before disabling this option please ensure that your"
                                                    + " label values meet the %s.",
                                            LinkElement.link(
                                                    "https://prometheus.io/docs/concepts/data_model/#metric-names-and-labels",
                                                    "Prometheus requirements"))
                                    .build());
}
