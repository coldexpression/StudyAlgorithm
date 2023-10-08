package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class problem11365 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input;
        while(true) {
            input = bf.readLine();
            if (input.equals("END")) break;
            for(int i=input.length()-1;i>=0;i--) sb.append(input.charAt(i));
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
