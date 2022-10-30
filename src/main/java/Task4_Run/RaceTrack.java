package Task4_Run;

import java.util.concurrent.Semaphore;

class RacePrepare implements Runnable {
    @Override
    public void run() {
        final long max = 100;
        final long rnd = RaceUtils.rnd(max);
        RaceUtils.setStartTime(System.currentTimeMillis());
        try {
            Thread.sleep(rnd);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        RaceUtils.setEndTime(System.currentTimeMillis());
        RaceUtils.setRaceTime(RaceUtils.getEndTime() - RaceUtils.getStartTime());
        System.out.println("Time to prepare for " + Thread.currentThread().getName() + ": " + RaceUtils.getRaceTime());
    }
}

class CommonRoadStart implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " started at time: " + System.currentTimeMillis());
    }
}

class CommonRoad implements Runnable {

    @Override
    public void run() {
        synchronized (new CommonRoad()) {
            int i = 0;
            for (int j = 0; j < 10000000; j++) {
                i++;
            }
        }
        System.out.println(Thread.currentThread().getName() + " on common road" );
    }
}

class Tunnel implements Runnable {
    Semaphore semaphore;
    int cars = 0;

    public Tunnel(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName() + " in tunnel");
    }
}


