/**
 * Represents a task to calculate the nth digit of Pi
 */
public class Task {
    private final int n;
    private Bpp bpp;

    public Task(Bpp bpp, int toCalculate) {
        this.bpp = bpp;
        this.n = toCalculate;
    }

    public int getTarget() {
        return n;
    }

    public int calculate() {
        // Calculating 9 digits and only taking off the front is janky, but dissecting the code from github would be more trouble than it's worth.
        int nineDigits = bpp.getDecimal(n);
        // If the digit of interest is 0, there will not be a leading 0, and the resulting int will be shorter.
        // Test if there should be a leading 0
        if (Integer.toString(nineDigits).length() < 9) {
            return 0;
        }
        // Otherwise return the first digit
        return Integer.parseInt(Integer.toString(nineDigits).substring(0, 1));
    }
}
