package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem27294 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int t = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int n = 0;
        if (s == 1 || !(t >= 12 && t <= 16)) n = 280;
        else if (s == 0 && (t >= 12 && t <= 16)) n = 320;
        System.out.println(n);
    }
}
