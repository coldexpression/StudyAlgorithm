package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class problem2693 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(st.nextToken());
        for(int i=0;i<t;i++) {
            int[] arr = new int[10];
            st = new StringTokenizer(bf.readLine());
            for(int j=0;j<10;j++) arr[j] = Integer.parseInt(st.nextToken());
            Arrays.sort(arr);
            sb.append(arr[7]).append("\n");
        }
        System.out.print(sb);
    }
}
