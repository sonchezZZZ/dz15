import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        int generalAverage = 0;
        int[] massive = new int[10_000_000];
        Random random = new Random();
        for (int i = 0; i < massive.length; i++) {
            massive[i] = random.nextInt(100);
        }
        AverageCalculator calc1 = new AverageCalculator(massive, 0, 2_500_000);
        AverageCalculator calc2 = new AverageCalculator(massive, 2_500_000, 5_000_000);
        AverageCalculator calc3 = new AverageCalculator(massive, 5_000_000, 7_500_000);
        AverageCalculator calc4 = new AverageCalculator(massive, 7_500_000, 10_000_000);
        Thread thread1 = new Thread(calc1);
        Thread thread2 = new Thread(calc2);
        Thread thread3 = new Thread(calc3);
        Thread thread4 = new Thread(calc4);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        generalAverage += calc1.getAverage();
        generalAverage += calc2.getAverage();
        generalAverage += calc3.getAverage();
        generalAverage += calc4.getAverage();
        generalAverage = generalAverage / 4;
        System.out.println(generalAverage);


    }
}
