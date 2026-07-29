package LeetCode;


public class Leet59 {
    public static void main(String...args){

        int n=5;

        int[][] arr=spiralMatrix(n);

        for(int []a:arr){
            for(int b:a)
                System.out.print(b+" ");

            System.out.println();
        }



    }

    public static int[][] spiralMatrix(int n){
        int arr[][]=new int[n][n];

        int top=0,bottom=n-1,left=0,right=n-1;
        int num=1;

        while(top<=bottom && left<=right) {
            for (int i = left; i <= right; i++)
                arr[top][i] = num++;
            top++;

            for (int i = top; i <= bottom; i++)
                arr[i][right] = num++;
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--)
                    arr[bottom][i] = num++;
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--)
                    arr[i][left] = num++;
                left++;
            }
        }

        return arr;
    }
}
