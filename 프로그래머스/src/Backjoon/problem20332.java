package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem20332 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int sum = 0;
        st = new StringTokenizer(bf.readLine());
        for(int i=0;i<n;i++) {
            sum += Integer.parseInt(st.nextToken());
        }
        System.out.println(sum % 3 == 0 ? "yes" : "no");
    }
}
