package recurssion;

import java.util.Scanner;

public class ProductOfDigits {
    static void main() {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number: ");
        int n=sc.nextInt();
        System.out.println("Product: "+product(n));
    }
    static int product(int n){
        if(n==0)    return 1;

        return n%10*product(n/10);
    }
}
