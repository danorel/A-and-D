package timer;

public class Stopwatch {
    private static double beginEvaluation;

    public Stopwatch(){
        beginEvaluation = System.nanoTime();
    }

    public static double evaluateTime(){
        return ((System.nanoTime() - beginEvaluation) / 1000);
    }
}
