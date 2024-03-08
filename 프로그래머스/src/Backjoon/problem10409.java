package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author Chansik Seo
 */
public class problem10409 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        int count = 0;
        for(int i=0;i<n;i++) {
            int num = Integer.parseInt(st.nextToken());
            if (t - num < 0) break;
            t -= num;
            count++;
        }
        System.out.println(count);
    }
}
