package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem5176 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();
        int k = Integer.parseInt(st.nextToken());
        for(int i=0;i<k;i++) {
            st = new StringTokenizer(bf.readLine());
            int p = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int ans = 0;
            int[] arr = new int[m];
            for(int j=0;j<p;j++) {
                int num = Integer.parseInt(bf.readLine()) - 1;
                if (arr[num] == 0) arr[num]++;
                else ans++;
            }
            sb.append(ans).append("\n");
        }
        System.out.print(sb);
    }
}
