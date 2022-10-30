package TempPack;

public class Temp_Volatile {
    volatile static int i;

    public static void main(String[] args) {
        Thread thread = new WriteThread();
        thread.start();
        new ReadThread().start();
        System.out.println(i);
    }

    static class WriteThread extends Thread {
        @Override
        public void run() {
            while (i < 5)  {
                System.out.println("increase i: " + (++i));
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }
    static class ReadThread extends Thread {
        @Override
        public void run () {
            int localValue = i;
            while (localValue < 5){
                if (localValue != i) {
                    System.out.println(localValue = i);
                }
            }
        }
    }
}
