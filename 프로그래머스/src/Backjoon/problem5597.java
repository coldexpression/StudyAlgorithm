package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem5597 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[] arr = new int[31];

        for(int i=0;i<28;i++) {
            st = new StringTokenizer(bf.readLine());
            int input = Integer.parseInt(st.nextToken());
            arr[input] = 1;
        }

        for(int i=1;i<=30;i++) {
            if(arr[i] == 0) System.out.println(i);
        }
    }
}
