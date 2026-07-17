package stack;

import java.util.Iterator;
import java.util.Stack;

public class ReverseTheStack {

    public static void main(String[] args) {

        Stack<Integer> st = new Stack<>();

        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        st.push(6);
        st.push(7);

        Stack<Integer> rev = new Stack<>();

        while (!st.isEmpty()) {
            rev.push(st.pop());
        }

        System.out.println("Reversed Stack:");

        Iterator<Integer> itr = rev.iterator();

        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }
    }
}