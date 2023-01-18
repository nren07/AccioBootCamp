import java.util.*;

class Solution {
    public int longestSubstring(String s) {

        int freq[] = new int[256];
        int st = 0, end = 0, repeat = 0, ans = 0;

        while (end < s.length()) {

            freq[s.charAt(end)]++;
            if (freq[s.charAt(end)] > 1)
                repeat++;
            end++;

            while (st < end && repeat > 0) {
                if (freq[s.charAt(st)] > 1)
                    repeat--;
                freq[s.charAt(st)]--;
                st++;
            }
            ans = Math.max(ans, end - st);

        }
        return ans;
    }
}

public class Main {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Solution ob = new Solution();
        int ans = ob.longestSubstring(s);
        System.out.println(ans);
    }
}