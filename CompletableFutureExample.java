import java.util.concurrent.*;

public class CompletableFutureExample {
    public static void main(String[] args) throws Exception {
        // Run async task
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000); // simulating a delay
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return "Hello from CompletableFuture!";
        });

        // Non-blocking callback
        future.thenAccept(result -> {
            System.out.println("Result: " + result);
        });

        System.out.println("Doing other work while waiting...");

        // Prevent main from exiting immediately
        Thread.sleep(6000);
    }
}
