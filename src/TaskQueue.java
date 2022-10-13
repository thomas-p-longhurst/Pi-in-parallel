import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class TaskQueue {
    // To prevent race conditions, use synchronized(this) {}

    private LinkedList<Task> q = new LinkedList<>();
    public TaskQueue(int initialLength) {
        Bpp bpp = new Bpp();
        ArrayList<Task> preShuffle = new ArrayList<>();
        for (int i = 1; i <= initialLength; i++) {
            preShuffle.add(new Task(bpp, i));
        }
        // TODO: randomize which order things show up in the queue
//        Collections.shuffle(preShuffle);
        q.addAll(preShuffle);
    }

    public boolean isEmpty() {
        synchronized (this) {
            return q.isEmpty();
        }
    }

    public int getLength() {
        return q.size();
    }

    public Task getTask() {
        synchronized (this) {
            return q.removeFirst();
        }
    }
}
