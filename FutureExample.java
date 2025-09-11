import java.util.concurrent.*;

public class FutureExample {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Future<String> future = executor.submit(() -> {
            Thread.sleep(2000); // simulating a delay
            return "Hello from Future!";
        });

        System.out.println("Doing other work...");
        Thread.sleep(6000);

        // Blocking call (waits until result is ready)
        System.out.println(future.get());

        executor.shutdown();
    }
}
