package recurssion;

import java.util.Stack;

public class DisplayStackRecursively {
    static void main() {
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        st.push(6);
        st.push(7);

        DisplayStackRecursively dsr  = new DisplayStackRecursively();
        dsr.display(st);

        System.out.println("Size: "+st.size());
    }

    void display(Stack<Integer> st){
        if(st.isEmpty())    return;

        int top=st.pop();

        display(st);
        st.push(top);
        System.out.println(top);

    }
}
