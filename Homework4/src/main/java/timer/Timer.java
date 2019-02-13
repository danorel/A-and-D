package timer;

public class Timer {
    private static double start;

    public Timer(){
        start = System.nanoTime();
    }

    public static double calculate(){
        return ((System.nanoTime() - start) / 1000);
    }
}
