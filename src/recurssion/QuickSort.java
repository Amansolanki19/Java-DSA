package recurssion;

import java.util.Arrays;
import java.util.Scanner;

public class QuickSort {
    static void main() {
        int arr[]={34,45,12,365,78,2};
        System.out.println("Start");
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    static void quickSort(int[] arr, int low, int high) {
        int start=low;
        int end=high;
        if(start>=end) return;

        int pivot=arr[start+(end-start)/2];


        while(start<=end) {
            while(arr[start]<pivot) {
                start++;
            }
            while(arr[end]>pivot) {
                end--;
            }
            if(start<=end) {
                int temp=arr[start];
                arr[start]=arr[end];
                arr[end]=temp;
                start++;
                end--;
            }
        }
        quickSort(arr, low, end);
        quickSort(arr, start, high);


    }
}
