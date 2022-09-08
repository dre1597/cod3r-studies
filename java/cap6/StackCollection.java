import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class StackCollection {
  public static void main(String[] args) {
    Stack<String> stack = new Stack<>();
    Deque<String> deque = new ArrayDeque<>();

    stack.add("elem1"); // do not throw when the stack is full
    stack.push("elem1"); // throws an exception if the stack is full

    deque.add("elem1"); // do not throw when the stack is full
    deque.push("elem1"); // throws an exception if the stack is full

//    System.out.println(stack.poll()); // do not throw when the stack is empty
    System.out.println(stack.pop()); // throws an exception if the stack is empty

    System.out.println(deque.poll()); // do not throw when the stack is empty
    System.out.println(deque.pop()); // throws an exception if the stack is empty


  }
}
