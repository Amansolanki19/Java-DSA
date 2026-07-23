package LeetCode;

import java.util.Stack;

public class Leet1081 {
    public static void main(String...args){
        String str="cbacdcbc";
        System.out.println(smallestSubsequence(str));
    }
    public static String smallestSubsequence(String str){
        byte arr[]=new byte[26];
        boolean visited[]=new boolean[26];

        for(char c:str.toCharArray()){
            int index=c-'a';
            arr[index]++;
        }

        Stack<Character> st = new Stack<>();

        for(char c:str.toCharArray()){
            int index=c-'a';
            arr[index]--;
            if(visited[index]){
                continue;
            }
            while (!st.empty()
                    && st.peek()>0
                    && arr[st.peek()-'a']>0){
                visited[st.pop()-'a']=false;
            }
            st.push(c);
            visited[index]=true;
        }

        StringBuilder sb = new StringBuilder();
        for(char c:st){
            sb.append(c);
        }

        return sb.toString();

    }
}
