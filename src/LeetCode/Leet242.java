package LeetCode;

public class Leet242 {
    public static void main(String...args){
        String s1="";
        String s2="";
        System.out.println(isValidAnagram(s1,s2));
    }
    public static boolean isValidAnagram(String s,String t){

        if(s.length()!=t.length())  return false;

        int[] freq = new int[26];

        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }

        for (int count : freq) {
            if (count != 0)
                return false;
        }

        return true;
    }
}
