package TempPack;

public class TempClassExtendsThread extends Thread {
    public void run(){
        for (int i = 0; i < 10; i++) {
            System.out.println("Number: " + i);
            try {
                Thread.sleep(3);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        TempClassExtendsThread tempClass = new TempClassExtendsThread();
        tempClass.start();
        TempClassExtendsThread tempClass2 = new TempClassExtendsThread();
        tempClass2.start();
    }
}
