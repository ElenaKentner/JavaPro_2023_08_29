package _2023_08_29;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TR2 {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 10; i++) {
            executorService.execute(new ERun2());
        }
        executorService.shutdown();
        System.out.println("Main end");
    }
}

class ERun2 implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "====START");
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + "====END");
    }
}
