package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class problem1789 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        long s = Long.parseLong(bf.readLine());
        int ans = 1;
        for(long i=1;s-i>i;i++) {
            s -= i;
            ans++;
        }
        System.out.print(ans);
    }

}
