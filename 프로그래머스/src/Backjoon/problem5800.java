package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class problem5800 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();
        int k = Integer.parseInt(st.nextToken());
        for(int i=0;i<k;i++) {
        st = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(st.nextToken());
            int min = 0;
            sb.append("Class ").append(i+1).append("\n");
            int[] arr = new int[n];
            for(int j=0;j<n;j++) arr[j] = Integer.parseInt(st.nextToken());
            Arrays.sort(arr);
            for(int j=n-1;j>0;j--) min = Math.max(min, arr[j] - arr[j-1]);
            sb.append("Max ").append(arr[n-1]).append(", ").append("Min ").append(arr[0]).append(", ").append("Largest gap ").append(min).append("\n");
        }
        System.out.print(sb);
    }
}
