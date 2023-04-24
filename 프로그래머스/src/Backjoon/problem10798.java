package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class problem10798 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        char[][] map = new char[5][15];

        for(int i=0;i<5;i++) {
           String input = bf.readLine();
            for(int j=0;j<input.length();j++) {
                map[i][j] = input.charAt(j);
            }
        }

        for(int i=0;i<15;i++) {
            for(int j=0;j<5;j++) {
                if (map[j][i] != 0)
                    sb.append(map[j][i]);
            }
        }
        System.out.println(sb);
    }
}
