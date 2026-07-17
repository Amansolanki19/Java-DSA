import java.util.*;

public class CeilingNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[] = {2, 3, 5, 9, 14, 16, 18};

        System.out.print("Enter the Target Element: ");
        int target = sc.nextInt();

        int result = ceilingNumber(target, arr);

        if (result == -1) {
            System.out.println("No ceiling found");
        } else {
            System.out.println("Ceiling: " + result);
        }
    }

    static int ceilingNumber(int target, int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] >= target) {
                ans = arr[mid];
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
}