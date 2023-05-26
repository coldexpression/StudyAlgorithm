package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem2476 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int ans = 0;
        for(int i=0;i<n;i++) {
            st = new StringTokenizer(bf.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int n3 = Integer.parseInt(st.nextToken());
            if (n1 == n2 && n2 == n3) ans = Math.max(ans, 10000+n1*1000);
            else if (n1 == n2) ans = Math.max(ans, 1000+n1*100);
            else if (n2 == n3) ans = Math.max(ans, 1000+n2*100);
            else if (n1 == n3) ans = Math.max(ans, 1000+n3*100);
            else ans = Math.max(ans, Math.max(n1, Math.max(n2, n3))*100);
        }
        System.out.println(ans);
    }
}
