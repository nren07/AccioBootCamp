import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        int B = sc.nextInt();
        Solution ob = new Solution();
        System.out.println(ob.search(A, B));

    }
}

class Solution {

    int findMin(int arr[], int low, int high) {
        if (arr[low] <= arr[high])
            return low;
        while (low <= high) {
            int mid = (int) (low + (high - low) * 1.0 / 2);
            if (arr[mid + 1] < arr[mid]) {
                return mid + 1;
            } else if (arr[mid - 1] > arr[mid])
                return mid;
            else if (arr[mid] >= arr[low]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public int binarySearch(int arr[], int start, int end, int target) {
        while (start <= end) {
            int mid = (int) (start + (end - start) * 1.0 / 2);
            if (arr[mid] == target)
                return mid;
            else if (arr[mid] < target)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return -1;
    }

    public int search(int[] arr, int target) {
        int idx = findMin(arr, 0, arr.length - 1);
        int start = 0, end = arr.length - 1;
        if (idx == 0)
            return binarySearch(arr, start, end, target);
        int ans = binarySearch(arr, start, idx - 1, target);
        if (ans == -1) {
            ans = binarySearch(arr, idx, end, target);
            return ans;
        }
        return ans;
    }
}