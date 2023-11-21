package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem4892 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n0 = 0;
        int n1 = 0;
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        int index = 1;
        StringBuilder sb = new StringBuilder();
        while(true) {
            n0 = Integer.parseInt(bf.readLine());
            if (n0 == 0) break;
            n1 = 3*n0;
            n2 = n1 % 2 == 0 ? n1 / 2 : (n1 + 1) / 2;
            n3 = 3 * n2;
            n4 = n3 / 9;
            sb.append(index++).append(". ").append(n1 % 2 == 0 ? "even " : "odd ").append(n4).append("\n");
        }
        System.out.print(sb);
    }
}
