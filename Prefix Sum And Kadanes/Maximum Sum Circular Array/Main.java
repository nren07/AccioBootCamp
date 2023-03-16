import java.util.*;

class Solution {
    public int MaxSum(int[] arr, int n) {

		int maxSum=-10000;
		int currMax=maxSum;

		int minSum=10000;
		int currMin=minSum;

		int wholeSum=0;

		for(int i=0;i<n;i++){
			
			wholeSum+=arr[i];
			
			currMax=Math.max(currMax+arr[i], arr[i]);
			maxSum=Math.max(currMax,maxSum);

			currMin=Math.min(currMin+arr[i], arr[i]);
			minSum=Math.min(currMin,minSum);
		}

		if(wholeSum==minSum) return maxSum;
		return Math.max(maxSum,wholeSum-minSum);

    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
	    Solution Obj = new Solution();
        int ans = Obj.MaxSum(arr, n);
        System.out.println(ans);
    }
}