package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem9506 {
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        sb = new StringBuilder();
        while(true) {
            st = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(st.nextToken());
            if (n == -1) break;

            if (isCheck(n)) builder(n);
            else sb.append(n).append(" is NOT perfect.");
            sb.append("\n");
        }
        System.out.println(sb);
    }
    public static void builder(int n) {
        sb.append(n).append(" = ");
        for(int i=1;i<n;i++) {
            if (n % i == 0) sb.append(i).append(" + ");
        }
        sb.delete(sb.length() - 2, sb.length());
    }
    public static boolean isCheck(int n) {
        int number = 0;
        System.out.println("pas");
        for(int i=1;i<n;i++) {
            if (n % i == 0) {
                number += i;
                System.out.println(i);
            }
        }

        return n == number;
    }
}
