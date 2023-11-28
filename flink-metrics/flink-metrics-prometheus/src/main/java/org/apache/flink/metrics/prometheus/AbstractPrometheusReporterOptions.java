package org.apache.flink.metrics.prometheus;

import org.apache.flink.annotation.docs.Documentation;
import org.apache.flink.configuration.ConfigConstants;
import org.apache.flink.configuration.ConfigOption;
import org.apache.flink.configuration.ConfigOptions;
import org.apache.flink.configuration.description.Description;
import org.apache.flink.configuration.description.LinkElement;
import org.apache.flink.configuration.description.TextElement;

/** Config options for the {@link PrometheusReporter}. */
@Documentation.SuffixOption(ConfigConstants.METRICS_REPORTER_PREFIX + "prometheus")
public class AbstractPrometheusReporterOptions {
    public static final ConfigOption<Boolean> FILTER_LABEL_VALUE_CHARACTER =
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

    public static final ConfigOption<String> LABELS =
            ConfigOptions.key("labels")
                    .stringType()
                    .defaultValue("")
                    .withDescription(
                            Description.builder()
                                    .text(
                                            "Specifies labels to be added to all metrics. These labels will override any labels set manually."
                                                    + " The label name and value are separated by '=', and labels are separated by ';', e.g., %s."
                                                    + " Please ensure that your global labels meet the %s.",
                                            TextElement.code("k1=v1;k2=v2"),
                                            LinkElement.link(
                                                    "https://prometheus.io/docs/concepts/data_model/#metric-names-and-labels",
                                                    "Prometheus requirements"))
                                    .build());
}
