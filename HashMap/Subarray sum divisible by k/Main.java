import java.io.*;
import java.util.*;

public class Main {
public static int subarraysDivByK(int[] nums, int k)
{
    int n = nums.length;
    Map<Integer, Integer> hm = new HashMap<>();
    int sum = 0;
    int cnt = 0;
    hm.put(0, 1); // to handle continuous sum % k == 0
 
    for(int i = 0; i < n; i++)
    {
        sum += nums[i];
        int rem = sum % k;
        if(rem < 0) rem = rem + k;
       
        int val = hm.getOrDefault(rem, 0);
        cnt += val;
        hm.put(rem, val + 1);
    }
    return cnt;
}

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;++i){
            arr[i]=sc.nextInt();
        }
        int result = subarraysDivByK(arr, k);
        System.out.print(result);        
        System.out.println('\n');
    }
}