package stack;

import java.util.Stack;

public class InfixExpression {

    public static void main(String... args) {

        String expression = "((9-5)*(8-(2+1)))";

        Stack<Integer> val = new Stack<>();
        Stack<Character> op = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {

            char ch = expression.charAt(i);

            if (Character.isDigit(ch)) {
                val.push(ch - '0');
            }

            else if (ch == '(') {
                op.push(ch);
            }

            else if (ch == ')') {

                while (op.peek() != '(') {

                    int v2 = val.pop();
                    int v1 = val.pop();

                    if (op.peek() == '+') val.push(v1 + v2);
                    if (op.peek() == '-') val.push(v1 - v2);
                    if (op.peek() == '*') val.push(v1 * v2);
                    if (op.peek() == '/') val.push(v1 / v2);

                    op.pop();
                }

                op.pop(); // remove '('
            }

            else if (op.isEmpty() || op.peek() == '(') {
                op.push(ch);
            }

            else {

                // + or -
                if (ch == '+' || ch == '-') {

                    while (!op.isEmpty() && op.peek() != '(') {

                        int v2 = val.pop();
                        int v1 = val.pop();

                        if (op.peek() == '+') val.push(v1 + v2);
                        if (op.peek() == '-') val.push(v1 - v2);
                        if (op.peek() == '*') val.push(v1 * v2);
                        if (op.peek() == '/') val.push(v1 / v2);

                        op.pop();
                    }

                    op.push(ch);
                }

                // * or /
                else if (ch == '*' || ch == '/') {

                    while (!op.isEmpty()
                            && op.peek() != '('
                            && (op.peek() == '*' || op.peek() == '/')) {

                        int v2 = val.pop();
                        int v1 = val.pop();

                        if (op.peek() == '*') val.push(v1 * v2);
                        if (op.peek() == '/') val.push(v1 / v2);

                        op.pop();
                    }

                    op.push(ch);
                }
            }
        }

        while (!op.isEmpty()) {

            int v2 = val.pop();
            int v1 = val.pop();

            if (op.peek() == '+') val.push(v1 + v2);
            if (op.peek() == '-') val.push(v1 - v2);
            if (op.peek() == '*') val.push(v1 * v2);
            if (op.peek() == '/') val.push(v1 / v2);

            op.pop();
        }

        System.out.println(val.peek());
    }
}
