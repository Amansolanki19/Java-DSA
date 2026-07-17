package recurssion;

import java.util.Arrays;

class MergeSortRecursive {

    public static void main(String[] args) {
        int[] arr = {64, 25, 12,99, 22, 11};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    static void mergeSort(int[] arr, int start, int end) {
        if (start >= end) return;

        int mid = start + (end - start) / 2;

        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);

        merge(arr, start, mid, end);
    }

    static void merge(int[] arr, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        mergeHelper(arr, start, mid, mid + 1, end, temp, 0);

        copyBack(arr, temp, start, 0);
    }

    static void mergeHelper(int[] arr, int i, int mid, int j, int end, int[] temp, int k) {
        if (i > mid && j > end) return;

        if (i > mid) {
            temp[k] = arr[j];
            mergeHelper(arr, i, mid, j + 1, end, temp, k + 1);
        }
        else if (j > end) {
            temp[k] = arr[i];
            mergeHelper(arr, i + 1, mid, j, end, temp, k + 1);
        }
        else if (arr[i] <= arr[j]) {
            temp[k] = arr[i];
            mergeHelper(arr, i + 1, mid, j, end, temp, k + 1);
        }
        else {
            temp[k] = arr[j];
            mergeHelper(arr, i, mid, j + 1, end, temp, k + 1);
        }
    }

    static void copyBack(int[] arr, int[] temp, int start, int k) {
        if (k == temp.length) return;

        arr[start + k] = temp[k];
        copyBack(arr, temp, start, k + 1);
    }
}
