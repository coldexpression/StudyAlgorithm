package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem9610 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[5];
        for(int i=0;i<n;i++) {
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (x > 0) {
                if (y > 0) arr[1]++;
                else if (y < 0) arr[4]++;
                else arr[0]++;
            } else {
                if (x == 0 || y == 0) arr[0]++;
                else if (y > 0) arr[2]++;
                else arr[3]++;
            }
        }
        System.out.println("Q1: " + arr[1]);
        System.out.println("Q2: " + arr[2]);
        System.out.println("Q3: " + arr[3]);
        System.out.println("Q4: " + arr[4]);
        System.out.println("AXIS: " + arr[0]);
    }
}
