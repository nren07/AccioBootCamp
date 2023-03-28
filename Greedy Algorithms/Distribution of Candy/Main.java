import java.io.*;
import java.util.*;

class Main {
	public static void main (String[] args) {
	    Scanner sc=new Scanner(System.in);
	   
        int n=sc.nextInt(); 
        ArrayList<Integer> arr= new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            int x=sc.nextInt();
            arr.add(x);
        }
        
        Solution ob=new Solution();
        System.out.println(ob.candies(arr,n));
        
	}
}


class Solution {
    public int candies(ArrayList<Integer> A,int n) {
        //Write code here
        int []left=new int[n];
        int []right=new int[n];
        Arrays.fill(left,1);
        Arrays.fill(right,1);
        for(int i=1;i<n;i++){
            if(A.get(i-1)<A.get(i)) left[i]=left[i-1]++;
            // else left[i]=1;
        }
        for(int i=n-2;i>=0;i--){
            if(A.get(i+1)<A.get(i)) right[i]=right[i+1]++;
            // else right[i]=1;
        }
        int ans=0;
        for(int i=0;i<n;i++){
            ans+=Math.max(left[i],right[i]);   
        }
        return ans;
	
    }
}
