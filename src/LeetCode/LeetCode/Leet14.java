package LeetCode;

public class Leet14 {
    public static void main(String...args){
        String [] str={"dog","racecar","car"};

        System.out.println(longestCommonPrefix(str));

    }

    public static String longestCommonPrefix(String[] str){

        String result=str[0];

        for(int i=1;i<str.length;i++){
            result = commonPrefix(result,str[i]);
        }
        return result;

    }

    public static String commonPrefix(String s1,String s2){
        StringBuilder sb = new StringBuilder();
        int index=Math.min(s1.length(),s2.length());

        for(int i=0;i<index;i++){
            if(s1.charAt(i)==s2.charAt(i)){
                sb.append(s1.subSequence(i,i+1));
            }
            else{
                break;
            }
        }
        return sb.toString();
    }
}
