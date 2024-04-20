package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author Chansik Seo
 */
public class problem4880 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        while(true) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (a == 0 && a == b && b == c) break;
            if ((b - a) == (c - b)) sb.append("AP ").append(c + (c - b));
            else sb.append("GP ").append(c * (b/a));
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
