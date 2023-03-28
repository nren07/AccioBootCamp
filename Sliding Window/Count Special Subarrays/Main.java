// https://course.acciojob.com/idle?question=e134e218-2ac2-48b1-84f4-be50093c5fe7
/*
A special number of an array is defined as the product of its length and its sum.

For example, the special number of [1, 2, 3, 4, 5] is (1 + 2 + 3 + 4 + 5) * 5 = 75

Given a positive integer array nums and an integer k, return the number of non-empty subarrays of nums whose special number is strictly less than k.

A subarray is a contiguous sequence of elements within an array.

Input Format
The first line contains two integers n representing number of elements in the array.

The second line contains n space seperated integers.

Third line contain k

Output Format
Return the number of non-empty subarrays of nums whose special number is strictly less than k.

Example 1
Input

5
2 1 4 3 5
10
Output

6

*/

import java.util.*;
 
class Solution
{
   public static long countSubarrays(int[] nums, long k) {
	   long ans=0;
	   int st=0;
	   int end=0;
	   long sum=0;
	   while(end<nums.length){

		   sum+=nums[end];
		   while(sum*(end-st+1)>=k){
			   sum-=nums[st];
			   st++;
		   }
		   ans+=end-st+1;
		   end++;
	   }
	   return ans;
	}
}
 
public class Main{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n, k;
        n = sc.nextInt();
        int arr1[] = new int[n];
        for(int i=0;i<n;i++)
            arr1[i] = sc.nextInt();
        k = sc.nextInt();
        System.out.println(Solution.countSubarrays(arr1,k));
    }
}