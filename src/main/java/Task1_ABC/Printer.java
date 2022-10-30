package Task1_ABC;

public class Printer {
    static volatile boolean flag = false;
    static volatile boolean flag2 = false;

    public synchronized void print() throws InterruptedException {
        if (!flag & !flag2) {
            System.out.print("A");
            flag = true;
        }
        else
        if (flag & !flag2) {
            System.out.print("B");
            flag2 = true;
        }
        else
        if (flag & flag) {
            System.out.print("C");
            flag = false;
            flag2 = false;
        }
    }
}

