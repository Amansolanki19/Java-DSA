package Codes;

import java.util.Stack;

public class PrefixEvaluation {
    public static void main(String...args){
        String [] arr={"+*+2345","-*+5623","/+9*342","-*+98/642","+/+823*45","+/*842-73"};

        for(String preFix:arr) {
            Stack<Integer> val = new Stack<>();

            for (int i = preFix.length() - 1; i >= 0; i--) {
                char ch = preFix.charAt(i);
                if (Character.isDigit(ch)) {
                    val.push(Character.getNumericValue(ch));
                } else {
                    int v1 = val.pop();
                    int v2 = val.pop();
                    switch (ch) {
                        case '+':
                            val.push(v1 + v2);
                            break;
                        case '-':
                            val.push(v1 - v2);
                            break;
                        case '*':
                            val.push(v1 * v2);
                            break;
                        case '/':
                            val.push(v1 / v2);
                            break;
                    }
                }
            }
            System.out.println(val.peek());
        }
    }
}
