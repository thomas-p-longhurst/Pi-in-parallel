public class WorkerThread extends Thread {
    private TaskQueue tq;
    private ResultTable rt;
    private Bpp bpp;

    public WorkerThread(TaskQueue tq, ResultTable rt) {
        this.tq = tq;
        this.rt = rt;
        bpp = new Bpp();
    }

    public void run() {
        while (!tq.isEmpty()) {
            Task task = tq.getTask();
            rt.setDigit(task.getTarget(), task.calculate(bpp));
        }
    }
}
