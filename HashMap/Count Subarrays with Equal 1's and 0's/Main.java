import java.util.*;

class Solution {
    static int countEqualSubarray01(int arr[], int n) {
        Map<Integer, Integer> hm = new HashMap<>();
        int sum = 0;
        hm.put(0, 1);
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                arr[i] = -1;
                sum += arr[i];
            } else {
                sum += arr[i];
            }
            if (hm.containsKey(sum)) {
                count += hm.get(sum);
                hm.put(sum, hm.get(sum) + 1);
            } else {
                hm.put(sum, 1);
            }
        }
        return count;
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
        System.out.println(Obj.countEqualSubarray01(arr, N));

    }
}