package Stack.Next Greater Element;

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
    public static long[] nextLargerElement(long[] arr, int n)
    { 
        long ans[]=new long[n];
		Stack<Integer>st=new Stack<>();
		for(int i=0;i<n;i++){
			while(st.size()>0 && arr[i]>arr[st.peek()]){
				ans[st.peek()]=arr[i];
				st.pop();
			}
			st.push(i);
		}
		while(st.size()>0){
			ans[st.peek()]=-1;
			st.pop();
		}
		return ans;
    } 
}
class Main {
    public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		    int n = Integer.parseInt(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    long[] res = new Solution().nextLargerElement(arr, n);
		    for (int i = 0; i < n; i++) 
		        System.out.print(res[i] + " ");
		    System.out.println();
	}
}
