package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem3058 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(st.nextToken());
        for(int i=0;i<t;i++) {
            st = new StringTokenizer(bf.readLine());
            int sum = 0;
            int min = Integer.MAX_VALUE;
            for(int j=0;j<7;j++) {
                int number = Integer.parseInt(st.nextToken());
                if (number % 2 == 0) {
                    if (min > number) min = number;
                    sum += number;
                }
            }
            sb.append(sum).append(" ").append(min).append("\n");
        }
        System.out.print(sb);
    }
}
