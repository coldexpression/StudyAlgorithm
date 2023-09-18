package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class problem2744 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine();
        StringBuilder sb = new StringBuilder();
        for (char word : input.toCharArray()) sb.append(word >= 'a' && word <= 'z' ? (char)(word - 32) : (char)(word + 32));
        System.out.print(sb);
    }
}
