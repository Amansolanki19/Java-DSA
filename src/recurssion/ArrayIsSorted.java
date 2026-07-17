package recurssion;

import java.util.Scanner;

public class ArrayIsSorted {
    static void main() {
        int arr[]={1,2,3,4,5};
        System.out.print("Array is sorted: "+isSortedAuto(arr,0,0));
    }

    static boolean isSortedAuto(int[] arr, int i, int direction) {
        if (i == arr.length - 1) return true;

        // direction: 0 = unknown, 1 = ascending, -1 = descending
        if (direction == 0) {
            if (arr[i] < arr[i + 1]) direction = 1;
            else if (arr[i] > arr[i + 1]) direction = -1;
        }

        if (direction == 1 && arr[i] > arr[i + 1]) return false;
        if (direction == -1 && arr[i] < arr[i + 1]) return false;

        return isSortedAuto(arr, i + 1, direction);
    }
}
