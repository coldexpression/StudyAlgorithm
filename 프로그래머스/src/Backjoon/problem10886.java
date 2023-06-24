package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem10886 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[2];
        for(int i=0;i<n;i++) {
            int flag = Integer.parseInt(bf.readLine());
            arr[flag]++;
        }

        System.out.println(arr[0] > arr[1] ? "Junhee is not cute!" : "Junhee is cute!");
    }
}
