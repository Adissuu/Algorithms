package Programming;

public class Timer {

    private String func;
    private long startTime;
    private long endTime;
    private long totalTime;

    public Timer(String func) {
        this.func = func;
        startTime = 0;
        endTime = 0;
    }

    public void start() {
        startTime = System.nanoTime();
    }

    public void stop() {
        endTime = System.nanoTime();
        totalTime = endTime - startTime;

        System.out.println("The function " + func + " ran in " + totalTime / 1000000 + "ms");

    }
}