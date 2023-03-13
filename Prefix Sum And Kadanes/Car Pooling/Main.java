
 import java.util.*;
import java.lang.*;
import java.io.*;
public class Main {
	   public static void main(String args[]) {
		  
		        Scanner sc = new Scanner(System.in);
		        int n = sc.nextInt();
		        int[][] trips = new int[n][3];
		        for (int i = 0; i < n; i++) {
		            for (int j = 0; j < 3; j++) {
		                trips[i][j] = sc.nextInt();
		            }
		        }
		        int k = sc.nextInt();
	           
	        Solution obj= new Solution();
	        System.out.println(obj.carPooling(trips,k));
	    }
}
class Solution{
  
    public boolean carPooling(int[][] trips, int capacity) {
		int lastDropLoc=-1;
		
		// for( int i=0;i<trips.length;i++){
		// 	lastDropLoc=Math.max(lastDropLoc,trip[i][2]);
		// }
		
		for (int trip []: trips){
			lastDropLoc=Math.max(lastDropLoc,trip[2]);
		}

		int prefix[]=new int[lastDropLoc+1];

		for(int trip[]: trips){
			
			int st=trip[1];
			int end=trip[2];
			// prefix array filled at starting point location by no of passenge
			// prefix array filled at ending position by no of passenger with negative sign
			prefix[st]+=trip[0];
			prefix[end]-=trip[0];
			
		}
		// prefix array convert into prefix sum array
		for(int i=1;i<=lastDropLoc;i++){
			prefix[i]+=prefix[i-1];
			// whenever we get a position greater then given capacity then return false;
			if(prefix[i]>capacity){
				return false;
			}
		}
		return true;
	}
}










