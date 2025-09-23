import java.util.Scanner;

public class CountdownQuiz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Quick Quiz: What is 5 + 3 ?");
        System.out.println("You have 5 seconds to answer...");

        // Countdown loop
        for (int i = 5; i > 0; i--) {
            System.out.println("Time left: " + i + " seconds");
            try {
                Thread.sleep(1000); // wait 1 second
            } catch (InterruptedException e) {
                System.out.println("Timer interrupted!");
            }
        }

        // Ask for input after countdown
        System.out.print("Enter your answer: ");
        int answer = scanner.nextInt();

        // Check the answer
        if (answer == 8) {
            System.out.println(" Correct!");
        } else {
            System.out.println("Wrong. The answer is 8.");
        }

        scanner.close();
    }
}
