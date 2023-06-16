package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem10102 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String num = bf.readLine();
        String input = bf.readLine();
        int aCount = 0;
        int bCount = 0;
        for(int i=0;i<input.length();i++) {
            char word = input.charAt(i);
            if (word == 'A') aCount++;
            else bCount++;
        }
        System.out.println(aCount > bCount ? "A" : aCount < bCount ? "B" : "Tie");
    }
}
