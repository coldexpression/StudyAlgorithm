package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem2501 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int count = 0;
        int ans = 0;
        for(int i=1;i<=n;i++) {
            if (n % i == 0) {
                k--;
                count++;
                if (k == 0) {
                    ans = i;
                    break;
                }
            }
        }
        System.out.println(count >= k ? ans : 0);
    }
}
