// MyRunnable.java
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        // Countdown timer (10 seconds)
        for (int i = 1; i <= 10; i++) {
            try {
                Thread.sleep(1000); // wait 1 second
            } catch (InterruptedException e) {
                System.out.println("Thread was interrupted");
            }

            if (i < 10) {
                System.out.println( i + " second(s) passed...");
            }

            // At the last second, print "Time's up!" and exit
            if (i == 10) {
                System.out.println("Time's up!");
                System.exit(0); // End program when timer finishes
            }
        }
    }
}
