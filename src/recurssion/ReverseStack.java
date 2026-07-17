package recurssion;
import java.util.Stack;

public class ReverseStack {

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();

        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        st.push(6);
        st.push(7);

        reverse(st);

        System.out.println(st);
    }

    static void reverse(Stack<Integer> st) {
        if (st.isEmpty()) {
            return;
        }

        int top = st.pop();

        reverse(st);

        insertAtBottom(st, top);
    }

    static void insertAtBottom(Stack<Integer> st, int val) {
        if (st.isEmpty()) {
            st.push(val);
            return;
        }

        int top = st.pop();

        insertAtBottom(st, val);

        st.push(top);
    }
}