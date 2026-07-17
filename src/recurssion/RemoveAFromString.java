package recurssion;

public class RemoveAFromString {
    static void main() {

        System.out.println(removeAFromString("aabacaada",""));


        System.out.println(skipString("name","","am"));

    }
    public static String removeAFromString(String s,String str) {
        if(s.isEmpty()) {
            return str;
        }
        char c=s.charAt(0);
        if(c=='a' || c=='A'){
            return removeAFromString(s.substring(1),str);
        }else{
            return removeAFromString(s.substring(1),str+c);
        }
    }

    static String skipString(String s,String str, String skip){
        if(s.isEmpty()){
            return str;
        }

        if(s.startsWith(skip)){
            return skipString(s.substring(skip.length()),str,skip);
        }else{
            return skipString(s.substring(1),str+s.substring(0,1),skip);
        }
    }
}
