package recurssion;

import java.util.Scanner;

public class SumOfNumbers {
    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Number: ");
        int n = sc.nextInt();
        System.out.println("Sum: "+sum(n));
    }
    static long sum(int n){
        if(n==0)return 0;

        return n+sum(n-1);
    }
}
