package Codes;

import java.util.Stack;

public class CelebrityProblem {
    public static void main(String...args){
        int arr[][]={{ 1, 1, 0 },
                { 0, 1, 0 },
                { 0, 1, 1 }};

        System.out.println(celebrityProblem(arr,0,arr.length));
    }


    // Stack Approach with the O(N) Time and O(N) Space Complexity
    static int celebrityProblem(int[][] arr){
        Stack<Integer> stack =new Stack<>();

        for(int i=0;i<arr.length;i++){
            stack.push(i);
        }

        while(stack.size()>1){
            int val1=stack.pop();
            int val2=stack.pop();

            if(arr[val1][val2]!=0)  stack.push(val2);
            else stack.push(val1);
        }

        int potential=stack.pop();

        for (int i=0;i<arr.length;i++) {
            if(i==potential) continue;


            if(arr[potential][i]!=0 || arr[i][potential]==0)
                return -1;
        }
        return potential;
    }

    // Two Pointer Approach with the O(N) Time and O(1) Space Complexity
    static int celebrityProblem(int[][] arr,int i,int j){
        j-=1;
        while(i<j){
            if (arr[j][i]==1)   j--;
            else    i++;
        }

        int potential = i;

        for(i=0;i<arr.length;i++){
            if(i==potential)    continue;
            if (arr[potential][i] != 0 || arr[i][potential] == 0)
                return -1;
        }
        return potential;
    }
}