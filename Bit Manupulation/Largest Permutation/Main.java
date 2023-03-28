import java.util.*;
import java.lang.*;
import java.io.*;

class Solution{
    public static int[] largestPermutation(int[] arr, int b) {
        int n=arr.length;
		int index[]=new int[n+1];
		for(int i=0;i<n;i++) index[arr[i]]=i;

		int i=0;
		while(i<n && b>0){
			int idealVal=n-i;
			if(idealVal==arr[i]) {
				i++;
				continue;
			}
			b--;
			int idealIdx=index[idealVal];
			// swapping in original array
			int currVal=arr[i];
			arr[i]=idealVal;
			arr[idealIdx]=currVal;
			// swapping in index array also 
			index[currVal]=idealIdx;
			index[idealVal]=i;
			i++;
		}
        return arr;
    }
}

public class Main {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] A = new int[n];
        for(int i=0;i<n;i++)
            A[i] = sc.nextInt();

        int b =sc.nextInt();
        Solution obj= new Solution();
        int [] ans = obj.largestPermutation(A, b);

        for(int i=0;i<n;i++)
            System.out.print(ans[i]+" ");
    }
}