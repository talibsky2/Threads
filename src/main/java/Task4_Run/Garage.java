package Task4_Run;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class Garage {
    ExecutorService executor = Executors.newFixedThreadPool(10, new Car("Car"));

}
class Car implements ThreadFactory {
    private int counter = 1;
    private final String name;

    public Car(String name) {
        this.name = name;
    }

    @Override
    public Thread newThread(Runnable r) {
        return new Thread(r, name + "-" + counter++);
    }
}