package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author Chansik Seo
 */
public class problem4447 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        for(int i=0;i<n;i++) {
            String input = bf.readLine();
            sb.append(input);
            char[] chars = input.toLowerCase().toCharArray();
            int g = 0;
            int b = 0;
            for (char c : chars) {
                if (c == 'g') g++;
                else if (c == 'b') b++;
            }
            if (g > b) {
                sb.append(" is GOOD");
            } else if (g < b) {
                sb.append(" is A BADDY");
            } else {
                sb.append(" is NEUTRAL");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
