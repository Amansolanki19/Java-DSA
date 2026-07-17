package recurssion;

import java.util.Stack;

public class InsertAtIndexRecursively {
    static Stack<Integer> st = new Stack<>();
    static void main() {
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        st.push(6);
        st.push(7);

        new InsertAtIndexRecursively().insert(10,2);

        System.out.println(st);

    }

    void insert(int val){
        if(st.isEmpty()){
            st.push(val);
            return;
        }

        int top=st.pop();

        insert(val);

        st.push(top);

    }

    void insert(int val, int pos) {
        if (pos == 1) {
            st.push(val);
            return;
        }

        int top = st.pop();
        insert(val, pos-1);
        st.push(top);
    }
}
