package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class problem20002 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[][] map = new int[n+1][n+1];
        int ans = Integer.MIN_VALUE;
        for(int i=1;i<n+1;i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j=1;j<n+1;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                ans = Math.max(ans, map[i][j]);
            }
        }
        int[][] sum = new int[n+1][n+1];
        for(int row=1;row<n+1;row++) {
            for(int col=1;col<n+1;col++) {
                if (col == 1) sum[row][col] = map[row][col];
                else sum[row][col] = sum[row][col-1] + map[row][col];
            }
        }

        for(int col=1;col<n+1;col++) {
            for(int row=1;row<n+1;row++) {
                if (row == 1) continue;
                sum[row][col] += sum[row-1][col];
            }
        }

        for(int k=2;k<=n;k++)
            for(int row=k;row<n+1;row++)
                for(int col=k;col<n+1;col++)
                    ans = Math.max(ans, sum[row][col]-sum[row][col-k]-sum[row-k][col]+sum[row-k][col-k]);

        System.out.println(ans);
    }
}
