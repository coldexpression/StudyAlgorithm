package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author Chansik Seo
 */
public class problem10178 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        for(int i=0;i<n;i++) {
            st = new StringTokenizer(bf.readLine());
            int c = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            sb.append("You get ").append(c/v).append(" piece(s) and your dad gets ").append(c%v).append(" piece(s).\n");
        }
        System.out.print(sb);
    }
}
