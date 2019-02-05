package metrics;

import com.codahale.metrics.Gauge;
import com.codahale.metrics.Metric;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomGuage implements Metric, Gauge<Long> {
    private volatile long value;
    @Override
    public Long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }
}
