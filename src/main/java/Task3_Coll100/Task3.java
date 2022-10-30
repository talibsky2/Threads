package Task3_Coll100;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Task3 {
    static List<Integer> elements = new CopyOnWriteArrayList<>();
    static Runnable el1 = () -> {
        for (int i = 0; i < 100; i++) {
            elements.add(i);
        }
    };
    static Runnable el2 = () -> {
        for (int i = 0; i < 100; i++) {
            elements.add(i);
        }
    };

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(el1);
        Thread thread2 = new Thread(el2);
        thread.start();
        thread2.start();
        thread.join();
        thread2.join();
        System.out.println(elements.size());
    }
}

