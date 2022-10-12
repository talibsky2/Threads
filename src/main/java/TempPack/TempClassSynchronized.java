package TempPack;

public class TempClassSynchronized extends Thread {
    Resource resource = new Resource();

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        resource.change();
    }
}

class Run {
    public static void main(String[] args) throws InterruptedException {
        Resource resource = new Resource();
        resource.i = 5;
        TempClassSynchronized getThread = new TempClassSynchronized();
        getThread.setName("one");
        TempClassSynchronized getThread1 = new TempClassSynchronized();
        getThread1.setName("two");
        getThread.setResource(resource);
        getThread1.setResource(resource);
        getThread.start();
        getThread1.start();
        getThread.join();
        getThread1.join();
        System.out.println(resource.i);
    }
}

class Resource {
    int i;

    public synchronized void change() {
        int i = this.i;
        if(Thread.currentThread().getName().equals("two")){
            Thread.yield();
        }
        i++;
        this.i = i;
    }
}

