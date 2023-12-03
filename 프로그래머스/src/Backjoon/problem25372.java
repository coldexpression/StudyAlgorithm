package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem25372 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        for(int i=0;i<n;i++) {
            String input = bf.readLine();
            System.out.println(input.length() >= 6 && input.length() <= 9 ? "yes" : "no");
        }
    }
}
