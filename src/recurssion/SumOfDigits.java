package recurssion;

import java.util.Scanner;

public class SumOfDigits {
    static void main() {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the Number: ");
        int n=sc.nextInt();
        if(n<10){
            System.out.println("Sum: "+n);
        }else{
            System.out.println("Sum: "+sum(n));
        }
    }
    static int sum(int n){
        if(n==0)return 0;

        return n%10+sum(n/10);
    }
}
