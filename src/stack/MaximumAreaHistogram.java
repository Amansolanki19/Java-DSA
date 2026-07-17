package stack;

import java.util.Stack;

public class MaximumAreaHistogram {
    static void main() {

        int[] arr = {2,1,5,6,2,3};
        int maxArea=new MaximumAreaHistogram().largestRectangleArea(arr);

        System.out.println("Maximum Area: "+maxArea);
    }

    public int largestRectangleArea(int[] heights) {

        int n = heights.length;

        int[] nse = nextSmallerElement(heights, n);
        int[] pse = previousSmallerElement(heights, n);

        return maximumArea(heights, nse, pse, n);
    }

    int[] nextSmallerElement(int[] heights, int n) {

        Stack<Integer> st = new Stack<>();
        int[] nse = new int[n];

        for (int i = n - 1; i >= 0; i--) {

            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }

            if (st.isEmpty())
                nse[i] = n;
            else
                nse[i] = st.peek();

            st.push(i);
        }

        return nse;
    }

    int[] previousSmallerElement(int[] heights, int n) {

        Stack<Integer> st = new Stack<>();
        int[] pse = new int[n];

        for (int i = 0; i < n; i++) {

            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }

            if (st.isEmpty())
                pse[i] = -1;
            else
                pse[i] = st.peek();

            st.push(i);
        }

        return pse;
    }

    int maximumArea(int[] heights, int[] nse, int[] pse, int n) {

        int max = 0;

        for (int i = 0; i < n; i++) {

            int width = nse[i] - pse[i] - 1;
            int area = heights[i] * width;

            max = Math.max(max, area);
        }

        return max;
    }
}
