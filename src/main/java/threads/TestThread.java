package threads;

public class TestThread {

    public static void main(String[] args) {
        Thread thread = new Thread1();
        thread.start();
        RunnableTest runnableTest = new RunnableTest();
        runnableTest.run();

    }
    public static class Thread1 extends Thread {
        @Override
        public void run() {
            System.out.println("startedThread");
        }
    }

    public static class RunnableTest implements Runnable {

        @Override
        public void run() {
            System.out.println("Runnable started");
        }
    }
}
