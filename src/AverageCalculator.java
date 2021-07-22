public class AverageCalculator implements Runnable {
    private int startIndex;
    private int endIndex;
    private int average;
    private int[] mass;

    public AverageCalculator(int[] mass, int startIndex, int endIndex) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.mass = mass;
    }

    @Override
    public synchronized void run() {
        int countOfNumbers = endIndex - startIndex - 1;
        int sumOfNumbers = 0;
        for (int i = startIndex; i < endIndex; i++) {
            sumOfNumbers += mass[i];
        }
        average = sumOfNumbers / countOfNumbers;
    }

    public int getAverage() {
        return average;
    }
}
