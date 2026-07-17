package backtracking;

import java.util.Scanner;

public class MazeProblem {
    static void main() {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Position of the Maze in Matrix: ");
        System.out.print("Row: ");
        int row=sc.nextInt();
        System.out.print("Column: ");
        int col=sc.nextInt();
        System.out.println("Total number of Ways are: "+count(row,col));
    }

    static int count(int row,int col){
        if(row==1 || col==1)    return 1;

        int left=count(row-1,col);
        int right=count(row,col-1);

        return left+right;
    }
}
