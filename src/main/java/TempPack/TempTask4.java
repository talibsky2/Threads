package TempPack;

import Task4_Run.RaceUtils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TempTask4 {
    public static void stop(ExecutorService executor) {
        try {
            executor.shutdown();
            executor.awaitTermination(60, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.err.println("termination_interrupted");
        } finally {
            if (!executor.isTerminated()) {
                System.err.println("killing non-finished tasks");
            }
            executor.shutdownNow();
        }
    }

    int count = 0;

    synchronized void increment() {
        count++;
    }

    void exec() {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        IntStream.range(0, 10000)
                .forEach(i -> executor.submit(this::increment));
        stop(executor);
        System.out.println(count);
    }

    void exec2() {
        ExecutorService executor = Executors.newFixedThreadPool(15);

            executor.submit(() -> System.out.println(Thread.currentThread().getName()));
        RaceUtils.stop(executor);
    }

    public static void main(String[] args) throws InterruptedException {
        TempTask4 task4 = new TempTask4();
        task4.exec2();
    }
}
