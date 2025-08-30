package BankAccount;

public class BankAccount {

    private  int balance=100;

    public synchronized void deposite(int amt){
        balance+=amt;
    }
    public synchronized void withdraw(int amt){
        balance -=amt;
    }
    public synchronized int getBalance(){
        return balance;
    }

}