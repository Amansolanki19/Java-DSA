package stack;

import java.util.Iterator;
import java.util.Stack;

public class InsertAtIndex {

    static Stack<Integer> st = new Stack<>();
    static void main() {

        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        st.push(6);
        st.push(7);

        new InsertAtIndex().insertAtIndex(5);

        Iterator<Integer> itr = st.iterator();

        while (itr.hasNext()){
            System.out.print(itr.next());
        }

        System.out.println();

        System.out.println(st.size());


    }

    void insertAtIndex(Integer num){
        Stack<Integer> dummyStack = new Stack<>();

        while (!st.isEmpty()){
            dummyStack.push(st.pop());
        }
        st.push(num);
        while (!dummyStack.isEmpty()){
            st.push(dummyStack.pop());
        }
    }

    void insertAtIndex(Integer num, Integer index) {

        if (index < 0 ) {
            throw new IndexOutOfBoundsException("Invalid index");
        } else if (index>st.size()) {
            st.push(num);
            return;
        }

        Stack<Integer> dummyStack = new Stack<>();

        int size = st.size();

        for (int i = 0; i < size - index+1; i++) {
            dummyStack.push(st.pop());
        }

        st.push(num);

        while (!dummyStack.isEmpty()) {
            st.push(dummyStack.pop());
        }
    }
}
