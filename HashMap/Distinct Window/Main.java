import java.util.*;

public class Main {

    public static String smallDistinctSubString(String s, int k) {
        int start = 0;
        int end = 0;
        int unique = 0;
        int ans = Integer.MIN_VALUE;
        int freq[] = new int[123];
        int stIdx = -1;
        int endIdx = -1;
        while (end < s.length()) {
            // 1. expansion
            freq[s.charAt(end)]++;
            if (freq[s.charAt(end)] == 1)
                unique++;
            end++;
            // 2. contraction
            while (start < end && unique == k) {
                if (ans > end - start) {
                    ans = end - start;
                    stIdx = start;
                    endIdx = end;
                }
                freq[s.charAt(start)]--;
                if (freq[s.charAt(start)] == 0)
                    unique--;
                start++;
            }
        }
        if (stIdx == -1)
            return "";
        return s.subString(stIdx, endIdx);
    }

    public static String DistinctWindow(String s) {
        int freq[] = new int[123];
        int k = 0;
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i)]++;
            if (freq[s.charAt(i)] == 1)
                k++;
        }
        return smallDistinctSubString(s, k);
    }

    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String ans = DistinctWindow(s);
        System.out.println(ans);
    }
}