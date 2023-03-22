import java.io.*;
import java.util.*;



class Main {
    
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = input.nextInt();
        }
        Solution solution = new Solution();
        List<List<Integer>> result = solution.threeSum(nums);
        //Sort all lists inside the list first
        for (int i = 0; i < result.size(); i++) {
            Collections.sort(result.get(i));
        }
        //Sort the list
        Collections.sort(result, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> l1, List<Integer> l2) {
                for (int i = 0; i < l1.size(); i++) {
                    if (l1.get(i) < l2.get(i)) return -1;
                    else if (l1.get(i) > l2.get(i)) return 1;
                }
                return 0;
            }
        });
        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.get(i).size(); j++) {
                System.out.print(result.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>>ans=new ArrayList<>();
	   if(nums.length<3)return ans;
	   int n=nums.length;
	   Arrays.sort(nums);
	   int i=0;
	   while(i<n){
		   int st=i+1;
		   int end=n-1;
		   while(st<end){
				long sum=(long)(nums[i]+nums[st]+nums[end]);
				if(sum==0){
					List<Integer>list=new ArrayList<>();
					list.add(nums[i]);
					list.add(nums[st]);
					list.add(nums[end]);
					ans.add(list);
					st++;
					while(st<n && nums[st]==nums[st-1]) st++;
					end--;
					while(end>=0 && nums[end]==nums[end+1]) end--;
					
				}else if(sum<0){
					st++;
					while(st<n && nums[st]==nums[st-1]) st++;
				}
				else{
					end--;
					while(end>=0 && nums[end]==nums[end+1]) end--;
				}
			}
		   i++;
		   while(i<n && nums[i]==nums[i-1]) i++;
	   }
		return ans;
    }
}