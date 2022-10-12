package TempPack;

public class TempClass {
    public static void main(String[] args) {
        Thread t = Thread.currentThread();
        System.out.println(t);
        t.setName("My Thread");
        System.out.println(t);
        try {
            System.out.print("Loading");
            for (int n = 5; n > 0; n--) {
                System.out.print(".");
                Thread.sleep(1000);
            }
            System.out.println();
            System.out.println(t.getName());
            System.out.println(t.getPriority());
            System.out.println(t.getThreadGroup());
        } catch (InterruptedException e) {
            System.out.println("Главный поток исполнения прерван");
        }
    }
}