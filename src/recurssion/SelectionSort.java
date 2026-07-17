package recurssion;

class SelectionSort {

    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};
        selectionSort(arr, arr.length, 0);

        System.out.println(java.util.Arrays.toString(arr));
    }

    static void selectionSort(int[] arr, int n, int index) {
        // base case
        if (index == n) return;

        // find index of minimum element
        int minIndex = index;
        for (int i = index + 1; i < n; i++) {
            if (arr[i] < arr[minIndex]) {
                minIndex = i;
            }
        }

        // swap
        int temp = arr[index];
        arr[index] = arr[minIndex];
        arr[minIndex] = temp;

        // recursive call for next position
        selectionSort(arr, n, index + 1);
    }

    static void selectionSort(int[] arr, int i, int j, int minIndex) {
        // base case: all sorted
        if (i == arr.length) return;

        // inner loop simulation
        if (j < arr.length) {
            if (arr[j] < arr[minIndex]) {
                minIndex = j;
            }
            selectionSort(arr, i, j + 1, minIndex);
        }
        else {
            // swap after inner loop
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;

            // move to next index
            selectionSort(arr, i + 1, i + 1, i + 1); 
        }
    }
}
