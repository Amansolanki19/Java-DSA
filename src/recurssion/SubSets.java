package recurssion;

import java.util.ArrayList;

public class SubSets {
    static void main() {

        String str="abc";
        subSets(str,"");

        System.out.println();

        System.out.println(subSets2("abcd",""));

    }
    static void subSets(String str, String subStr){
        if(str.isEmpty()){
            System.out.print(subStr+" ");
            return ;
        }

        char c=str.charAt(0);

         subSets(str.substring(1),subStr+c);
         subSets(str.substring(1),subStr);
    }

    static ArrayList<String> subSets2(String str, String subStr){
        if(str.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(subStr);
            return list;
        }

        char c = str.charAt(0);

        ArrayList<String> leftList = subSets2(str.substring(1), subStr + c);

        ArrayList<String> rightList = subSets2(str.substring(1), subStr);

        leftList.addAll(rightList);

        return leftList;
    }
}
