package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class problem2750 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        for(int i=0;i<n;i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }

        Arrays.sort(arr);
        Arrays.stream(arr).forEach(x -> System.out.println(x));
    }
}
