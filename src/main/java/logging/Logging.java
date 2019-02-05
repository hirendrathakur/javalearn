package logging;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.Timer;
import lombok.extern.slf4j.Slf4j;
import metrics.MetricsRegistry;

import java.util.concurrent.TimeUnit;

@Slf4j
public class Logging {

    private static ConsoleReporter reporter;

    public static void main(String[] args) {
        startReport();
        testLogging();
    }

    private static void testLogging() {
        while (true) {
            try(Timer.Context context = MetricsRegistry.timerContext(Logging.class, "logging")) {
                log.trace("Testing info logs");
            }
        }
    }

    private static void startReport() {
        reporter = ConsoleReporter.forRegistry(MetricsRegistry.INSTANCE.getMetricRegistry())
                .convertRatesTo(TimeUnit.SECONDS)
                .convertDurationsTo(TimeUnit.MILLISECONDS)
                .build();
        reporter.start(2, TimeUnit.SECONDS);
    }
}
