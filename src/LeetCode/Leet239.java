package LeetCode;

import java.util.Arrays;
import java.util.Stack;

public class Leet239 {
    public static void main(String...args){

        int arr[]={1,3,-1,-3,5,3,6,7};
        int k=3;
        int nge[]=new Leet239().nextGreater(arr);
        System.out.println(Arrays.toString(nge));

        System.out.println(Arrays.toString(new Leet239().slidingWindowMaximum(arr, nge, k)));


    }

    public int[] nextGreater(int[] arr) {

        int n = arr.length;
        int[] nge = new int[n];
        Stack<Integer> st = new Stack<>();

        nge[n - 1] = n;
        st.push(n - 1);

        for (int i = n - 2; i >= 0; i--) {

            while (!st.isEmpty() && arr[i] >= arr[st.peek()]) {
                st.pop();
            }

            if (st.isEmpty())
                nge[i] = n;
            else
                nge[i] = st.peek();

            st.push(i);
        }

        return nge;
    }

    public int[] slidingWindowMaximum(int[] arr, int[] nge, int k) {

        int[] ans = new int[arr.length - k + 1];
        int j = 0;

        for (int i = 0; i <= arr.length - k; i++) {

            if (j < i)
                j = i;

            while (nge[j] < i + k) {
                j = nge[j];
            }

            ans[i] = arr[j];
        }

        return ans;
    }
}
