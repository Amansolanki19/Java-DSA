import javax.annotation.processing.SupportedAnnotationTypes;
import java.util.*;

public class FloorNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[] = {2, 3, 5, 9, 14, 16, 18};

        System.out.print("Enter the Target: ");
        int target = sc.nextInt();

        int result = floorNumber(target, arr);

        if (result == Integer.MIN_VALUE) {
            System.out.println("No floor found");
        } else {
            System.out.println("Floor: " + result);
        }
    }


    static int floorNumber(int target, int[] arr) {
        int low = 0, high = arr.length - 1;
        int ans = Integer.MIN_VALUE;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] <= target) {
                ans = arr[mid];   // possible floor
                low = mid + 1;    // try to find larger valid value
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }
}