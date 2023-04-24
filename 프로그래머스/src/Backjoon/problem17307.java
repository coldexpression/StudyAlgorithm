package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class problem17307 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        long[] left = new long[n];
        long[] right = new long[n];
        st = new StringTokenizer(bf.readLine());
        for(int i=0;i<n;i++) arr[i] = Integer.parseInt(st.nextToken());

        for(int i=1;i<n;i++) {
            if (arr[i-1] > arr[i]) left[i] = left[i-1] + (arr[i-1] - arr[i]);
            else if (arr[i-1] < arr[i]) left[i] = left[i-1] + (c - arr[i] + arr[i-1]);
            else left[i] = left[i-1];
        }

        for(int i=n-2;i>=0;i--) {
            if (arr[i] < arr[i+1]) right[i] = right[i+1] + (arr[i+1] - arr[i]);
            else if (arr[i+1] < arr[i]) right[i] = right[i+1] + (c - arr[i] + arr[i+1]);
            else right[i] = right[i+1];
        }

        long total = Long.MAX_VALUE;
        int index = 0;

        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));

        for(int i=0;i<n;i++) {
            long minus = Math.max(left[i], right[i]);
            if (minus < total) {
                total = minus;
                index = i;
            }
        }

        System.out.println(index+1);
        System.out.println(Math.max(left[index], right[index]));
    }
}
