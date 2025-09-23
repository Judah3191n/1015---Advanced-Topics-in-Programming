
// Threading = Allows a program to run multiple tasks simultaneously
//             Helps improve performance with time-consuming operations
//             (File I/O, network communications, or any background tasks)

// How to create a Thread
// Option 1: Extend the Thread class (simpler)
// Option 2: Implement the Runnable interface (better)


// ============================================
// Example 1: Creating a Thread by Extending Thread
// ============================================
class MyThread extends Thread {
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println("MyThread running... step " + i);
            try {
                Thread.sleep(500); // pause 0.5 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

// ============================================
// Example 2: Creating a Thread by Implementing Runnable
// ============================================
class MyRunnable implements Runnable {
    private String name;
    public MyRunnable() {
        this.name = name;
    }
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(name + " running... step " + i);
            try {
                Thread.sleep(700); // pause 0.7 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

// ============================================
// Example 3: Multiple Threads Running Together
// ============================================
public class ThreadsExamples {
    public static void main(String[] args) {
        System.out.println("=== Example 1: Extending Thread ===");
        MyThread t1 = new MyThread();
        t1.start();

        // Wait before starting next example
        try { Thread.sleep(2000); } catch (InterruptedException e) {}

        System.out.println("\n=== Example 2: Implementing Runnable ===");
        Thread t2 = new Thread(new MyRunnable("RunnableTask"));
        t2.start();

        try { Thread.sleep(2500); } catch (InterruptedException e) {}

        System.out.println("\n=== Example 3: Multiple Threads Together ===");
        Thread t3 = new MyThread();
        Thread t4 = new Thread(new MyRunnable("TaskA"));
        Thread t5 = new Thread(new MyRunnable("TaskB"));

        // Start them all at once
        t3.start();
        t4.start();
        t5.start();

        // Main thread also keeps running
        for (int i = 1; i <= 3; i++) {
            System.out.println("[Main Thread] Still alive... " + i);
            try {
                Thread.sleep(600); // pause 0.6 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("\n=== All examples finished ===");
    }
}
