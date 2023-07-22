package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem14465 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int count = 0;
        int ans = 0;
        boolean[] vis = new boolean[n];
        for(int i=0;i<b;i++) {
            int num = Integer.parseInt(bf.readLine()) - 1;
            vis[num] = true;
        }

        for(int i=0;i<k;i++) count = vis[i] ? count + 1 : count;
        ans = count;
        int left = 0;
        int right = k-1;

        while(true) {
            System.out.println("left : " + left);
            System.out.println("right : " + right);
            if (right >= n-1) break;
            count = vis[left++] ? count - 1 : count;
            count = vis[++right] ? count + 1 : count;
            ans = Math.min(ans, count);
        }
        System.out.println(ans);
    }
}
