package stack;

import java.util.Stack;

public class RemoveToMakeValidParentheses {

    static void main() {
        String str = "((()) {[{{([])}]})";

        System.out.println(new RemoveToMakeValidParentheses().validBrackets(str));
    }

    int validBrackets(String s){
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                st.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                char top = st.pop();
                if ((c == ')' && top != '(') ||
                        (c == '}' && top != '{') ||
                        (c == ']' && top != '[')) {
                }
            }
        }
        return st.size();
    }
}
