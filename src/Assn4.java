/**
 * Compute the digits of Pi in parallel. Utilize all available cores of any computer, each core computing a single
 * digit. Compute the first 1000 digits of Pi.
 */
public class Assn4 {
    public static void main(String[] args) {
        calculateSingleThread();
    }

    // Just so I can test how much faster the program will get with multi-threading
    // Takes about 30 seconds
    public static void calculateSingleThread() {
        int digits = 1000;
        TaskQueue tq = new TaskQueue(digits);
        System.out.print("3.");
        while (!tq.isEmpty()) {
            Task task = tq.getTask();
            System.out.print(task.calculate());
        }
    }
}
