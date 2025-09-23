import java.util.Scanner;

public class Main {
    static boolean answered = false;

    public static void main(String[] args) {
        System.out.println("You have 10 seconds to enter your name!: ");

        Countdown countdown = new Countdown();
        Thread timedThread = new Thread(countdown);

        timedThread.start();

        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        answered = true;
        System.out.println("Hello " + name + "!");
        scanner.close();
    }
}
