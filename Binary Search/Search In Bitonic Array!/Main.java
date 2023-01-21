
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int arr[] = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = sc.nextInt();

        int target = sc.nextInt();

        Accio ob = new Accio();
        int ans = ob.findElement(arr, N, target);

        System.out.println(ans);

    }
}

class Accio {
    public static int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        int start = 0, end = n - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (mid < n && mid > 0 && arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1]) {
                return mid;
            } else if (mid < n && mid > 0 && arr[mid] > arr[mid - 1])
                start = mid + 1;
            else
                end = mid - 1;
        }
        return -1;
    }

    public static Integer binarySearchIncreasing(int arr[], int start, int end, int target) {
        while (start <= end) {
            int mid = (int) (start + (end - start) * 1.0 / 2);
            if (arr[mid] == target)
                return mid;
            else if (arr[mid] < target)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return null;
    }

    public static int binarySearchDecreasing(int arr[], int start, int end, int target) {
        while (start <= end) {
            int mid = (int) (start + (end - start) * 1.0 / 2);
            if (arr[mid] == target)
                return mid;
            else if (arr[mid] < target)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return -1;
    }

    static int findElement(int arr[], int n, int target) {
        int idx = peakIndexInMountainArray(arr);
        Integer ans = binarySearchIncreasing(arr, 0, idx, target);
        if (ans == null) {
            ans = binarySearchDecreasing(arr, idx + 1, n - 1, target);
        }
        return ans;
    }
}