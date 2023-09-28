package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem4458 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(bf.readLine());
        for(int i=0;i<n;i++) {
            char[] input = bf.readLine().toCharArray();
            input[0] = input[0] >= 'a' && input[0] <= 'z' ? (char)(input[0] - 32) : input[0];
            for (char c : input) sb.append(c);
            if (i < n - 1) sb.append("\n");
        }
        System.out.print(sb);
    }
}
