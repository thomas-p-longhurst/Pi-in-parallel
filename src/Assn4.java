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
        Bpp bpp = new Bpp();
        System.out.print("3.");
        for (int i = 1; i < 1000; i++) {
            // Pretty inefficient to calculate 8 digits and only take the first one, but I really don't want to dissect the code from github
            int eightDecimals = bpp.getDecimal(i);
            int firstDigit = Integer.parseInt(Integer.toString(eightDecimals).substring(0, 1));
            System.out.printf("%d", firstDigit);
        }
    }
}
