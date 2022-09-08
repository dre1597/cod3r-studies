import java.util.LinkedList;
import java.util.Queue;

public class QueueCollection {
  public static void main(String[] args) {
    Queue<String> queue = new LinkedList<>();

    queue.add("elem1"); // throws an exception if the queue is full
    queue.offer("elem2"); // do not throw when the queue is full

    System.out.println(queue.peek()); // do not throw when the queue is empty
    System.out.println(queue.element()); // throws an exception if the queue is empty

    System.out.println(queue.size());
//    System.out.println(queue.clear());
//    System.out.println(queue.isEmpty());
    System.out.println(queue.poll()); // do not throw when the queue is empty
    System.out.println(queue.remove()); // throws an exception if the queue is empty
    System.out.println(queue.contains("elem2"));
  }
}
