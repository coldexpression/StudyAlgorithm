package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem2953 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int ans = 0;
        int index = 0;
        for(int i=0;i<5;i++) {
            st = new StringTokenizer(bf.readLine());
            int sum = 0;
            while(st.hasMoreTokens()) sum += Integer.parseInt(st.nextToken());

            if (ans < sum) {
                ans = sum;
                index = i+1;
            }
        }
        System.out.print(index + " " + ans);
    }
}
