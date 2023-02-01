import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int target = sc.nextInt();

        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        Solution obj = new Solution();
        obj.searchInArray(arr, target);
    }
}

class Solution {
    public void searchInArray(int[][] arr, int target) {

        int row = arr.length;
        int col = arr[0].length;

        int start = 0;
        int end = row * col - 1;

        while (start <= end) {

            int mid = (start + end) / 2;
            // new row -->mid/global coloumn & new coloumn--> mid%global coloumn
            int rc = mid / col;
            int cc = mid % col;
            // if target found at mid then return true
            if (arr[rc][cc] == target) {
                System.out.println("TRUE");
                return;
            }
            // if target is larger than mid then searchh in right array
            else if (arr[rc][cc] < target)
                start = mid + 1;
            // if target is lesser than mid then search in left array
            else if (arr[rc][cc] > target)
                end = mid - 1;

        }
        // if element not found in array then return false
        System.out.println("FALSE");
        return;
    }
}