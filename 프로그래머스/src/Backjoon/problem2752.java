package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class problem2752 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int[] arr = new int[3];
        for(int i=0;i<3;i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        Arrays.stream(arr).forEach(x -> System.out.print(x + " "));
    }
}
