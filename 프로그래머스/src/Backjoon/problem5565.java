package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem5565 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int sum = Integer.parseInt(bf.readLine());
        for(int i=0;i<9;i++) sum -= Integer.parseInt(bf.readLine());
        System.out.print(sum);
    }
}
