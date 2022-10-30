package Task4_Run;

public class Task4_Main {
    public static void main(String[] args) throws Exception {
        Garage garage = new Garage();
        RaceUtils raceUtils = new RaceUtils();
        CommonRoadStart commonRoadStart = new CommonRoadStart();
        CommonRoad commonRoad = new CommonRoad();
        for (int i = 0; i < 10; i++) {
            garage.executor.submit(() -> {
                try {
                    new RacePrepare().run();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
            garage.executor.submit(() -> {
                try {
                    raceUtils.startLine(raceUtils);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        Thread.sleep(2500);
        for (int i = 0; i < 10; i++) {
            if (raceUtils.isStartFlag()) {
                RaceUtils.setRaceTime(System.currentTimeMillis());
                garage.executor.submit(commonRoadStart);
                garage.executor.submit(commonRoad);
            }
        }
        garage.executor.shutdown();
    }
}