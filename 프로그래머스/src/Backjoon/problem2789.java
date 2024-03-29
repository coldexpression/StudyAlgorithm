package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class problem2789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] word = "CAMBRIDGE".toCharArray();
        String input = br.readLine();

        for (int i = 0; i < word.length; i++) {
            if (input.indexOf(word[i]) > -1) {
                input = input.replace(String.valueOf(word[i]), "");
            }
        }
        System.out.println(input);
    }
}