package Thread;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

//        🔹 Basic Thread Creation
//        Create and run a simple thread
//        Task: Create a class that extends Thread, override run() method, and print "Hello from thread". Start the thread.

        Thread.ThreadSample threadSample = new Thread.ThreadSample();
            threadSample.start();

//------------------------------------------------------------------------------------------------------------------------------------------
//        Implement Runnable interface
//        Task: Create a class that implements Runnable and prints the current thread name and a message.

        Thread.RunnableSample runnableSample= new Thread.RunnableSample();
        Thread thread1 = new Thread(runnableSample);
        thread1.start();

//------------------------------------------------------------------------------------------------------------------------------------------
//        Thread Sleep and Join
//        Task: Print numbers 1 to 5 with a 1-second delay between each number using sleep().

        for (int i=1; i<=5 ;i++){
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

//------------------------------------------------------------------------------------------------------------------------------------------
//        Use Thread.join()
//        Task: Create two threads. Make the main thread wait for them to finish using join().

        Thread t1 = new Thread(()->{
            System.out.println("thread t1 is running ");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread t2 = new Thread(()->{
            System.out.println("thread t2 is running ");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("two threads are finished");

//-------------------------------------------------------------------------------------------------------------------------------
//        Create a Thread.BankAccount class shared between two types of threads:
//        Depositor Thread: adds money to the account.
//                Withdrawer Thread: takes money from the account.

        BankAccount account = new BankAccount();
        Thread depositThread = new Thread(()->{
            try {
                while (true){
                    int amount = 100;
                    account.deposit(amount);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread withdrawThread = new Thread(()->{
            try {
                while (true){
                    int amount = 50;
                    account.withdraw(amount);
                    Thread.sleep(800);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        depositThread.start();
        withdrawThread.start();

    }
}