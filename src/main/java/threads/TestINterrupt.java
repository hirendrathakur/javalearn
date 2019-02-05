package threads;

public class TestINterrupt {
    static int count = 0;
    public static void main(String[] args) throws Exception{
        Thread t1 = new Thread(new Thread1());
        t1.start();
        Thread.sleep(8000);
        t1.interrupt();

    }

    static class Thread1 implements Runnable {

        @Override
        public void run() {
//            while(true) {
//                try {
//                    Thread.sleep(5000);
//                } catch (InterruptedException e) {
//                    System.out.println("Interrupted leaving....");
//                    break;
//                }
//            }

            while (!Thread.currentThread().isInterrupted()) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    System.out.println("Interrupted");
                    break;
                }
            }
        }

        void functionCall() throws Exception {
            if(++count == 4)
                throw new Exception("some");
            System.out.println("Exception");
        }
    }

}
