package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem5522 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        for(int i=0;i<5;i++) answer += Integer.parseInt(bf.readLine());
        System.out.println(answer);
    }
}
