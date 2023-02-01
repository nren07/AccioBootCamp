package Binary Search.Aggresive Cows;

import java.io.*;
import java.util.*;
import java.util.*;

class Solution {

    public static boolean isPossible(int[] a, int capacity, int mid) {
        int cows = 1;
        int lastPosition = a[0];
        for (int i = 0; i < a.length; i++) {
            if (a[i] - lastPosition >= mid) {
                lastPosition = a[i];
                cows++;
            }
        }
        return cows >= capacity;
    }

    public static int aggressiveCows(int a[], int cows) {

        int start = 1;
        int end = a[a.length - 1] - a[0];
        int ans = 0;

        while (start <= end) {
            int mid = (start + end);
            if (isPossible(a, cows, mid)) {
                ans = mid;
                start = mid + 1;
            } else
                end = mid - 1;
        }
        return ans;
    }

}

class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        Solution obj = new Solution();
        System.out.println(obj.aggressiveCows(nums, k));

    }
}
