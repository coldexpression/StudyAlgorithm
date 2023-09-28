package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class problem10987 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        char[] input = bf.readLine().toLowerCase().toCharArray();
        int count = 0;
        for (char c : input) count = c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ? count + 1 : count;
        System.out.println(count);
    }
}
