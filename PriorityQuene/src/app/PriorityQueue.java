/**
 * CSIS312 Assignment 8 - Priority Quene
 * @author Benjamin Turner and Jack Skywalker
 * - I have not discussed the source code in my program with anyone other than my instructor’s approved human sources (i.e. programming partner).
 * - I have not used source code obtained from another student, or any other unauthorized source, either modified or unmodified.
 * - If any source code or documentation used in my program was obtained from another source, such as a text book or course notes, that has been clearly noted with a proper citation in the comments of my program.
 * - I have not knowingly designed this program in such a way as to defeat or interfere with the normal operation of any machine it is graded on or to produce apparently correct results when in fact it does not.
 */

package app;

import java.util.LinkedList;

/*
- I have not discussed the source code in my program with anyone other than my instructor’s approved human sources (i.e. programming partner).

- I have not used source code obtained from another student, or any other unauthorized source, either modified or unmodified.

- If any source code or documentation used in my program was obtained from another source, such as a text book or course notes, that has been clearly noted with a proper citation in the comments of my program.

- I have not knowingly designed this program in such a way as to defeat or interfere with the normal operation of any machine it is graded on or to produce apparently correct results when in fact it does not.
 */

public class PriorityQueue<E> {

    // Create a linked list for tasks
    private LinkedList<E> tasks;
    // Create a linked list for priorities
    private LinkedList<Integer> priorities;

    // Constructor to initialize the task and priority lists
    public PriorityQueue() {
        tasks = new LinkedList<>();
        priorities = new LinkedList<>();
    }

    // Method to enqueue an item given a priority number
    public void enqueue(E item, int priority) {
        // Initialize an index
        int index = 0;
        // Find the correct index based on priority
        while (index < priorities.size() && priority >= priorities.get(index)) {
            index++;
        }
        // Insert item and priority at the determined index
        tasks.add(index, item);
        priorities.add(index, priority);
    }

    // Method to dequeue the item with the highest priority
    public E dequeue() {
        // Exception handling for if the queue is empty
        if (isEmpty()) {
            throw new IllegalStateException("Priority queue is empty");
        } // Remove and return the last item from tasks
        return tasks.removeLast();
    }

    // Method to get the size of the priority queue
    public int size() {
        return tasks.size();
    }

    // Method to clear the priority queue
    public void clear() {
        tasks.clear();
        priorities.clear();
    }

    // Method to check if the priority queue is empty
    public boolean isEmpty() {
        return tasks.isEmpty();
    }
}
