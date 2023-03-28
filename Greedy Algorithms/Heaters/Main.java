import java.util.*;

class Solution {
	public int[] floorCeil(int target,int []heaters){
		int floor=-10000000;
		int ceil=10000000;
		int ans[]=new int [2];
		int l=0;
		int r=heaters.length-1;
		while(l<=r){
			int mid=(l+r)/2;
			if(heaters[mid]==target){
				floor=heaters[mid];
				ceil=heaters[mid];
				ans[0]=floor;
				ans[1]=ceil;
				return ans;
			}else if(heaters[mid]<target){
				floor=heaters[mid];
				l=mid+1;
			}else{
				ceil=heaters[mid];
				r=mid-1;
			}
		}
		ans[0]=floor;
		ans[1]=ceil;
		return ans;
	}
    public int findRadius(int[] houses, int[] heaters) {
		for(int x : houses){
			int result[]=floorCeil(x,heaters);
			int floor=result[0];
			int ceil=result[1];
			int nearestDistance=Math.min(x-floor,ceil-x);
			res=Math.max(res,nearestDistance);
		}
		return res;
    }

}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        int m = sc.nextInt();
        int[] arr2 = new int[m];
        for (int i = 0; i < m; i++)
            arr2[i] = sc.nextInt();
        Solution Obj = new Solution();
        int res = Obj.findRadius(arr, arr2);
        System.out.println(res);
        sc.close();
    }
}