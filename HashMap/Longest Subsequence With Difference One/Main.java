import java.util.*;

class Accio {
    public int longestSubsequence(int[] nums) {
        Map<Integer, Integer> hm = new HashMap<>();
        int ans = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            // check nums[i]-1 or nums[i]+1 present in hashmap
            int val1 = hm.getOrDefault(nums[i] - 1, 0);
            int val2 = hm.getOrDefault(nums[i] + 1, 0);
            int val = Math.max(val1, val2);
            hm.put(nums[i], val + 1);
            ans = Math.max(ans, val + 1);
        }
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++)
            nums[i] = sc.nextInt();
        Accio Obj = new Accio();
        System.out.println(Obj.longestSubsequence(nums));
    }
}