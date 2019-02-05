package metrics;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestGauge {
    public static void main(String[] args) throws Exception {
        log.info("Starting");
        //KafkaSchedulerSinkExample.main(args);
//        Thread t1 = new Thread(new Thread1());
//        Thread t2 = new Thread(new Thread2());
//        CustomGuage customGuage = MetricsRegistry.INSTANCE.getMetricRegistry().register("customeGauge",new CustomGuage());
//        customGuage.setValue(10);
//        Thread.sleep(30000);
//        customGuage.setValue(20);
//        Thread.sleep(30000);
//        customGuage.setValue(13);
//        Thread.sleep(20000);
//        Thread.sleep(40000);
//        t1.interrupt();
//        Thread.sleep(20000);
//        t2.interrupt();

    }

    static class Thread1 implements Runnable {

        @Override
        public void run() {
            CustomGuage customGuage = MetricsRegistry.INSTANCE.getMetricRegistry().register("customeGauge",new CustomGuage());
            customGuage.setValue(10);
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("Thread1 interrupted");
                    break;
                }
            }
            System.out.println("completing thread1");
        }
    }

    static class Thread2 implements Runnable {

        @Override
        public void run() {
            CustomGuage customGuage = MetricsRegistry.INSTANCE.getMetricRegistry().register("customeGauge",new CustomGuage());
            customGuage.setValue(10);
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("Thread2 interrupted");
                    break;
                }
            }
            System.out.println("completing thread1");
        }
    }


}
