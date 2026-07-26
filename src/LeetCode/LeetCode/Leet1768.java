package LeetCode;

public class Leet1768 {
    public static void main(String...args){
        String s1="abc";
        String s2="pqr";

        System.out.println(alternateString(s1,s2));
    }

    public static String alternateString(String s1,String s2){
        StringBuilder sb = new StringBuilder();
        int i=0,j=0;

        while(i<s1.length() || j<s2.length()){
            if(i<s1.length())   sb.append(s1.charAt(i++));

            if (j<s1.length())  sb.append(s2.charAt(j++));
        }

        return sb.toString();
    }
}
