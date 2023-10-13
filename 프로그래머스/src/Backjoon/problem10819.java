package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem10819 {
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st= new StringTokenizer(bf.readLine());
        for(int i=0;i<n;i++) arr[i] = Integer.parseInt(st.nextToken());
        answer = Integer.MIN_VALUE;
        perm(0, arr, new int[n], new boolean[n], n);
        System.out.println(answer);
    }

    public static void perm(int count, int[] arr, int[] brr, boolean[] vis, int n) {
        if (count == n) {
            int sum = 0;
            for(int i=1;i<n;i++) sum += Math.abs(brr[i-1] - brr[i]);
            answer = Math.max(answer, sum);
            return;
        }

        for(int i=0;i<n;i++) {
            if (!vis[i]) {
                vis[i] = true;
                brr[count] = arr[i];
                perm(count + 1, arr, brr, vis, n);
                vis[i] = false;
            }
        }
    }
}
