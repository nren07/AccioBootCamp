import java.util.*;

class Solution {
    public int longestSubstring(String s) {
        int maxLen = 0;
        int st = 0;
        int end = 0;
        int n = s.length();
        Map<Character, Integer> hm = new HashMap<>();
        while (end < n) {
            if (!hm.containsKey(s.charAt(end))) {
                hm.put(s.charAt(end), 1);
                maxLen = Math.max(maxLen, end - start);
                end++;
            } else {
                hm.put(s.charAt(i), 2);
                while (start < end && hm.get(s.charAt(end)) > 1) {
                    hm.remove(s.charAt(start));
                    start++;
                }
            }
        }
        return maxLen;
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