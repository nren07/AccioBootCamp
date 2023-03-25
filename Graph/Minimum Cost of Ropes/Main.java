import java.math.*;
import java.util.*;
import java.io.*;

class Solution
{
    long minCost(long arr[], int n) 
    {
        PriorityQueue<Long>minpq=new PriorityQueue<>();
		// PriorityQueue<Long>maxpq=new PriorityQueue<>(Collections.reverseOrder);
		long sum=0;
		for(int i=0;i<n;i++){
			minpq.add(arr[i]);
		}
		while(minpq.size()>1){
			long temp=minpq.remove()+minpq.remove();
			sum+=temp;
			minpq.add(temp);
		}
		
		return sum;
    }
}

class Main
{
    static class FastReader{ 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader(){ 
            br = new BufferedReader(new InputStreamReader(System.in)); 
        } 
  
        String next(){ 
            while (st == null || !st.hasMoreElements()){ 
                try{ st = new StringTokenizer(br.readLine()); } catch (IOException  e){ e.printStackTrace(); } 
            } 
            return st.nextToken(); 
        } 
  
        String nextLine(){ 
            String str = ""; 
            try{ str = br.readLine(); } catch (IOException e) { e.printStackTrace(); } 
            return str; 
        } 

        Integer nextInt(){
            return Integer.parseInt(next());
        }
        
        Long nextLong(){
            return Long.parseLong(next());
        }
    }
    
	public static void main(String args[])
	{
		FastReader sc = new FastReader();
		PrintWriter out = new PrintWriter(System.out);
			int n = sc.nextInt();
			long arr[] = new long[n];
			
			for(int i=0; i<n; i++)
				arr[i] = sc.nextLong();
		    out.println(new Solution().minCost(arr, n));
		out.flush();
	}
}