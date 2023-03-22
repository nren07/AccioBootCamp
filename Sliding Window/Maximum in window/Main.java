import java.util.*;

class Solution{
	static void addToDq(LinkedList<Integer>dq,int idx,int []arr){
		while(dq.size()>0 && arr[dq.peekLast()]<arr[idx]) dq.removeLast();
		dq.addLast(idx);
	}
    static int[] SlidingWindowMaximum(int N, int k, int[] arr){
        // write code here
		int [] res=new int[N-k+1];
		LinkedList<Integer>dq=new LinkedList<>();
		// initially k element should added in deque
		for(int i=0;i<k;i++){
			addToDq(dq,i,arr);
		}
		// for first window we get max element at front of deque
		res[0]=arr[dq.peek()];

		// now declare start, end or windowNo.

		int st=1;
		int end=k;
		int winNum=1;

		

		while(end<N){
			// introduce new element 
			addToDq(dq,end,arr);
			
			// keep removing untill peek(front) elemenet of deque is in range or greater then starting point
			while(dq.peek()<st) dq.remove();

			res[winNum]=dq.peek();
			st++;
			end++;
			winNum++;
		}
		return res;
    }
}

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int nums[]=new int[n];
        for(int i = 0; i < n; i++)
        {
            nums[i] = sc.nextInt();
        }
        Solution obj = new Solution();
        int[] ans=obj.SlidingWindowMaximum(n,k,nums);
        for(int i=0;i<ans.length;++i){
            System.out.print(ans[i] + " ");
        }
    }
}
