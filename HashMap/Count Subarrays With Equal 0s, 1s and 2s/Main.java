import java.util.*;

class Solution {
    static int countEqualSubarray012(int arr[], int n) {
        Map<String, Integer> hm = new HashMap<>();
        int zeros = 0;
        int ones = 0;
        int twos = 0;
        int length = 0;
        int delta10 = ones - zeros;
        int delta21 = twos - ones;
        String key = delta10 + "#" + delta21;
        hm.put(key, -1);
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0)
                zeros++;
            else if (arr[i] == 1)
                ones++;
            else
                twos++;
            delta10 = ones - zeros;
            delta21 = twos - ones;
            String str = delta10 + "#" + delta21;
            if (hm.containsKey(str)) {
                int idx = hm.get(str);
                int len = i - idx;
                length = Math.max(length, len);
            } else {
                hm.put(str, i);
            }
        }
        return length;

    }

}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int arr[] = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Solution Obj = new Solution();
        System.out.println(Obj.countEqualSubarray012(arr, N));

    }
}