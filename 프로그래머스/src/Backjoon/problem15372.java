package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class problem15372 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(bf.readLine());
        long n = 0;
        for(int i=0;i<t;i++) {
            n = Integer.parseInt(bf.readLine());
            sb.append(n*n).append("\n");
        }
        System.out.print(sb);
    }
}
