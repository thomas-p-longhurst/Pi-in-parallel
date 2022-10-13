import java.util.ArrayList;
import java.util.Collection;

/**
 * Compute the digits of Pi in parallel. Utilize all available cores of any computer, each core computing a single
 * digit. Compute the first 1000 digits of Pi.
 */
public class Assn4 {
    public static void main(String[] args) {
//        calculateSingleThread();
        int digits = 1000;
        TaskQueue tq = new TaskQueue(digits);
        ResultTable rt = new ResultTable();

        int availableCores = Runtime.getRuntime().availableProcessors();

        ArrayList<WorkerThread> threads = new ArrayList<>();

        long before = System.currentTimeMillis();
        for (int i = 0; i < availableCores; i++) {
            WorkerThread wt = new WorkerThread(tq, rt);
            threads.add(wt);
            wt.start();
        }

        // Wait for all threads to finish
        for (WorkerThread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        long timeTaken = System.currentTimeMillis() - before;

        Collection<Integer> values = rt.getValues();
        System.out.println();
        System.out.print("3.");
        values.forEach(System.out::print);
        System.out.println();
        System.out.printf("Pi computation took %d ms with %d processors", timeTaken, availableCores);
    }

    // Just so I can test how much faster the program will get with multi-threading
    // Takes about 30 seconds to calculate 1000 digits
    public static void calculateSingleThread() {
        int digits = 100;
        Bpp bpp = new Bpp();
        TaskQueue tq = new TaskQueue(digits);
        ResultTable rt = new ResultTable();

        while (!tq.isEmpty()) {
            Task task = tq.getTask();
            rt.setDigit(task.getTarget(), task.calculate(bpp));
        }

        Collection<Integer> values = rt.getValues();
        System.out.print("3.");
        values.forEach(System.out::print);
    }
}
