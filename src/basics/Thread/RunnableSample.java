package Thread;

public class RunnableSample implements Runnable{
    @Override
    public void run() {
        System.out.println("Thread name: "+Thread.currentThread().getName());
        System.out.println("thread sample message ");
    }
}
