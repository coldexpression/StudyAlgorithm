package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem5073 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        while(true) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int max = Math.max(a, Math.max(b, c));

            if (a == 0 && b == 0 && c == 0) break;
            if (a == max && b + c <= a) {
                sb.append("Invalid").append("\n");
                continue;
            } else if (b == max && a + c <= b) {
                sb.append("Invalid").append("\n");
                continue;
            } else if (c == max && b + a <= c) {
                sb.append("Invalid").append("\n");
                continue;
            }

            if (a == b && b == c) sb.append("Equilateral").append("\n");
            else if (a == b || a == c || b == c) sb.append("Isosceles").append("\n");
            else if (a != b && b != c && c !=a ) sb.append("Scalene").append("\n");
        }
        System.out.print(sb);
    }
}
