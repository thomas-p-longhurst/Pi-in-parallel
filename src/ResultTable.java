import java.util.Collection;
import java.util.HashMap;

public class ResultTable {
    // Prevent race conditions with synchronized(this) {}

    private HashMap<Integer, Integer> map = new HashMap<>();

    public ResultTable() {

    }

    public void setDigit(int key, int value) {
        synchronized (this) {
            map.put(key, value);
        }
    }

    public Collection<Integer> getValues() {
        synchronized (this) {
            return map.values();
        }
    }
}
