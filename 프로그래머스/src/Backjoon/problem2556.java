package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem2556 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int max = Integer.MIN_VALUE;
        int maxR = -1;
        int maxC = -1;
        for(int i=0;i<9;i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j=0;j<9;j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num > max) {
                    max = num;
                    maxR = i + 1;
                    maxC= j + 1;
                }
            }
        }
        System.out.println(max);
        System.out.println(maxR + " " + maxC);

    }
}
