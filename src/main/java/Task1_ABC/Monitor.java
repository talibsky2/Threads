package Task1_ABC;

public class Monitor {
    String nameA = "A";
    String nameB = "B";
    String nameC = "C";
    int count = 5;

    public synchronized void print() {
        if (Thread.currentThread().getName().equals(nameA)) {
            try {
                System.out.print("A");
                wait(4000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        if (Thread.currentThread().getName().equals(nameB)){
            try {
                wait(1000);
                System.out.print("B");
                wait(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        if (Thread.currentThread().getName().equals(nameC)){
            try {
                wait(2000);
                System.out.print("C");
                wait(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}

class PrintA implements Runnable {
    Monitor monitor;

    public PrintA(Monitor monitor) {
        this.monitor = monitor;
    }

    @Override
    public void run() {
        Thread.currentThread().setName(monitor.nameA);
        for (int i = 0; i < monitor.count; i++) {
            monitor.print();
        }
    }
}

class PrintB implements Runnable {
    Monitor monitor;

    public PrintB(Monitor monitor) {
        this.monitor = monitor;
    }

    @Override
    public void run() {
        Thread.currentThread().setName(monitor.nameB);
        for (int i = 0; i < monitor.count; i++) {
            monitor.print();
        }
    }
}

class PrintC implements Runnable {
    Monitor monitor;

    public PrintC(Monitor monitor) {
        this.monitor = monitor;
    }

    @Override
    public void run() {
        Thread.currentThread().setName(monitor.nameC);
        for (int i = 0; i < monitor.count; i++) {
            monitor.print();
        }
    }
}

