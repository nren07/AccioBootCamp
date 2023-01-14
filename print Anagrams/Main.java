
// A Java program to print all anagrams together
import java.util.*;

public class Main {
    static String sortStr(String s) {

        char[] arr = s.toCharArray();
        // sort the array
        Arrays.sort(arr);
        // convert arr to string
        return new String(arr);
    }
    static void printAnagramsTogether(String strs[],
            int n) {
        Map<String, List<String>> hm = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String original = strs[i];
            String sorted = sortStr(original);
            if (hm.containsKey(sorted)) {
                List<String> oldlist = hm.get(sorted);
                oldlist.add(original);
                hm.put(sorted, oldlist);
            } else {
                List<String> newlist = new ArrayList<>();
                newlist.add(original);
                hm.put(sorted, newlist);
            }
        }

        for (String key : hm.keySet()) {
            List<String> ans = hm.get(key);
            for (int i = 0; i < ans.size(); i++) {
                System.out.print(ans.get(i) + " ");
            }
        }
    }

    // Driver program to test above functions
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] wordArr = new String[n];
        for (int i = 0; i < n; i++)
            wordArr[i] = sc.next();
        sc.close();
        printAnagramsTogether(wordArr, n);
    }
}