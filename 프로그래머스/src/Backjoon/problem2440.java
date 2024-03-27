package Backjoon;

import java.io.BufferedReader;
import java.util.Scanner;

/**
 * @author Chansik Seo
 */
public class problem2440 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        while(n != 0) {
            for(int i=0;i<n;i++) sb.append("*");
            sb.append("\n");
            n--;
        }
        System.out.print(sb);
    }
}
