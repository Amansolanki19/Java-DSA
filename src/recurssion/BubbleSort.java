package recurssion;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int arr[] = {243, 54, 23, 5, 43};
        bubbleSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    static void bubbleSort(int arr[], int i, int j){
        if(j == 0) return;

        if(i < j){
            if(arr[i] > arr[i + 1]){
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
            bubbleSort(arr, i + 1, j);
        } else {
            // reset i to 0, reduce j
            bubbleSort(arr, 0, j - 1);
        }
    }
}