import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class TaskQueue {
    private final LinkedList<Task> q = new LinkedList<>();
    private int tasksDone = 0;
    public TaskQueue(int initialLength) {
        ArrayList<Task> preShuffle = new ArrayList<>();
        for (int i = 1; i <= initialLength; i++) {
            preShuffle.add(new Task(i));
        }
        Collections.shuffle(preShuffle);
        q.addAll(preShuffle);
    }

    public synchronized boolean isEmpty() {
        return q.isEmpty();
    }

    public synchronized int getLength() {
        return q.size();
    }

    public synchronized Task getTask() {
        tasksDone += 1;
        if (tasksDone >= 10) {
            tasksDone = 0;
            System.out.print(".");
            System.out.flush();
        }
        return q.removeFirst();
    }
}
