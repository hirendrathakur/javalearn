package metrics;

import com.codahale.metrics.JmxReporter;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.Timer;

import java.util.concurrent.TimeUnit;

public enum  MetricsRegistry {
    INSTANCE;

    private MetricRegistry metricRegistry;
    MetricsRegistry() {
        metricRegistry = new MetricRegistry();
        JmxReporter jmxReporter = JmxReporter.forRegistry(metricRegistry)
                .convertRatesTo(TimeUnit.SECONDS)
                .inDomain("fk.metrics")
                .convertDurationsTo(TimeUnit.MILLISECONDS)
                .build();
        jmxReporter.start();
    }

    public static Timer.Context timerContext(Class<?> callerClass, String... names) {
        return INSTANCE.getMetricRegistry().timer(MetricRegistry.name(callerClass, names)).time();
    }

    public MetricRegistry getMetricRegistry() {
        return metricRegistry;
    }
}
