 class SharedResource {
    public synchronized void printNumber(){
        for(int i=0;i<5;i++){
            System.out.println(Thread.currentThread().getName()+"Prints"+i);
            // try{Thread.sleep(500);}catch(InterruptedException ignored){}
        }
    }
}

public class LockDemo {
public static void main(String[] args) {
    SharedResource resources = new SharedResource();

    Thread t1 = new Thread(()->resources.printNumber(),"Thread-1");
    Thread t2 = new Thread(()->resources.printNumber(),"Thread-2");

    t1.start();
    t2.start();
}
    
}
