package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem19941 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int answer = 0;
        char[] arr = new char[n];
        boolean[] vis = new boolean[n];
        String input = bf.readLine();
        for(int i=0;i<n;i++) arr[i] = input.charAt(i);

        for(int i=0;i<n;i++) {
            if (arr[i] == 'H') continue;

            // 좌측 탐색
            int index = -1;
            for(int j=i;j>=i-k;j--) {
                if (j < 0) break;
                if (arr[j] == 'P') continue;
                if (!vis[j]) index = j;
            }

            // 우측 탐색
            if (index == -1) {
                for(int j=i;j<=i+k;j++) {
                    if (j >= n) break;
                    if (arr[j] == 'P') continue;
                    if (!vis[j]) {
                        index = j;
                        break;
                    }
                }
            }

            if (index == -1) continue;
            vis[index] = true;
            answer++;
        }
        System.out.println(answer);
    }
}
