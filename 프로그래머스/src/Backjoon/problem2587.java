package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class problem2587 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[5];
        for(int i=0;i<arr.length;i++) arr[i] = Integer.parseInt(bf.readLine());
        Arrays.sort(arr);
        System.out.println((int)Arrays.stream(arr).average().getAsDouble());
        System.out.println(arr[2]);
    }
}
