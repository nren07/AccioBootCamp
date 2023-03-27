import java.util.*;

class Solution {
    public int setBits(int n) {
        int cnt=0;
		// int k=0;
		// int mask=0;
		// while(mask<n){
		// 	mask=1<<k;
		// 	if((n&mask)>0){
		// 		cnt++;
		// 	}
		// 	k++;
		// }

		
		// TC O(log n)
		// while(n>0){
		// 	if((n&1)==1){
		// 		cnt++;
		// 	}
		// 	n>>=1;
		// }

		
		// Brian Kernighan's algorithm
		// TC O(no of set bits)
		while(n>0){
			if(n>0){
				cnt++;
			}
			n=n&(n-1);
		}
		return cnt;
		
    }
}

public class Main {

    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Solution Obj = new Solution();
        sc.close();
        System.out.println(Obj.setBits(n));
    }
}