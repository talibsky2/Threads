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
        Thread.sleep(500);
        System.out.println("На старт!");
        start.countDown();
        Thread.sleep(500);
        System.out.println("Внимание!");
        start.countDown();
        Thread.sleep(500);
        System.out.println("Марш!");
        Thread.sleep(500);
        start.countDown();
    }
}

class Track implements Runnable {
    RaceUtils utils = new RaceUtils();
    Semaphore semaphore = new Semaphore(3);
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " started at time: " + System.currentTimeMillis());
        utils.startTime();
    }

    public void commonRoad() throws InterruptedException {
        final long max = 1000;
        final long rnd = RaceUtils.rnd(max);
        System.out.println(Thread.currentThread().getName() + " on common road");
        Thread.sleep(rnd);
    }
    public void tunnel () throws InterruptedException {
        final long max = 1000;
        final long rnd = RaceUtils.rnd(max);
        semaphore.acquire();
        System.out.println(Thread.currentThread().getName() + " in tunnel");
        Thread.sleep(rnd);
        semaphore.release();
    }
    public void finish () {
        utils.endTime();
        utils.raceTime();
        System.out.println(Thread.currentThread().getName() + " finished at " + utils.getEndTime() + " and it`s time is "
        + utils.getRaceTime() + " milliseconds");
    }
}


