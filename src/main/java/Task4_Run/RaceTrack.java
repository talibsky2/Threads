package Task4_Run;


import lombok.SneakyThrows;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

class Race implements Runnable {
    private static final CountDownLatch start = new CountDownLatch(3);

    @SneakyThrows
    @Override
    public void run() {
        RaceUtils utils = new RaceUtils();
        final long max = 100;
        final long rnd = RaceUtils.rnd(max);
        utils.startTime();
        try {
            Thread.sleep(rnd);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        utils.endTime();
        utils.raceTime();
        System.out.println("Time to prepare for " + Thread.currentThread().getName() + ": " + utils.getRaceTime());
        start.await();
    }

    public void countDown() throws InterruptedException {
        Thread.sleep(300);
        System.out.println("На старт!");
        start.countDown();
        Thread.sleep(300);
        System.out.println("Внимание!");
        start.countDown();
        Thread.sleep(300);
        System.out.println("Марш!");
        start.countDown();
    }
}

class Track implements Runnable {
    RaceUtils utils = new RaceUtils();
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " started at time: " + System.currentTimeMillis());
        utils.startTime();
    }

    public void commonRoad() {
        int i = 0;
        for (int j = 0; j < 10000000; j++) {
            i++;
        }
        System.out.println(Thread.currentThread().getName() + " on common road");
    }
    public void tunnel () {
        int i = 0;
        for (int j = 0; j < 10000000; j++) {
            i++;
        }
        System.out.println(Thread.currentThread().getName() + " in tunnel");
    }
    public void finish () {
        utils.endTime();
        utils.raceTime();
        System.out.println(Thread.currentThread().getName() + " finished at " + utils.getEndTime() + " and it`s time is "
        + utils.getRaceTime() + " milliseconds");
    }
}


