package Backjoon;

import java.util.Scanner;

/**
 * @author Chansik Seo
 */
public class problem2441 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[][] chars = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                chars[i][j] = i > j ? ' ' : '*';
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++) sb.append(chars[i]).append("\n");
        System.out.print(sb);
    }
}
