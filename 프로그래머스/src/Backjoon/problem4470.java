package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author Chansik Seo
 */
public class problem4470 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=n;i++) {
            sb.append(i).append(". ");
            sb.append(bf.readLine()).append("\n");
        }
        System.out.print(sb);
    }
}
