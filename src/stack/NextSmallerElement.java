package stack;

import java.util.Stack;

public class NextSmallerElement {

    public static void main(String[] args) {

        int arr[] = {1, 5, 3, 2, 1, 6, 3, 4};

        int[] result = nextSmaller(arr);

        for (int a : result)
            System.out.print(a + " ");
    }

    static int[] nextSmaller(int[] arr) {

        Stack<Integer> st = new Stack<>();
        int[] result = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {

            while (!st.isEmpty() && st.peek() >= arr[i]) {
                st.pop();
            }

            if (st.isEmpty())
                result[i] = -1;
            else
                result[i] = st.peek();

            st.push(arr[i]);
        }

        return result;
    }
}