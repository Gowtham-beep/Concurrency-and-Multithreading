import java.util.concurrent.*;

public class ThreadPoolDemo {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 5; i++) {
            int taskId = i;
            pool.submit(() -> {
                System.out.println("Task " + taskId + " running on " + Thread.currentThread().getName());
                try { Thread.sleep(1000); } catch (InterruptedException e) {}
                System.out.println("Task " + taskId + " finished");
            });
        }

        pool.shutdown();
        pool.awaitTermination(5, TimeUnit.SECONDS);
        System.out.println("All tasks done");
    }
}
