package LeetCode;

import java.util.Scanner;

public class Leet1342 {
    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Number: ");
        int n = sc.nextInt();
        System.out.println("Steps: "+numberOfSteps(n));
    }
    static int numberOfSteps(int num){

        return helper(num,0);
    }

    static int helper(int num,int steps){
        if(num<=0)  return steps;

        if(num%2==0)    return helper(num/2,steps+1);

        else return helper(num-1,steps+1);
    }
}
