package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem9655 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        String ans = "CY";
        int n = Integer.parseInt(st.nextToken());
        while(n != 0) {
            if (n - 3 >= 0) {
                ans = ans.equals("SK") ? "CY" : "SK";
                n -= 3;
            } else if (n - 1 >= 0) {
                ans = ans.equals("SK") ? "CY" : "SK";
                n--;
            }
        }
        System.out.println(ans);
    }
}
