import java.util.*;
class Solution
{
       static int xorSubarrayXors(int arr[], int n) {
        //Write code here
		   int res=0;
		   for(int i=0;i<n;i++){
			   int contribution=(i+1)*(n-i);
			   if((contribution & 1)==1) res^=arr[i];
		   }
		   return res;
    }
}
public class Main {

    

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }
        int ans = Solution.xorSubarrayXors(arr, n);
        System.out.print(ans);
        input.close();
    }
}