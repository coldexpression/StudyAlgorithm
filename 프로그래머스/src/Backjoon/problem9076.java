package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class problem9076 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(st.nextToken());
        for(int i=0;i<t;i++) {
            st = new StringTokenizer(bf.readLine());
            int[] arr = new int[5];
            for(int j=0;j<5;j++) arr[j] = Integer.parseInt(st.nextToken());
            Arrays.sort(arr);

            int dst = arr[3] - arr[1];
            int sum = arr[1] + arr[2] + arr[3];

            sb.append(dst >= 4 ? "KIN" : sum).append("\n");
        }
        System.out.print(sb);
    }
}
