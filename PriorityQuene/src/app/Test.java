/**
 * CSIS312 Assignment 8 - Priority Quene
 * @author Benjamin Turner and Jack Skywalker
 * - I have not discussed the source code in my program with anyone other than my instructor’s approved human sources (i.e. programming partner).
 * - I have not used source code obtained from another student, or any other unauthorized source, either modified or unmodified.
 * - If any source code or documentation used in my program was obtained from another source, such as a text book or course notes, that has been clearly noted with a proper citation in the comments of my program.
 * - I have not knowingly designed this program in such a way as to defeat or interfere with the normal operation of any machine it is graded on or to produce apparently correct results when in fact it does not.
 */

package app;

/*
- I have not discussed the source code in my program with anyone other than my instructor’s approved human sources (i.e. programming partner).

- I have not used source code obtained from another student, or any other unauthorized source, either modified or unmodified.

- If any source code or documentation used in my program was obtained from another source, such as a text book or course notes, that has been clearly noted with a proper citation in the comments of my program.

- I have not knowingly designed this program in such a way as to defeat or interfere with the normal operation of any machine it is graded on or to produce apparently correct results when in fact it does not.
 */

public class Test {
    public static void main(String[] args) {

        // Create an instance of PriorityQueue
        PriorityQueue<String> priorityQueue = new PriorityQueue<>();
        System.out.println("Queueing:");

        // Enqueueing tasks with random priorities
        for (int i = 0; i < 10; i++) {
            int priority = (int) (Math.random() * 100);
            String task = "Task With Priority " + priority;
            priorityQueue.enqueue(task, priority);
            System.out.println("Queued: " + task);
        }

        System.out.println("\nDe-Queueing:");
        
        // Dequeue and print tasks until the priority queue is empty
        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.dequeue());
        }
    }
}
