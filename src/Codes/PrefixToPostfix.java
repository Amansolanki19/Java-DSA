package Codes;

import java.util.Stack;

public class PrefixToPostfix {
    public static void main(String...args){
        String [] arr ={"+*+2345","-*+5623","/+9*342","-*+98/642","+/+823*45","+/*842-73"};
        for(String preFix:arr){
            Stack<String> val = new Stack<>();
            for(int i=preFix.length()-1;i>=0;i--){
                char ch = preFix.charAt(i);
                if(Character.isDigit(ch)){
                    val.push(String.valueOf(ch));
                }else{
                    String v1=val.pop();
                    String v2=val.pop();
                    String result = v1+v2+ch;
                    val.push(result);
                }
            }
            System.out.println(val.peek());
        }
    }
}
