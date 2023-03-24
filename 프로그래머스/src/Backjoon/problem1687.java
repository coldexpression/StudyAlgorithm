package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem1687 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int ans = 0;
        int[][] map = new int[n][m];
        int[][] sumMap = new int[n][m];
        String input = "";
        for(int i=0;i<n;i++) {
            st = new StringTokenizer(bf.readLine());
            input = st.nextToken();
            for(int j=0;j<m;j++) {
                map[i][j] = Character.getNumericValue(input.charAt(j));
            }
        }

        for(int col=0;col<m;col++) {
            int count = 1;
            sumMap[0][col] = map[0][col] == 0 ? count++ : 0;
            for(int row=1;row<n;row++) {
                if(map[row][col] == 1) {
                    sumMap[row][col] = 0;
                    count = 1;
                } else {
                    sumMap[row][col] += count++;
                }
            }
        }

        for(int pRow=1;pRow<n;pRow++) {
            for(int pCol=0;pCol<m;pCol++) {
                int min = Integer.MAX_VALUE;
                int count = 1;
                for(int mCol=pCol;mCol<m;mCol++) {
                    min = Math.min(min, sumMap[pRow][mCol]);
                    if (sumMap[pRow][mCol] == 0) break;
                    ans = Math.max(ans, min*(count++));
                }
            }
        }
        System.out.println(ans);
    }

}