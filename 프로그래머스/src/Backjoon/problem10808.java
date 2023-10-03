package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class problem10808 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = bf.readLine().toLowerCase();
        System.out.println((int)('b')-97);
        int[] alph = new int[26];
        for (char c : input.toCharArray()) alph[((int)c)-97]++;
        for(int i=0;i<26;i++) sb.append(alph[i]).append(" ");
        System.out.print(sb);
    }
}
