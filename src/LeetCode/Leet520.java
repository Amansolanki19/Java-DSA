package LeetCode;

public class Leet520 {
    public static void main(String...args){

    }

    public static boolean detectCapital(String word){
        int upperCaseCount=0;

        for(int i=0;i<word.length();i++){
            if(Character.isUpperCase(word.charAt(i)))   upperCaseCount++;
        }

        boolean isFirstCapital=Character.isUpperCase(word.charAt(0));

        return upperCaseCount == 0
                || upperCaseCount == word.length()
                || (upperCaseCount == 1 && isFirstCapital);
    }
}
