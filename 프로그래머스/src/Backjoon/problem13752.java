package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class problem13752 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(bf.readLine());
        for(int i=0;i<n;i++) {
            int number = Integer.parseInt(bf.readLine());
            while(number != 0) {
                sb.append("=");
                number--;
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
