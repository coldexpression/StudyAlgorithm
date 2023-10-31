package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem2669 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        boolean[][] vis = new boolean[101][101];
        for(int i=0;i<4;i++) {
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            for(int j=y;j<b;j++) {
                for(int k=x;k<a;k++) {
                    vis[j][k] = true;
                }
            }
        }

        int count = 0;
        for(int i=0;i<=100;i++)
            for(int j=0;j<=100;j++) count = vis[i][j] ? count + 1 : count;
        System.out.println(count);
    }
}
