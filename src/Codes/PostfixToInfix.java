package Codes;

import java.util.Stack;

public class PostfixToInfix {
    public static void main(String...args){
         String postfix = "95-34*6/+" ;

        Stack<String> expression = new Stack<>();

        for(int i=0;i<postfix.length();i++){
            char ch = postfix.charAt(i);
            if(Character.isDigit(ch)){
                expression.push(String.valueOf(ch));
            }
            else{
                String v2 = expression.pop();
                String v1 = expression.pop();
                String resultString = v1 + ch + v2;
                expression.push(resultString);
            }
        }
        System.out.println(expression.peek());
    }
}
