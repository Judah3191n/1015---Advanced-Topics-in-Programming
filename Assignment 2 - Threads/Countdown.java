public class Countdown extends Thread {

    public void run() {
        for (int i = 1; i <= 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Thread inturrped - Judah");
                return;
            }

            if (Main.answered) {
                return;
            }

            if (i < 10) {
                System.out.println(i + " second(s) passed!");
            }
        }

        if (!Main.answered) {
            System.out.println("Time's up! You didn't answere in time.");
            System.exit(0);
        }
    }
}