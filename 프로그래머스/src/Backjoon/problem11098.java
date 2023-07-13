package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem11098 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(st.nextToken());
        for(int i=0;i<t;i++) {
            String input = "";
            int ans = 0;
            st = new StringTokenizer(bf.readLine());
            int p = Integer.parseInt(st.nextToken());
            for(int j=0;j<p;j++) {
                st = new StringTokenizer(bf.readLine());
                int c = Integer.parseInt(st.nextToken());
                String name = st.nextToken();
                if (c > ans) {
                    ans = c;
                    input = name;
                }
            }
            sb.append(input).append("\n");
        }
        System.out.print(sb.toString());
    }
}
