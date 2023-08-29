package _2023_08_29;

import java.io.FileWriter;
import java.io.IOException;

public class DE {
    public static void main(String[] args) {
        System.out.println("Main start");

        UT ut = new UT();
        ut.setName("User thread");

        DT dt = new DT();
        dt.setName("Daemon thread");

        dt.setDaemon(true);

        ut.start();
        dt.start();

        System.out.println("Main end");


    }
}

class UT extends Thread{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " : isDemon -> " + isDaemon());
        for (char i = 'A'; i <= 'Z'; i++) {
            try {
                Thread.sleep(300);
                System.out.println("CHAR: " + i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}

class DT extends Thread{

    @Override
    public void run() {
        try (FileWriter fileWriter = new FileWriter("dt.txt")) {
            System.out.println(Thread.currentThread().getName() + " : isDaemon -> " + isDaemon());
            for (int i = 0; i < 50; i++) {
                System.out.println("INT: " + i);
                Thread.sleep(300);
                fileWriter.write("INT: " + i);
            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
