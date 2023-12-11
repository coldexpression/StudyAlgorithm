package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class problem20499 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] words = bf.readLine().split("/");
        int k = Integer.parseInt(words[0]);
        int d = Integer.parseInt(words[1]);
        int a = Integer.parseInt(words[2]);
        System.out.println(k + a < d || d == 0? "hasu" : "gosu");
    }
}
