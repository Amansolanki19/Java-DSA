package recurssion;

import java.util.ArrayList;

public class Permutations {

    public static void main(String[] args) {
        permutations("abc", "");

        System.out.println(permutation("abc", ""));
    }

    static void permutations(String str, String s) {
        if (str.isEmpty()) {
            System.out.println(s);
            return;
        }

        char ch = str.charAt(0);

        for (int i = 0; i <= s.length(); i++) {
            String first = s.substring(0, i);
            String second = s.substring(i);

            permutations(str.substring(1), first + ch + second);
        }
    }

    static ArrayList<String> permutation(String str, String s) {
        ArrayList<String> list=new ArrayList<>();
        if(str.isEmpty()){
            list.add(s);
            return list;
        }

        char ch=str.charAt(0);

        for(int i=0;i<s.length();i++){
            String first = s.substring(0, i);
            String second = s.substring(i);
            list.addAll(permutation(str.substring(1), first + ch + second));
        }
        return list;
    }

}