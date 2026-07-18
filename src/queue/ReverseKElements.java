package queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseKElements {
    public static void main(String...args){
        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        int k=3;

        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(6);
        queue.add(7);
        queue.add(8);

        while(k>0){
            stack.push(queue.remove());
            k--;
        }

        int leftSize=queue.size()-k;

        while(leftSize>0){
            queue.add(queue.remove());
            leftSize--;
        }

        System.out.println(queue);
    }
}
