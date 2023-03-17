import java.util.*;

class Solution {
    static int maxOne(int arr[], int n,int k)
    {
        int i=0, j=0, zero=0, ans=0;
		while(i<n){
			if(arr[i]==0) zero++;

			// while zero greater then k then shrik it
			while(zero>k){
				if(arr[j]==0) zero--;
				j++;
			}

			ans=Math.max(ans,i-j+1);
			i++;
		}
		return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int k= sc.nextInt();
        int array[] = new int[n];

        for(int i=0; i<n; i++){
            array[i]= sc.nextInt();
        }
        Solution Obj = new Solution();
        System.out.println(Obj.maxOne(array,n,k));
    }
}