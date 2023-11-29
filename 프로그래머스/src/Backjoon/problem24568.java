package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class problem24568 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(bf.readLine());
        int b = Integer.parseInt(bf.readLine());
        System.out.println((a*8 + b*3)-28);
    }
}
