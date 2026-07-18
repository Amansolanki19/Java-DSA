package queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseQueue {
    public static void main(String...args){
        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();

        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(6);
        queue.add(7);
        queue.add(8);

        System.out.println("Original Queue: ");
        System.out.println(queue);

        while (!queue.isEmpty())    stack.push(queue.remove());


        while (!stack.isEmpty())    queue.add(stack.pop());


        System.out.println("Reversed Queue: ");
        System.out.println(queue);

    }
}
