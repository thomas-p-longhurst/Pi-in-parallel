import java.util.Collection;
import java.util.HashMap;

public class ResultTable {
    private HashMap<Integer, Integer> map = new HashMap<>();

    public synchronized void setDigit(int key, int value) {
        map.put(key, value);
    }

    public synchronized Collection<Integer> getValues() {
        return map.values();
    }
}
