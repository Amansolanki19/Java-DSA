package Codes;

import java.util.Stack;

public class PostfixEvaluation {
    public static void main(String...args){
        String postFix = "953+4*6/-";
        Stack<Integer> val = new Stack<>();

        for(int i=0;i<postFix.length();i++){
            char ch = postFix.charAt(i);
            if(Character.isDigit(ch)){
                val.push(ch-'0');
            }
            else{
                int v2 = val.pop();
                int v1=val.pop();
                switch (ch){
                    case '+' :
                        val.push(v1+v2);
                        break;
                    case '-':
                        val.push(v1-v2);
                        break;
                    case '*':
                        val.push(v1*v2);
                        break;
                    case '/':
                        val.push(v1/v2);
                        break;
                }
            }
        }
        System.out.println(val.peek());
    }
}
