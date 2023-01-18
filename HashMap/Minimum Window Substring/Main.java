import java.io.*;
import java.util.*;

class Solution {
    public boolean isSatisfied(int tFreq[], int sFreq[]) {
        for (int i = 0; i < 123; i++) {
            if (tFreq[i] > sFreq[i])
                return false;
        }
        return true;
    }

    public String minWindow(String s, String t) {
        int sFreq[] = new int[s.length()];
        int tFreq[] = new int[t.length()];
        for (int i = 0; i < t.length(); i++) {
            tFreq[s.charAt(i)]++;
        }
        int start = 0;
        int end = 0;
        int stIdx = -1;
        int endIdx = -1;
        int ans = Integer.MAX_VALUE;
        while (end < n) {
            // 1.expansion
            sFreq[s.charAt(end)]++;
            end++;
            // 2. conraction is done when tfreq is less then sfreq
            while (start < end && isSatisfied(tFreq, sFreq)) {
                if (ans > end - start) {
                    ans = end - start;
                    stIdx = start;
                    endIdx = end;
                }
                sFreq[s.charAt(start)]--;
                start++;
            }
        }
        return s.substring(stIdx, endIdx);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s, t;
        s = sc.next();
        t = sc.next();
        Solution Obj = new Solution();
        System.out.print(Obj.minWindow(s, t));
    }
}