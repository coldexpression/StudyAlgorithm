package Backjoon;

import java.util.Scanner;

/**
 * @author Chansik Seo
 */
public class problem4504 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        while(true) {
            int number = sc.nextInt();
            if (number == 0) break;
            sb.append(number).append(" is").append(number % n == 0 ? "" : " NOT").append(" a multiple of ").append(n).append(".\n");
        }
        System.out.print(sb);
    }
}
