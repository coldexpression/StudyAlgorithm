package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class problem10953 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = bf.readLine();
        int t = Integer.parseInt(input);

        for(int i=0;i<t;i++) {
            input = bf.readLine();
            String[] split = input.split(",");
            int num = Integer.parseInt(split[0]) + Integer.parseInt(split[1]);
            sb.append(num).append("\n");
        }
        System.out.print(sb);
    }
}
