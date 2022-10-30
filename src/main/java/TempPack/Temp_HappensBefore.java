package TempPack;

public class Temp_HappensBefore {
    volatile static int a = 0;
    volatile static int b = 0;

    public static void main(String[] args) throws InterruptedException {
        new Thread() {
            @Override
            public void run() {
                int r1 = a;
                b = 2;
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                int r2 = b;
                a = 2;
            }
        }.start();
    }
}
