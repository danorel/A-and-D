package timer;

public class Stopwatch {
    private static double startEvaluation;

    public static void beginEvaluation(){
        startEvaluation = System.nanoTime();
    }

    public static double calculate(){
        return ((System.nanoTime() - startEvaluation) / 1000);
    }
}
