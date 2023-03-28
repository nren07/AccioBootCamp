import java.io.*;
import java.lang.*;
import java.util.*;

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}

public class Main {
    
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int w = sc.nextInt();
        Item arr[] = new Item[n];
        for(int i=0;i<n;i++) {
            int value = sc.nextInt();
            arr[i] = new Item(value,0);
        }
        for(int i=0;i<n;i++) {
            arr[i].weight = sc.nextInt();
        }
        double ans = (new Solution()).fractionalKnapsack(w,arr,n);
        System.out.println(String.format("%.2f",ans));
    }
}// } Driver Code Ends


/*
class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
*/


class Solution
{
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int capacity, Item arr[], int n) 
    {
       Arrays.sort(arr,(a,b)->{
		   double pwa=1.0*a.value/a.weight; // value : weight ration of a
		   double pwb=1.0*b.value/b.weight; // value :weight ration of b
		   return (int)(pwb-pwa); // sorting will be done on profit weight ration
		   // sorting in decreasing order
	   });

		double totalProfit=0.0;
		for(int i=0;i<n;i++){
			if(capacity>arr[i].weight){
				totalProfit+=arr[i].value;
				capacity-=arr[i].weight;
			}else{
				// fraction weight also consider so remaining capacity will be filled 
				double costOfUnit=1.0*arr[i].value/arr[i].weight;
				totalProfit+=capacity*costOfUnit;
				capacity=0;
				break;
			}
		}
		return totalProfit;
		
    }
}