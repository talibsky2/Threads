package Task4_Run;

import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class RaceUtils {
    @Setter
    @Getter
    private static double startTime;
    @Setter
    @Getter
    private static double endTime;
    @Setter
    @Getter
    private static double raceTime;
    @Setter
    @Getter
    public boolean startFlag;
    @Setter
    @Getter
    private int startCounter = 10;
    public synchronized void startLine(RaceUtils raceUtils) throws InterruptedException {
        wait(500);
        System.out.println(Thread.currentThread().getName() + " ready to go");
        wait(500);
        try {
            raceUtils.countDown();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public synchronized void countDown () throws InterruptedException {
        System.out.println(getStartCounter());
        startCounter--;
        startRace();
        Thread.sleep(100);
        if (isStartFlag()){
            Thread.sleep(200);
            System.out.println();
            System.out.println("Start");
        }
    }
    public void startRace () {
        if (getStartCounter() == 0){
            setStartFlag(true);
        }
    }

     public static void stop(ExecutorService executor) {
        try {
            executor.shutdown();
            executor.awaitTermination(30, TimeUnit.SECONDS);
        }
        catch (InterruptedException e) {
            System.err.println("termination interrupted");
        }
        finally {
            if (!executor.isTerminated()) {
                System.err.println("killing non-finished tasks");
            }
            executor.shutdownNow();
        }
    }
    public static long rnd (long max) {
         return (long) (Math.random()*max);
    }
}
