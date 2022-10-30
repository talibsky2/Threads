package Task4_Run;

import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class RaceUtils {
    private static final CountDownLatch START = new CountDownLatch(3);
    @Setter
    @Getter
    private long startTime;
    @Setter
    @Getter
    private long endTime;
    @Setter
    @Getter
    private long raceTime;
    public void startTime () {
        setStartTime(System.currentTimeMillis());
    }
    public void endTime () {
        setEndTime(System.currentTimeMillis());
    }
    public void raceTime () {
        setRaceTime(getEndTime() - getStartTime());
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
