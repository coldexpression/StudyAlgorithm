package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class problem2485 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int ans = 0;
        for(int i=0;i<n;i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }

        BigInteger gcd = BigInteger.valueOf(0);
        for(int i=1;i<n;i++) {
            BigInteger bi = BigInteger.valueOf(arr[i] - arr[i-1]);
            gcd = bi.gcd(gcd);
        }

        for(int i=1;i<n;i++) {
            ans += ((arr[i] - arr[i-1]) / gcd.intValue()) - 1;
        }
        System.out.println(ans);
    }

}
