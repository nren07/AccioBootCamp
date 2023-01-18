import java.util.*;

public class Main {

    public static long DistinctCharacterSubstring(String s) {
        long count = 0, st = 0, end = 0;
        Map<Long,Integer>hm=new HashMap<>();
        while(end<s.length()){
            // 1. expansion
            int val=(hm.getOrDefault(s.charAt(end),0));
            hm.put(s.charAt(end),val+1);
            if(val==0) count++;
			end++;
            // 2. contraction
            while(st<end && hm.get(s.charAt(end-1))==1){
                if(hm.get(s.charAt(st))==1) count++;
                hm.put(s.charAt(st),hm.getOrDefault(s.charAt(st),0)-1);
				start++;
            }
        }
        return count;
    }

    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        long ans = DistinctCharacterSubstring(s);
        System.out.println(ans);
    }
}
