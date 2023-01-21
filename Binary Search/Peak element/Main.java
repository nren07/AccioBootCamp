import java.util.*;

class Solution {
    public int findPeak(int arr[], int n) {

        if (n == 1)
            return 0;

        int start = 0, end = n - 1;

        while (start <= end) {

            int mid = (start + end) / 2;

            if (mid == 0) {
                if (arr[mid] > arr[mid + 1])
                    return mid;
                else
                    start = mid + 1;
            } else if (mid == n - 1) {
                if (arr[mid] > arr[mid - 1])
                    return mid;
                else
                    end = mid - 1;
            } else {
                if (arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1])
                    return mid;
                else if (arr[mid] < arr[mid + 1])
                    start = mid + 1;
                else
                    end = mid - 1;
            }
        }
        return -1;
    }
}

class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t > 0) {
                int n = sc.nextInt();
                int[] A = new int[n];
                for (int i = 0; i < n; i++) {
                    A[i] = sc.nextInt();
                }
                Solution ob = new Solution();
                int ans = ob.findPeak(A, n);
                if (ans == -1)
                    System.out.println("false");
                else if (ans == 0) {
                    if (A[ans] > A[ans + 1]) {
                        System.out.println("true");
                    } else {
                        System.out.println("false");
                    }
                } else if (ans == n - 1) {
                    if (A[ans] > A[ans - 1]) {
                        System.out.println("true");
                    } else {
                        System.out.println("false");
                    }
                } else {
                    if (A[ans] > A[ans + 1] && A[ans] > A[ans - 1]) {
                        System.out.println("true");
                    } else {
                        System.out.println("false");
                    }
                }
                t--;
            }
        }
    }
}