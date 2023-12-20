package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class problem23037 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        char[] words = bf.readLine().toCharArray();
        int num = 0;
        for (char word : words) num += (int) Math.pow(Character.getNumericValue(word), 5);
        System.out.print(num);
    }
}
