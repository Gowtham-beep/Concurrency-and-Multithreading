import java.util.*;

class Drop{
    private Queue<Integer> queue = new LinkedList<>();
    private final int LIMIT = 5;

    public synchronized void put(int value) throws InterruptedException{
        while(queue.size()== LIMIT) wait();
        queue.add(value);
        System.out.println("Produced"+ value);
        notifyAll();
    }
    public synchronized int take() throws InterruptedException{
        while(queue.isEmpty()) wait();
        int val = queue.remove();
        System.out.println("Consumed:"+ val);
        notifyAll();
        return val;
    }
}

public class ProducerConsumer {
    public static void main(String[] args) {
        Drop drop = new Drop();

        Thread producer = new Thread(()->{
            try {
                for(int i =0; i <10;i++){
                    drop.put(i);
                    
                }
            } catch (InterruptedException ignored) {}
        });
        Thread consumer = new Thread(()->{
            try {
                for(int i =0;i<10;i++){
                    drop.take();
                    
                }
            } catch (InterruptedException ignored) {}
        });
        producer.start();
        consumer.start();
    }
}
