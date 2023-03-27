import java.util.*;

class Solution {

    public int[] singleNumber3(int n, int[] nums) {
	    // do xor of all element then we get two single valued xor like a^b
		int xorOfAll=0;
		for(int i : nums){
			xorOfAll^=i;
		}
		// now we have to find  right most set position in a^b
		int k=0;
		while((xorOfAll & 1)==0) { //whenever 1 comes loop is over and we got kth position
			k++;
			xorOfAll>>=1; //shifting right with one
		}
		// now we get k 
		// we make two group one is kth position set
		// another one is th position unset
		int kthSet=0;
		int kthUnset=0;
		
		for( int x : nums){
			if((x&(1<<k))>0){
				kthSet^=x;
			}else kthUnset^=x;
		}
		int ans[]=new int[2];
		ans[0]=kthSet;
		ans[1]=kthUnset;
		Arrays.sort(ans);
		return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        Solution Obj = new Solution();
        scn.close();
        int[] ans = Obj.singleNumber3(n, arr);
        System.out.print(ans[0] + " " + ans[1]);
    }
}