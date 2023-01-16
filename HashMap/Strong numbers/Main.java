import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    public static boolean strongNumbers(long n) {
        Map<Integer, Integer> hm = new HashMap<>();
        for(long i=1;i<=n;i++){
            if(hm.containsKey(n%i))
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine().trim());
        if (strongNumbers(n))
            System.out.println(1);
        else
            System.out.println(0);
    }
}