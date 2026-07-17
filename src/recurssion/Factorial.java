package recurssion;

import java.util.Scanner;

public class Factorial {
    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Number: ");
        int fact=sc.nextInt();
        if(fact<0){
            System.out.println("Factorial cannot be Negative: -1");
        }
        else {
            System.out.println("Factorial: "+factorial(fact));
        }
    }

    public static long factorial(int n){
        if(n==1 || n==0) return 1;

        return n*factorial(n-1);
    }
}
