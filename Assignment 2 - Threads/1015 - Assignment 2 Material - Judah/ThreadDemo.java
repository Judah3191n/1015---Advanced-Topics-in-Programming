// ThreadDemo.java
import java.util.Scanner;

public class ThreadDemo {
    public static void main(String[] args) {
        System.out.print("You have 10 seconds to enter your name: ");

        // Create and start timer thread
        MyRunnable myRunnable = new MyRunnable();
        Thread timerThread = new Thread(myRunnable);

        // Optionally make the timer a daemon thread:
        // timerThread.setDaemon(true);

        timerThread.start();

        // Main thread handles user input
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println(" Hello, " + name + "!");
        scanner.close();

        // If user enters before time is up, stop the timer
        System.exit(0);
    }
}
