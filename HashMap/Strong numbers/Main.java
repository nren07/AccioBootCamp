import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    public static boolean strongNumbers(long n) {

        long num = n;
        for (long i = 2; i < num; i++) {
            while (num % i == 0) {
                if (n % (i * i) != 0) {
                    return false;
                }
                num = num / i;
            }
        }
        if (num > 2 && n % (num * num) != 0) {
            return false;
        }
        return true;

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