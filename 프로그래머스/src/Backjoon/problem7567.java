package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem7567 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine();
        int ans = 10;
        char prev = input.charAt(0);
        for(int i=1;i<input.length();i++) {
            if (input.charAt(i) == '(') ans = prev == '(' ? ans + 5 : ans + 10;
            else ans = prev == ')' ? ans + 5 : ans + 10;
            prev = input.charAt(i);
        }
        System.out.println(ans);
    }
}
