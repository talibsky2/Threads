package Task2_Loading;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
class Thread1 implements Callable <String> {
    Service userService;

    public Thread1(Service userService) {
        this.userService = userService;
    }

    @Override
    public String call() {
        Thread.currentThread().setName("Thread1");
        List<UserModel> list = UserModel.createCollection();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter number: ");
        int number = in.nextInt();
        Thread2.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return userService.selectUserByNumber(list, number);
    }
}

class Thread2 implements Runnable {
    public static void start () {
        Thread thread = new Thread(new Thread2());
        thread.setName("DaemonThread");
        thread.setPriority(Thread.MAX_PRIORITY);
        thread.setDaemon(true);
        thread.start();
    }
    @Override
    public void run() {
        try {
            System.out.print("Loading");
            for (int n = 5; n > 0; n--) {
                System.out.print(".");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
