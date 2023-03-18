import java.util.Scanner;

class Solution{
    static int findLengthOfSmallestSubarray(int[] a, int k) {
        int st=0;
		int end=0;
		int n=a.length;
		int sum=0;

		int ans=Integer.MAX_VALUE;

		while(end<n){
			
			sum+=a[end];
			while(sum>=k){
                if(sum>=k) ans=Math.min(ans,end-st+1);
				sum-=a[st];
                st++;
			}
            end++;
		}
		return ans==Integer.MAX_VALUE ? 0 : ans;
    }
}
public class Main{ 
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int n = keyboard.nextInt();
		int K = keyboard.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = keyboard.nextInt();
        }
        keyboard.close();
        System.out.println(Solution.findLengthOfSmallestSubarray(a, K));
    }
}