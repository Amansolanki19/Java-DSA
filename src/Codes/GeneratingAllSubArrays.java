package Codes;

import java.util.*;

class GeneratingAllSubArrays {

    public static void main(String... args) {

        int arr[] = {1, 2, 3};

        GeneratingAllSubArrays obj = new GeneratingAllSubArrays();

        List<List<Integer>> result = obj.getSubArrays(arr);

        for (List<Integer> subArray : result) {
            System.out.println(subArray);
        }
    }

    public List<List<Integer>> getSubArrays(int[] arr) {

        List<List<Integer>> result = new ArrayList<>();

        generate(arr, 0, 0, result);

        return result;
    }

    private void generate(int[] arr, int start, int end, List<List<Integer>> result) {

        if (start == arr.length)
            return;

        if (end == arr.length) {
            generate(arr, start + 1, start + 1, result);
            return;
        }

        List<Integer> subArray = new ArrayList<>();
        buildSubArray(arr, start, end, subArray);

        result.add(subArray);

        generate(arr, start, end + 1, result);
    }

    private void buildSubArray(int[] arr, int index, int end, List<Integer> subArray) {

        if (index > end)
            return;

        subArray.add(arr[index]);

        buildSubArray(arr, index + 1, end, subArray);
    }
}