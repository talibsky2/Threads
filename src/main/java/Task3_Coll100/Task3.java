package Task3_Coll100;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Task3 {
    static List<Integer> elements = new CopyOnWriteArrayList<>();
}
class NewElement1 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            Task3.elements.add(i);
        }
    }
}
class NewElement2 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            Task3.elements.add(i);
        }
    }
}
