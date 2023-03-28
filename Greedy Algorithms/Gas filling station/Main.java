import java.util.*;

class Solution {
    
    public int filling(int tank[],int spent[],int n) {
        //Write your code here
		// invalid case first handle
		int totalFilling=0;
		int totalSpent=0;
		for(int i=0;i<n;i++){
			totalFilling+=tank[i];
			totalSpent+=spent[i];
		}
		if(totalFilling<totalSpent) return -1;
		// now perform valid case
		int tankfill=0;
		int sp=-1;
		for(int i=0;i<n;i++){
			tankfill+=tank[i]; //fuel filling at ith idx
			tankfill-=spent[i]; /// fuel spent to reach next station 
			if(tankfill<0){ //at any point fuel is negative then reset
				tankfill=0;
				sp=-1;
			}else{
				if(sp==-1) sp=i; //don't update sp because we neeed smallest idx
			}
		}
		return sp;
	
    }
}


public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }

        sc.close();
        Solution Obj = new Solution();
        System.out.print(Obj.filling(a,b,n));
    }
}
