package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem10093 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long start = Math.min(a, b);
        long end = Math.max(a, b);
        StringBuilder sb = new StringBuilder();
        if (start == end) sb.append(0);
        else {
            sb.append(end - start - 1).append("\n");
            for (long i = start + 1; i < end; i++) {
                sb.append(i);
                if (i != end - 1) sb.append(" ");
            }
        }
        System.out.print(sb);
    }
}
