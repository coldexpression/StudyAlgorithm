package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem10214 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        for(int i=0;i<n;i++) {
            int ySum = 0;
            int kSum = 0;
            for(int j=0;j<9;j++) {
                st = new StringTokenizer(bf.readLine());
                int y = Integer.parseInt(st.nextToken());
                int k = Integer.parseInt(st.nextToken());
                ySum += y;
                kSum += k;
            }
            System.out.println(ySum > kSum ? "Yonsei" : ySum < kSum ? "Korea" : "Draw");
        }
    }
}
