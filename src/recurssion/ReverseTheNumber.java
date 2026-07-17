package recurssion;

import java.util.Scanner;

public class ReverseTheNumber {
    static void main() {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the Number: ");
        int n=sc.nextInt();
        System.out.println("Reverse: "+reverse(n,0));
    }
    static int reverse(int n, int rev){
        if(n<=0) return rev;
        return reverse(n/10,rev*10+n%10);
    }
}
