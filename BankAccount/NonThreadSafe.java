package BankAccount;

public class NonThreadSafe {
    public static void main(String[] args) throws InterruptedException {
        BankAccount account = new BankAccount();

        Runnable task=()->{
            for(int i =0;i<1000;i++){
                account.deposite(1);
                account.withdraw(1);
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("The Balance in the Account : " + account.getBalance());

    }
}
