package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem10988 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = bf.readLine();

        for(int i=input.length()-1;i>=0;i--) sb.append(input.charAt(i));

        System.out.println(input.equals(sb.toString()) ? 1 : 0);
    }
}
