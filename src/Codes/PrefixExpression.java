package Codes;

import java.util.Stack;

public class PrefixExpression {
    public static void main(String...args){
        String infix="9-(5+3)*4/6";
        Stack<String> val= new Stack<>();
        Stack<Character> op = new Stack<>();

        for(int i=0;i<infix.length();i++){
            char ch = infix.charAt(i);
            if(Character.isDigit(ch)){
                val.push(String.valueOf(ch));
            }
            else if(op.isEmpty() || ch=='(' || op.peek()=='('){
                op.push(ch);
            } else if (ch==')') {
                while(op.peek()!='('){
                    String v2=val.pop();
                    String v1=val.pop();
                    char operator=op.pop();

                    String expression = operator + v1 + v2;

                    val.push(expression);
                }
                op.pop();
            }
            else{
                if(ch=='+' || ch=='-'){

                    while(!op.isEmpty() && op.peek()!='('){

                        String v2 = val.pop();
                        String v1 = val.pop();
                        char operator = op.pop();

                        val.push(operator + v1 + v2);
                    }

                    op.push(ch);
                }
                else if(ch=='*' || ch=='/'){

                    while(!op.isEmpty()
                            && op.peek()!='('
                            && (op.peek()=='*' || op.peek()=='/')){

                        String v2 = val.pop();
                        String v1 = val.pop();
                        char operator = op.pop();

                        val.push(operator + v1 + v2);
                    }

                    op.push(ch);
                }
            }
        }
        while(!op.isEmpty()){
            String v2=val.pop();
            String v1=val.pop();
            char operator=op.pop();

            String expression = operator + v1 + v2;

            val.push(expression);
        }
        System.out.println(val.peek());
    }
}
