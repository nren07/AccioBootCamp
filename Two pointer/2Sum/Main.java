import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    
    public static int[] twoSum(int[] nums, int target) {
        int[]ans=new int[2];
        int st=0;
        int end=nums.length-1;
        while(st<end){
            int sum=nums[st]+nums[end];
            if(sum==target){
                ans[0]=st+1;
                ans[1]=end+1;
                return ans;
            }else if(sum<target){
                st++;
            }
            else{
                end--;
            }
        }
        return ans;
    }
	
    public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
        long n = Long.parseLong(br.readLine().trim());
        String inputLine[] = br.readLine().trim().split(" ");
        int[] arr = new int[(int)n];
        for(int i=0; i<n; i++)arr[i]=Integer.parseInt(inputLine[i]);
        int m = Integer.parseInt(br.readLine().trim());
        int[] ans = (twoSum(arr, m));
        System.out.println(ans[0] + " " + ans[1]);
	}
}



