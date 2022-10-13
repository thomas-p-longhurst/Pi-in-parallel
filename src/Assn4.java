import java.util.Collection;

/**
 * Compute the digits of Pi in parallel. Utilize all available cores of any computer, each core computing a single
 * digit. Compute the first 1000 digits of Pi.
 */
public class Assn4 {
    public static void main(String[] args) {
        calculateSingleThread();
    }

    // Just so I can test how much faster the program will get with multi-threading
    // Takes about 30 seconds to calculate 1000 digits
    public static void calculateSingleThread() {
        int digits = 100;
        TaskQueue tq = new TaskQueue(digits);
        ResultTable rt = new ResultTable();

        while (!tq.isEmpty()) {
            Task task = tq.getTask();
            rt.setDigit(task.getTarget(), task.calculate());
        }

        Collection<Integer> values = rt.getValues();
        System.out.print("3.");
        values.forEach(System.out::print);
    }
}
