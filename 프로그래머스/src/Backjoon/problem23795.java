package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem23795 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        while (true) {
            int n = Integer.parseInt(bf.readLine());
            if (n == -1) break;
            sum += n;
        }
        System.out.println(sum);
    }
}
