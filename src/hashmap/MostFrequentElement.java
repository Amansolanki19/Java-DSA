package hashmap;

import java.util.HashMap;
import java.util.Map;

public class MostFrequentElement {
    public static void main(String...args){
        int arr[]={1,2,3,4,3,2,1,4,5,3,6,5,7,5,85,2,6,8,6,4,4,6,7,8,9,6,4,3,};
        int []result = new MostFrequentElement().mostFrequentElement(arr);
        System.out.printf("Key %d\nValue %d",result[1],result[0]);
    }
    public int[] mostFrequentElement(int[] arr){
        Map<Integer,Integer> map=new HashMap<>();
        for(int a:arr){
            if(!map.containsKey(a)){
                map.put(a,1);
                continue;
            }
            map.put(a,map.get(a)+1);
        }

        System.out.println(map.entrySet());

        int maxFreq=0,ansKey=-1;
        for(var a:map.entrySet()){
            if(a.getValue()>maxFreq){
                maxFreq=a.getValue();
                ansKey=a.getKey();
            }
        }
        return new int[] {maxFreq,ansKey};
    }
}
