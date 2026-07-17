package recurssion;

import java.util.Scanner;

public class Nto1 {
    static void main() {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number: ");
        int n=sc.nextInt();
        printNumber(n);
    }

    static void printNumber(int n){
        if(n==0)    return;

        System.out.println(n);

        printNumber(n-1);

    }
}
