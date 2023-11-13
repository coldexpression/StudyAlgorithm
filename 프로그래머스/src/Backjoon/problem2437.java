package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class problem2437 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        int[] arr = new int[n];
        for(int i=0;i<n;i++) arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);
        int sum = 0;
        for(int i=0;i<n;i++) {
            if (sum + 1 >= arr[i]) sum += arr[i];
            else break;
        }
        System.out.println(sum+1);
    }
}
