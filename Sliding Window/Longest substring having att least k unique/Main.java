import java.util.*;

class Solution {
	public int solve(String s, int x, int k){
		int sp=0;
		int end=0;
		int ans=0;
		int n=s.length();
		
		int freq[]=new int[26];

		int unique=0;
		int uniAtLstK=0;

		while(end<n){
			// introduce new character
			freq[s.charAt(end)-'a']++;
			// update unique and uniqueK 
			if(freq[s.charAt(end)-'a']==1) unique++;
			if(freq[s.charAt(end)-'a']==k) uniAtLstK++;
			
			// if new character make widow invalid then make is valid
			
			while(unique>x){
				freq[s.charAt(sp)-'a']--;

				if(freq[s.charAt(sp)-'a']==0) unique--;
				if(freq[s.charAt(sp)-'a']==k-1) uniAtLstK--;
				
				sp++;

			}
			if(unique==x && uniAtLstK==x) ans=Math.max(ans,end-sp+1);
			end++;
		}
		return ans;
	}
    public int longestSubstring(String s, int k) {
		int ans=0;
		for(int i=1;i<=26;i++){
			ans=Math.max(ans,solve(s,i,k));
		}
		return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int k = scn.nextInt();
        Solution Obj =  new Solution();
        System.out.println(Obj.longestSubstring(str,k));
    }
}
