import java.util.*;
import java.io.*;
class Solution {
   public List<List<Integer>> fourSum(int[] nums, int target) {
	    List<List<Integer>>ans=new ArrayList<>();
	   if(nums.length<4)return ans;
	   int n=nums.length;
	   Arrays.sort(nums);
	   int i=0;
	   while(i<n){
		   int j=i+1;
		   while(j<n){
			   int st=j+1;
			   int end=n-1;
			   while(st<end){
					long sum=(long)(nums[st]+nums[end]);
					long newTarget=(long)(target-(long)((nums[i]+nums[j])));
					if(sum==newTarget){
                        List<Integer>list=new ArrayList<>();
						list.add(nums[i]);
						list.add(nums[j]);
		                list.add(nums[st]);
		                list.add(nums[end]);
		                ans.add(list);
						// to remove duplicacy we have to keep increment st untill diff element ocuures
						st++;
						while(st<n && nums[st]==nums[st-1]) st++;
						
						 // to remove duplicacy we have to keep increment end untill diff element ocuures
						end--;
						while(end>=0 && nums[end]==nums[end+1]) end--;
						
		            }else if(sum<newTarget){
						// to remove duplicacy we have to keep increment st untill diff element ocuures
		                st++;
						while(st<n && nums[st]==nums[st-1]) st++;
		            }
		            else{
						// to remove duplicacy we have to keep increment end untill diff element ocuures
		                end--;
						while(end>=0 && nums[end]==nums[end+1]) end--;
		            }
		        }
			   // to remove duplicacy we have to keep increment j untill diff element ocuures
			   j++;
			   while(j<n && nums[j]==nums[j-1]) j++;
		   }
		   // to remove duplicacy we have to keep increment i untill diff element ocuures
		   i++;
		   while(i<n && nums[i]==nums[i-1]) i++;
	   }
		return ans;
	}
}

public class Main
{
	    
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++)
            nums[i] = sc.nextInt();
        int k = sc.nextInt();
        Solution Obj = new Solution();
        List<List<Integer>> res = Obj.fourSum(nums, k);

      
        for(int i= 0; i<res.size(); i++){
           Collections.sort(res.get(i));
        }

     
        Collections.sort(res, new Comparator<List<Integer>>() {
               public int compare(List<Integer> frst, List<Integer> scnd) {
                    int i=0;
                    while(frst.get(i)==scnd.get(i)) i++;
                    return frst.get(i)-scnd.get(i);
                    }
                });

        for(int i=0; i<res.size(); i++){   
            for(int j=0; j<4; j++){
                System.out.print(res.get(i).get(j) + " ");
            } 
            System.out.println("");
        }
        sc.close();
	}
}