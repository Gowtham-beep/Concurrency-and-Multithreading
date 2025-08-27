import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class SharedCounter{
    private int count = 0;
    private final Lock lock = new ReentrantLock();

    public void increment(){
        lock.lock();
        try{
            count++;
            System.out.println(Thread.currentThread().getName()+"-->count:"+count);

        }finally{
            lock.unlock();
        }
    }
}
public class ExplicitLockDemo {
    public static void main(String[] args) {
        SharedCounter counter = new SharedCounter();
    Runnable task=()->{
        for (int i=0;i<5;i++){
            counter.increment();
        }
    };
    Thread t1 = new Thread(task,"T1");
    Thread t2 = new Thread(task, "t2");

    t1.start();
    t2.start();
    }
    

}
