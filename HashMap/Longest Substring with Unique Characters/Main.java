import java.util.*;

class Solution {
    public int longestSubstring(String s) {

        Map<Character, Integer> hm = new HashMap<>();
        int ans = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {

            // Update j based on previous
            // occurrence of a[i]
            j = Math.max(hm.containsKey(s.charAt(i)) ? hm.get(s.charAt(i)) : 0, j);

            // Update ans to store maximum
            // length of subarray
            ans = Math.max(ans, i - j + 1);

            // Store the index of current
            // occurrence of a[i]
            hm.put(s.charAt(i), i + 1);
        }

        // Return final ans
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