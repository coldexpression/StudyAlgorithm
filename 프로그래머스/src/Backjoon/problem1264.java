package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem1264 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            String words = bf.readLine();
            if (words.equals("#")) break;
            String[] word = words.split(" ");
            int count = 0;
            for(String wd: word) {
                wd = wd.toLowerCase();
                char[] inputs = wd.toCharArray();
                for (char input : inputs)
                    if (input == 'a' || input == 'e' || input == 'i' || input == 'o' || input == 'u') count++;
            }
            sb.append(count).append("\n");
        }
        System.out.print(sb);
    }
}
