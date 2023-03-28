import java.util.*;
import java.lang.*;
import java.io.*;

class Solution{
	public static boolean isSet(long n,long i){
		return ((n&(1L<<i)))>0;
	}
    public static int singleNumber(int[] nums) {
		// sum of bit is a freq array of counting bit at perticualer idx
		int sumOfbit[]=new int[32];
		for(int i=0;i<32;i++){
			for(int x : nums){
				// check wheather ith bit set or not
				//if set increase freq at that perticualr idx
				if(isSet(x,i)) sumOfbit[i]++;
			}
		}
		int ans=0;
		int powOf2=1;

		for(int i=0;i<32;i++){
			// 2 2 3 2 is a example and freq bit in all 2 are divisible by 3 
			// freq of 3 remain in this ans so we multiply freq of 3 bit at every idx by multiplying 2 the power i
			if((sumOfbit[i]%3 )>0) ans+=powOf2;
			// power of 1<<i times gives power of 2 at that perticualr idx
			powOf2<<=1;
		}
		return ans;
}
}
public class Main {
  public static void main (String[] args)
	{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(Solution.singleNumber(nums));
	}
}
