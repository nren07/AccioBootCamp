import java.util.*;

class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int a[] = new int[n];
        for(int i=0;i<n;i++){
            a[i] = input.nextInt();
        }
        Solution ob =new Solution();
        long ans = ob.maxSubarraySum(a,n);
        System.out.println(ans);
    }
}
class Solution{
    public long maxSubarraySum(int a[],int n){
        long currSum=Integer.MIN_VALUE;
		long maxSum=Integer.MIN_VALUE;
		for(int i=0;i<n;i++){
			currSum=Math.max(currSum+a[i],a[i]);
			maxSum=Math.max(maxSum,currSum);
		}
		return maxSum;
    }
}