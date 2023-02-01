import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            Solution s = new Solution();
            System.out.println(s.twoEqualSubsets(arr));
        }
        
    }
}

class Solution {
	// A utility function that returns true if there is a
    // subset of arr[] with sum equal to given sum
    static boolean isSubsetSum(int arr[], int n, int sum)
    {
        // Base Cases
        if (sum == 0)
            return true;
        if (n == 0 && sum != 0)
            return false;
 
        // If last element is greater than sum, then ignore
        // it
        if (arr[n - 1] > sum)
            return isSubsetSum(arr, n - 1, sum);
 
        /* else, check if sum can be obtained by any of
           the following
        (a) including the last element
        (b) excluding the last element
        */
        return isSubsetSum(arr, n - 1, sum)
            || isSubsetSum(arr, n - 1, sum - arr[n - 1]);
    }
 
    // Returns true if arr[] can be partitioned in two
    // subsets of equal sum, otherwise false
    static String twoEqualSubsets(int[] arr)
    {
        // Calculate sum of the elements in array
		int n=arr.length;
        int sum = 0;
        for (int i = 0; i < n; i++)
            sum += arr[i];
 
        // If sum is odd, there cannot be two subsets
        // with equal sum
        if (sum % 2 != 0)
            return "false";
 
        // Find if there is subset with sum equal to half
        // of total sum
        boolean ans=isSubsetSum(arr, n, sum / 2);
		if(ans==true){
			return "true";
		}
		return "false";
    }
}