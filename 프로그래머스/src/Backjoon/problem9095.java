package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem9095 {
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(st.nextToken());
        for(int i=0;i<t;i++) {
            int n = Integer.parseInt(bf.readLine());
            ans = 0;
            dfs(n, 0);
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }

    public static void dfs(int sum, int curSum) {
        if (sum < curSum) return;
        if (sum == curSum) {
            ans++;
            return;
        }

        for(int i=1;i<=3;i++) dfs(sum, curSum + i);
    }
}
