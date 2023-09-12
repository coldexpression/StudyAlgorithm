package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class problem5576 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[10];
        int[] brr = new int[10];
        for(int i=0;i<20;i++) {
            int num = Integer.parseInt(bf.readLine());
            if (i >= 0 && i <= 9) arr[i] = num;
            else brr[i-10] = num;
        }
        Arrays.sort(arr);
        Arrays.sort(brr);
        System.out.println((arr[9] + arr[8] + arr[7]) + " " + (brr[9] + brr[8] + brr[7]));
    }
}
