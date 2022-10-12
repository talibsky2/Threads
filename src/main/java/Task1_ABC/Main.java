package Task1_ABC;

public class Main {
    public static void main(String[] args) {
        Monitor monitor = new Monitor();
            new Thread(new PrintB(monitor)).start();
            new Thread(new PrintC(monitor)).start();
            new Thread(new PrintA(monitor)).start();
    }
}
