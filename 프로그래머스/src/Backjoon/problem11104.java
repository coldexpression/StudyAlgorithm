package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem11104 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        for(int i=0;i<n;i++) {
            String input = bf.readLine();
            int plus = 0;
            int number = 0;
            for(int j=23;j>=0;j--) {
                if (input.charAt(j) == '1') number += (int)Math.pow(2, plus);
                plus++;
            }
            sb.append(number).append("\n");
        }
        System.out.print(sb);
    }
}
