package stack;


import java.util.Stack;

public class ConsecutiveSubsequence {

    public static void main(String[] args) {

        int[] arr = {1,1,2,2,3,10,10,10,4,4,4,7,9,9};

        Integer[] result =
                new ConsecutiveSubsequence().consecutiveSubsequence(arr);

        for (int num : result) {
            System.out.print(num + " ");
        }
    }

    Integer[] consecutiveSubsequence(int[] arr) {

        Stack<Integer> st =new Stack<>();
        for(int i=0;i<arr.length;i++){
            if(st.isEmpty())    st.push(arr[i]);
            if(st.peek()!=arr[i])   st.push(arr[i]);
            if(arr[i]==st.peek()){
                if(i==arr.length-1 || arr[i]==arr[i+1]) ;
                else st.pop();
            }

        }

        return st.toArray(new Integer[0]);
    }
}