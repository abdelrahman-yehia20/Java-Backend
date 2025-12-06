package Thread;

public class BankAccount {

    float balance;

    synchronized void deposit(int amount){
        balance += amount;
        System.out.println("Deposit " +amount+ " New balance: " +balance);
        notify();
    }

    synchronized void withdraw(int amount){
        while (balance < amount){
            System.out.println("Not enough balance " +balance + "waiting for deposit");
            try {
                wait();
            } catch (InterruptedException e) {
                e.getMessage();
            }
        }
        balance -= amount;
        System.out.println("Withdrew: " + amount + " | New Balance: " + balance);
    }
}
