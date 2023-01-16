import java.util.*;
// 1.expansion when 1 ocuures or zeros occuring upto k no of zeros
//2. if zeros exceed from k then contraction happen
//3 mean while calculation is done of max length

class Accio {
    public int longestOnes(int[] arr, int k) {

        int start = 0;
        int end = 0;
        int n = arr.length;
        int count = 0;
        int len = 0;

        while (end < n) {
            // 1.expansion
            if (arr[end] == 0)
                count++;

            end++;
            // contraction
            while (start < end && count > k) {
                if (arr[start] == 0)
                    count--;
                start++;
            }
            len = Math.max(len, end - start);
        }
        return len;

    }

}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++)
            A[i] = sc.nextInt();
        int B = sc.nextInt();
        Accio Obj = new Accio();
        System.out.println(Obj.longestOnes(A, B));
    }
}