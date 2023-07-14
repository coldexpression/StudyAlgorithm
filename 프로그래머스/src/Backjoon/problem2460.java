package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem2460 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int current = 0;
        int ans = 0;
        for(int i=1;i<=10;i++) {
            st = new StringTokenizer(bf.readLine());
            int out = Integer.parseInt(st.nextToken());
            int in = Integer.parseInt(st.nextToken());
            current -= out;
            ans = Math.max(ans, current);
            current += in;
            ans = Math.max(ans ,current);
        }
        System.out.println(ans);
    }
}
