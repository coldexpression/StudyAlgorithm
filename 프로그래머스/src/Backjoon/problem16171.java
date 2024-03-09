package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Chansik Seo
 */
public class problem16171 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = bf.readLine();

        for(int i=0;i<input.length();i++) {
            if (input.charAt(i) >= '0' && input.charAt(i) <= '9') continue;
            sb.append(input.charAt(i));
        }
        input = sb.toString();
        String word = bf.readLine();
        System.out.println(!input.contains(word) ? 0 : 1);
    }
}
