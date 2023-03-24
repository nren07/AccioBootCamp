import java.util.*;
import java.lang.*; 
import java.io.* ;
class Solution{
    public static void kSmallLarge( int arr [], int n, int k){
		PriorityQueue<Integer>minpq=new PriorityQueue<>();
		PriorityQueue<Integer>maxpq=new PriorityQueue<>(Collections.reverseOrder());
		for(int i=0;i<n;i++){
			minpq.add(arr[i]);
			maxpq.add(arr[i]);
			if(minpq.size()>k) minpq.remove();
			if(maxpq.size()>k) maxpq.remove();
		}
		int kthsmall=maxpq.peek();
		int kthLargest=minpq.peek();
		System.out.println(kthsmall);
		System.out.println(kthLargest);
    }
}
public class Main{
   public static void main(String args[]){
      
      int n;
      Scanner sc = new Scanner(System.in);
      n = sc.nextInt();
      int arr[]=new int[n]; 
      for(int i=0; i<n; i++){
         arr[i]=sc.nextInt();
      }

      int k; 
      k=sc.nextInt(); 

      Solution obj= new Solution();
      obj.kSmallLarge(arr,n, k);


   }
}