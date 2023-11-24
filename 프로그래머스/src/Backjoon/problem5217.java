package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem5217 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(st.nextToken());
        for(int i=0;i<t;i++) {
            int n = Integer.parseInt(bf.readLine());
            int a = 0;
            int b = n;
            sb.append("Pairs for ").append(n).append(": ");
            if (n <= 2) {
                sb.append("\n");
                continue;
            }
            while(true) {
                a++;
                b--;
                if (a >= b) {
                    sb.deleteCharAt(sb.length() - 2);
                    sb.append("\n");
                    break;
                }
                sb.append(a).append(" ").append(b).append(", ");
            }
        }
        System.out.print(sb);
    }
}
