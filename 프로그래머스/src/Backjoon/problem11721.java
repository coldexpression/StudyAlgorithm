package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class problem11721 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<input.length();i++) {
            if (i > 0 && i % 10 == 0) sb.append("\n");
            sb.append(input.charAt(i));
        }
        System.out.print(sb);
    }
}
