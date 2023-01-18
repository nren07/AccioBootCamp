import java.util.*;

public class Main {
    // Array Of hashMap haviing snap id or val at perticular idx
    static Map<Integer, Integer>[] mapArray;
    static int snapId;

    public static void SnapshotArray(int length) {
        // initialision of array with the length given
        mapArray = new HashMap[length];
        snapId = 0;
    }

    public static void set(int idx, int val) {
        // if first time insertion is done then create a map at that perticular idx
        // by default array of map having value is null like 0 in case of integer array
        if (mapArray[idx] == null) {
            mapArray[idx] = new HashMap<>();
        }
        mapArray[idx].put(snapId, val);
    }

    public static int snap() {
        // return snapId and then increment it--> post increment
        return snapId++;
    }

    public static int get(int idx, int id) {
        // if idx is never set then value shoould be zero at perticular idx
        if (mapArray[idx] == null) {
            return 0;
        }
        // else while snapid is increasing if any idx update so to get last updated
        // snapid at perticular idx in hashmap
        while (id >= 0 && mapArray[idx].containsKey(id) == false) {
            id--;
        }
        // no updation afterall
        if (id == -1) {
            return 0;
        }
        return mapArray[idx].get(id);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        String temp;
        int param1, param2;
        param1 = input.nextInt();
        SnapshotArray(param1);
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {

            temp = input.next();
            if (temp.equals("set") || temp.equals("get")) {
                param1 = input.nextInt();
                param2 = input.nextInt();
                if (temp.equals("set")) {
                    set(param1, param2);
                } else {
                    System.out.println(get(param1, param2));
                }
            } else {
                System.out.println(snap());
            }
        }

    }
}
