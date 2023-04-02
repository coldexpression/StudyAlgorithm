package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class problem10811 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for(int i=0;i<n;i++) arr[i] = i+1;

        for(int i=0;i<m;i++) {
            st = new StringTokenizer(bf.readLine());
            int s = Integer.parseInt(st.nextToken()) - 1;
            int e = Integer.parseInt(st.nextToken()) - 1;

            arr = swap(s, e, arr);
        }
        Arrays.stream(arr).forEach(x -> System.out.print(x + " "));
    }

    public static int[] swap(int s, int e, int[] arr) {
        int[] brr = arr.clone();
        int p = arr[s];

        for(int i=e, j=s;i>s;i--,j++) {
            brr[j] = arr[i];
        }
        brr[e] = p;
        return brr;
    }
}
