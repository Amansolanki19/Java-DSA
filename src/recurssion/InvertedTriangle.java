package recurssion;

import java.util.Scanner;

public class InvertedTriangle {
    static void main() {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number: ");
        int n=sc.nextInt();
        printPattern(n);
        System.out.println();
        System.out.println();
        rowAndColumn(n,0);
    }

    static void printPattern(int n){
        if(n==0)    return;
        helper(n);
        System.out.println();
        printPattern(n-1);
    }
    static void helper(int n){
        if(n==0)    return;
        System.out.print("* ");
        helper(n-1);
    }

    static void rowAndColumn(int row,int col){
        if (row == 0) return;

        if (col < row) {
            System.out.print("* ");
            rowAndColumn(row, col + 1);   // move in same row
        } else {
            System.out.println();
            rowAndColumn(row - 1, 0);     // move to next row
        }
    }
}
