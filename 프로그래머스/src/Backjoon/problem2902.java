package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem2902 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine();
        String[] split = input.split("-");
        StringBuilder sb = new StringBuilder();
        for (String s : split) sb.append(s.charAt(0));
        System.out.println(sb);
    }
}
