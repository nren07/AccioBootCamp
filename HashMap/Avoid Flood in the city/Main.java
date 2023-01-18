import java.util.*;

public class Main {
    public int searchOPT(TreeMap<Integer, Integer> thm, int st) {
        Integer dryIdx = thm.ceilingKey(st);
        if (dryIdx == null)
            return -1;
        return dryIdx;
    }

    static int[] avoidFlood(int[] rains) {
        int[] ans = new int[rains.length];
        Map<Integer, Integer> hm = new HashMap<>();
        TreeMap<Integer, Integer> thm = new TreeMap<>();
        for (int i = 0; i < rains.length; i++) {
            int lakeNo = rains[i];
            if (lakeNo > 0) {
                // prev filled lake
                if (hm.containsKey(lakeNo)) {

                    int prevIdx = hm.get(lakeNo); // last filled idx
                    int dryIdx = searchOPT(thm, prevIdx + 1); // search dry idx from prev idx+1 to i-1;
                    // if dry idx found-->
                    if (dryIdx != -1) {
                        ans[i] = -1;
                        ans[dryIdx] = lakeNo;
                        rains[dryIdx] = Integer.MIN_VALUE;
                        thm.remove(dryIdx);
                    } else
                        return new int[] {};

                } else
                    ans[i] = -1;
                hm.put(lakeNo, i);
            } else {
                thm.put(i, 1);
            }
        }
        for (int i = 0; i < rains.length; i++) {
            if (rains[i] == 0)
                ans[i] = 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] rains = new int[n];
        for (int i = 0; i < n; i++) {
            rains[i] = input.nextInt();
        }
        int[] ans = avoidFlood(rains);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i]);
            System.out.print(" ");
        }
        if (ans.length == 0)
            System.out.print(" ");
    }
}
