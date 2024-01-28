package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem1864 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true) {
            String input = bf.readLine();
            if (input.equals("#")) break;
            int mul = 0;
            long score = 0;
            for(int i=input.length()-1;i>=0;i--) score += (long) (Math.pow(8, mul++) * returnNumber(input.charAt(i)));
            sb.append(score).append("\n");
        }
        System.out.println(sb);
    }

    public static int returnNumber(char c) {
        switch (c) {
            case '-' : return 0;
            case '(' : return 2;
            case '@' : return 3;
            case '?' : return 4;
            case '>' : return 5;
            case '&' : return 6;
            case '%' : return 7;
            case '/' : return -1;
            default : return 1;
        }
    }
}
