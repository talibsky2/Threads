package Task2_Loading;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Task2_Main extends Thread {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Service service = new Service();
        Thread1 thread1 = new Thread1(service);
        FutureTask<String> future = new FutureTask<>(thread1);
        new Thread(future).start();
        System.out.println(future.get());
    }
}
