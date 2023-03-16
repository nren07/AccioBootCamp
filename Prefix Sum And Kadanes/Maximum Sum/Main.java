/*
You are given an array A of N integers. You are also given another array ops describing operations where ops[i] = (l, r). l and r are 0-indexed. For every pair in ops calculate the sum of A[l] + A[l+1] +...+ A[r-1] + A[r].

Your score is the sum of all the answers from ops. You have to find the maximum score possible, if you can arrange the array A in any order.

The answer can be very large, so return it modulo 1000000007.

Note Complete the given function. The input and output would be handled by the driver code

*/



import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int mod=(int)Math.pow(10,9)+7;
    public static int maximumSum(int[] A, int[][] ops) {
	    // create pref array
		int pref[]=new int[A.length];
		// according to query insert value in pref
		for(int op[] : ops){
			int st=op[0];
			int end=op[1];
			pref[st]++;
			if(end+1<A.length){
				pref[end+1]--;
			}
		}
		// prefix Sum of pref array give frequency of element 
		for(int i=1;i<pref.length;i++){
			pref[i]+=pref[i-1];
		}
		// sort pref array or given array and multiply both elemenet
		Arrays.sort(pref);
		Arrays.sort(A);
		int sum=0;
		for(int i=0;i<A.length;i++){
			sum=(sum+(pref[i]*A[i])%1000000007)%1000000007;
		}
		sum=sum%mod;
		return sum;
    }
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
        long n = Long.parseLong(br.readLine().trim());
        String inputLine[] = br.readLine().trim().split(" ");
        int[] arr = new int[(int)n];
        for(int i=0; i<n; i++)arr[i]=Integer.parseInt(inputLine[i]);
        long m = Long.parseLong(br.readLine().trim());
        int[][] ops = new int[(int)m][2];
        for(int i=0; i<m; i++){
          String inputLine1[] = br.readLine().trim().split(" ");
          ops[i][0]=Integer.parseInt(inputLine1[0]);
          ops[i][1]=Integer.parseInt(inputLine1[1]);
        }
        System.out.println(maximumSum(arr, ops));
	}
}



