package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem2720 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(st.nextToken());
        for(int i=0;i<t;i++) {
            st = new StringTokenizer(bf.readLine());
            int c = Integer.parseInt(st.nextToken());

            sb.append(c / 25);
            sb.append(" ");
            c %= 25;

            sb.append(c / 10);
            sb.append(" ");
            c %= 10;
            sb.append(c / 5);
            sb.append(" ");
            c %= 5;
            sb.append(c);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
