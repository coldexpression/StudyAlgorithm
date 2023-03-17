package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class problem2512 {

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int ans = Integer.MIN_VALUE;
        arr = new int[n];

        st = new StringTokenizer(bf.readLine());
        for(int i=0;i<n;i++) arr[i] = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(bf.readLine());

        Arrays.sort(arr);
        int left = 1;
        int right = arr[n - 1];
        int middle = 0;
        long sum = 0;

        while(left <= right) {
            middle = (left + right) / 2;
            sum = calc(middle);

            if (sum == m) {
                ans = middle;
                break;
            }

            if (sum > m) {
                right = middle - 1;
            } else {
                ans = Math.max(ans, middle);
                left = middle + 1;
            }
        }

        System.out.println(ans);
    }

    public static long calc(int pivot) {
        long sum = 0;
        for(int i=0;i<arr.length;i++) {
            sum += Math.min(arr[i], pivot);
        }

        return sum;
    }
}
