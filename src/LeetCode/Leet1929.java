package LeetCode;

import java.util.Arrays;

public class Leet1929 {
    public static void main(String...args){
        int arr[]={1,2,3};
        System.out.println(Arrays.toString(getConcatinate(arr)));
    }
    public static int[] getConcatinate(int[] arr){
        int newArray[]= new int[arr.length*2];
        int n=arr.length;

        for(int i=0;i<arr.length;i++){
            newArray[i]=arr[i];
            newArray[n+i]=newArray[i];
        }

        return newArray;
    }
}
