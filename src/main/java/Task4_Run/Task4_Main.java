package Task4_Run;

public class Task4_Main {
    public static void main(String[] args) throws Exception {
        Garage garage = new Garage();
        Race race = new Race ();
        Track track = new Track();
        for (int i = 0; i < 10; i++) {
            garage.executor.submit(() -> {
                try {
                    race.run();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
        }
        race.countDown();
        for (int i = 0; i < 10; i++) {
            garage.executor.submit(() -> {
                try {
                    track.run();
                    track.commonRoad();
                    track.tunnel();
                    track.commonRoad();
                    track.finish();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
        }
        garage.executor.shutdown();
    }
}