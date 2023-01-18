import java.util.*;

class Solution {
    public boolean isSatisfied(int tFreq[], int sFreq[]) {
        for (int i = 0; i < 123; i++) {
            if (tFreq[i] > sFreq[i])
                return false;
        }
        return true;
    }

    public String SmallestSubstring(String s, String t) {
        int sFreq[] = new int[123];
        int tFreq[] = new int[123];
        for (int i = 0; i < t.length(); i++) {
            tFreq[t.charAt(i)]++;
        }
        int start = 0;
        int end = 0;
        int stIdx = -1;
        int endIdx = -1;
        int ans = Integer.MAX_VALUE;
        while (end < s.length()) {
            // 1.expansion
            sFreq[s.charAt(end)]++;
            end++;
            // 2. conraction is done when tfreq is less then sfreq
            while (start < end && isSatisfied(tFreq, sFreq)) {
                // 3. calculaton for minimum length of window
                if (ans > end - start) {
                    ans = end - start;
                    stIdx = start;
                    endIdx = end;
                }
                sFreq[s.charAt(start)]--;
                start++;
            }
        }
        if (stIdx == -1)
            return "-1";
        return s.substring(stIdx, endIdx);

    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next(), b = sc.next();
        Solution Obj = new Solution();
        System.out.println(Obj.SmallestSubstring(a, b));
    }
}