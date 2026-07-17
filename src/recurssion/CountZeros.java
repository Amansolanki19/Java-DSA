package recurssion;

import java.util.Scanner;

public class CountZeros {
    static void main() {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the Number: ");
        int n=sc.nextInt();
        System.out.println("Count Zeros: "+countZeros(n,0));
    }
    static int countZeros(int n,int count){
        if(n<=0)    return count;

        if(n%10==0) count++;

        return countZeros(n/10,count);
    }
}
