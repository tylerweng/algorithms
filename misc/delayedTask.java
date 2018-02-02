import java.util.*;

class Main {

    public static TimerTask wrap(Runnable r) {
        return new TimerTask() {
            @Override
            public void run() {
                r.run();
            }
        };
    }
    public static void main(String[] args) {
        final Timer timer = new Timer();
        timer.schedule(wrap(() -> System.out.println("Hello")), 1000);
    }
}