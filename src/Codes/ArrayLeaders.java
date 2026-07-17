package Codes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ArrayLeaders {

    static int maxRight;
    public static void main(String...args){
        maxRight = Integer.MIN_VALUE;
        int arr[] = {16, 17, 4, 3, 5, 2};
        ArrayList<Integer> list = new ArrayList<>();
        findLeaders(arr,0,list);

        Collections.reverse(list);
        System.out.println(list.toString());

        System.out.println(findLeader(arr).toString());

    }

    static ArrayList<Integer> findLeader(int arr[]){
        ArrayList<Integer> list = new ArrayList<>();

        list.add(arr[arr.length-1]);
        maxRight=arr[arr.length-1];

        for(int i=arr.length-2 ; i>=0 ; i--){
            if(arr[i]>maxRight){
                list.add(arr[i]);
                maxRight=arr[i];
            }
        }
        Collections.reverse(list);
        return list;
    }

    static void findLeaders(int[] arr, int index, ArrayList<Integer> list) {

        if (index == arr.length) {
            return;
        }

        findLeaders(arr, index + 1, list);

        if (arr[index] >= maxRight) {
            list.add(arr[index]);
            maxRight = arr[index];
        }
    }
}
