package CompletableFuture;
import java.util.concurrent.*;

public class StockFetcher {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        CompletableFuture<String> google = CompletableFuture.supplyAsync(() -> StockService.getPrice("GOOG"));
        CompletableFuture<String> amazon = CompletableFuture.supplyAsync(() -> StockService.getPrice("AMZN"));
        CompletableFuture<String> apple  = CompletableFuture.supplyAsync(() -> StockService.getPrice("AAPL"));

        // Wait for all to finish
        CompletableFuture<Void> all = CompletableFuture.allOf(google, amazon, apple);
        CompletableFuture<String> report = google.thenCombine(amazon,(g,a)->"Stock Report:\n" + g + "\n" + a);

        CompletableFuture<String> future = CompletableFuture.supplyAsync(()->{
            if(true) throw new RuntimeException("API Failed");
            return "Some price"; 

        }).exceptionally(ex->"Default price used: 999");
        all.join(); // block until all complete

        try {
            System.out.println(google.get());
            System.out.println(amazon.get());
            System.out.println(apple.get());
            System.out.println("-=-=-=-=-=-=-=-");
            System.out.println(report.join());
            System.out.println("-=-=-=-=-=-=-=-");
            System.out.println(future.join());
        } catch (Exception e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.println("⏱ Fetched all in " + (end - start)/1000 + " seconds");
    }
}
