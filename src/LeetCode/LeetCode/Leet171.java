package LeetCode;

import java.util.Scanner;

public class Leet171 {
    public static void main(String...args){
        String str="zy".toUpperCase();
        System.out.println(columnIndexValue(str));
    }
    public static int columnIndexValue(String str){
        int sum=0,phaseValue=0;
        int len=str.length()-1;
        for(int i=len;i>=0;i--){
            int temp=str.charAt(i)-64;
            sum = (int) (sum + Math.pow(26, phaseValue++) * temp);
        }
        return sum;
    }
}
