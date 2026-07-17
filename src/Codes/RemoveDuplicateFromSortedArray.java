package Codes;

public class RemoveDuplicateFromSortedArray {
    public static void main(String...args){
        int arr[]={1,2,2,3,4,5,6,6,6,6};

        int size = removeDuplicate(arr);
        for(int i=0;i<size;i++){
            System.out.print(arr[i]+" ");
        }

        System.out.println("\n");

        removeDuplicate(arr,1,1);
        for(int i=0;i<size;i++){
            System.out.print(arr[i]+" ");
        }


    }

    static int removeDuplicate(int[] arr){
        int index=1;

        if(arr.length<=1)   return arr.length;

        for(int i=1;i<arr.length;i++){
            if(arr[i]!=arr[i-1]) arr[index++]=arr[i];
        }
        return index;
    }

    static int removeDuplicate(int[] arr, int i, int index) {

        if (i == arr.length) {
            return index;
        }

        if (arr[i] != arr[i - 1]) {
            arr[index] = arr[i];
            index++;
        }

        return removeDuplicate(arr, i + 1, index);
    }
}
