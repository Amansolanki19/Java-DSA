package recurssion;

import java.util.ArrayList;
import java.util.Scanner;

public class LinearSearch {
    static ArrayList<Integer> list=new ArrayList<>();
    static void main() {
        Scanner sc = new Scanner(System.in);
        int arr[]={1,2,3,4,4,4,5,6};
        System.out.print("Enter the Number: ");
        int n = sc.nextInt();

        System.out.println("Element "+n+" found at index: "+linearSearch(arr,n,0));

        linearSearchAll(arr,n,0);
        System.out.println("Element "+n+" found at index: "+list );

        System.out.println("Element "+n+" found at index: "+linearSearchArrayList(arr,n,0,new ArrayList<>()));

        System.out.println("Element "+n+" found at index: "+linearSearch(0,arr,n));

    }


    // Finding the target element index
    static int linearSearch(int arr[],int target,int index){
        if(index==arr.length) return -1;

        if(arr[index]== target) return index+1;

        return linearSearch(arr,target,index+1);
    }

    // Finding all the target element index using ArrayList return type
    static ArrayList<Integer> linearSearchArrayList(int arr[],int target,int index, ArrayList<Integer> list){
        if(index==arr.length) return list;

        if(arr[index]== target) {
            list.add(index);
        }

        return linearSearchArrayList(arr,target,index+1,list);
    }

    // Finding all the target element index using void return type
    static void linearSearchAll(int[] arr, int target, int index){
        if(index==arr.length) return ;

        if(arr[index]==target) { list.add(index);}

        linearSearchAll(arr,target,index+1);
    }

    // Finding all without passing ArrayList in the parameter
    static ArrayList<Integer> linearSearch( int index,int[] arr,int target){
        ArrayList<Integer> list=new ArrayList<>();

        if(arr.length==index) return list;

        if(arr[index]==target){
            list.add(index);
        }

        ArrayList<Integer> answerOfOtherCalls = linearSearch(index+1,arr,target);

        list.addAll(answerOfOtherCalls);

        return list;
    }
}
