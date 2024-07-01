import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();

        queue.add("apple");
        queue.add("banana");
        queue.add("cherry");

        System.out.println("Front element: " + queue.peek());

        System.out.println("Dequeued element: " + queue.poll());
        System.out.println("Dequeued element: " + queue.poll());

        System.out.println("Is queue empty? " + queue.isEmpty());

        System.out.println("Size of queue: " + queue.size());
    }
}
