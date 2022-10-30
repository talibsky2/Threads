package Task1_ABC;

public class Task1_Main {
    static Printer printer = new Printer();
    static Runnable printA = () -> {
        Thread.currentThread().setName("A");
        for (int i = 0; i < 5; i++) {
            try {
                printer.print();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    };
    static Runnable printB = () -> {
        Thread.currentThread().setName("B");
        for (int i = 0; i < 5; i++) {
            try {
                printer.print();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    };
    static Runnable printC = () -> {
        Thread.currentThread().setName("C");
        for (int i = 0; i < 5; i++) {
            try {
                printer.print();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    };

    public static void main(String[] args) throws InterruptedException {
        new Thread(printA).start();
        new Thread(printB).start();
        new Thread(printC).start();
    }
}
