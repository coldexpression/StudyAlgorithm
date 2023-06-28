package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem27210 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(bf.readLine());
        for(int i=0;i<n;i++) arr[i] = Integer.parseInt(st.nextToken());
        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = arr[0] == 1 ? 1 : 0;
        right[0] = arr[0] == 2 ? 1 : 0;

        for(int i=1;i<n;i++) {
            if (arr[i] == 1) {
                left[i] = left[i-1] + 1;
                right[i] = Math.max(right[i-1]-1, 0);
            } else {
                right[i] = right[i-1] + 1;
                left[i] = Math.max(left[i-1]-1, 0);
            }
        }

        int ans = 0;
        for(int i=0;i<n;i++) ans = Math.max(ans, left[i]+right[i]);

        System.out.println(ans);
    }
}
