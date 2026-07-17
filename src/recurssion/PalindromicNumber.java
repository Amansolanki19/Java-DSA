package recurssion;

import java.util.Scanner;

public class PalindromicNumber {
    static void main() {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number: ");
        int n=sc.nextInt();

        System.out.println("Palindrome number: "+isPalindrome(n));

    }

    static boolean isPalindrome(int n){
        return n==reverse(n,0);
    }
    static int reverse(int n,int rev){
        if (n<=0)   return rev;

        return reverse(n/10,rev*10+n%10);
    }
}
