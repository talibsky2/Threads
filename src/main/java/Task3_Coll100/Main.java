package Task3_Coll100;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new NewElement1());
        Thread thread2 = new Thread(new NewElement2());
        thread.start();
        thread2.start();
        thread.join();
        thread2.join();
        System.out.println(Task3.elements.size());
    }
}
