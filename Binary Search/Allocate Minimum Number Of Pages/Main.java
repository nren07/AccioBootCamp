import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public boolean isPossibleToPlace(int[] A, int B, long mid) {
        int std = 1;
        long currentMaxPages = 0;
        for (int i = 0; i < A.length; i++) {
            currentMaxPages += A[i];
            if (currentMaxPages > mid) {
                std++;
                currentMaxPages = A[i];
            }
        }
        return std <= B;
    }

    public long MinimumPages(int[] A, int B) {
        if (A.length < B)
            return -1;
        long start = A[0];
        long end = A[0];
        long res = -1;
        for (int i = 1; i < A.length; i++) {
            start = Math.max(start, A[i]);
            end += A[i];
        }

        while (start <= end) {

            long mid = (start + end) / 2;

            if (isPossibleToPlace(A, B, mid) == true) {
                res = mid;
                end = mid - 1;
            } else
                start = mid + 1;
        }
        return res;

    }
}

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int B = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++)
            A[i] = sc.nextInt();

        Solution Obj = new Solution();
        System.out.println(Obj.MinimumPages(A, B));
    }
}