package Codes;

import java.util.Stack;

public class PostfixToPrefix {
    public static void main(String...args){
        String[] arr={"23+4*5+","56+2*3-", "934*+2/","98+64/*2-", "82+3/45*+", "84*2/73-+"};

        for(String postFix:arr){
            Stack<String> val=new Stack<>();
            for(int i=0;i<postFix.length();i++){
                char ch = postFix.charAt(i);
                if(Character.isDigit(ch)){
                    val.push(String.valueOf(ch));
                }
                else{
                    String v2=val.pop();
                    String v1=val.pop();

                    String result=ch+v1+v2;

                    val.push(result);
                }
            }
            System.out.println(val.peek());
        }
    }
}
