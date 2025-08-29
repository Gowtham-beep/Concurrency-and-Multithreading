package CompletableFuture;

import java.util.concurrent.*;;

public class StockService {
    public static String getPrice(String stock){
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return stock + "price: "+(100 +(int)(Math.random()*50));
    }
}
