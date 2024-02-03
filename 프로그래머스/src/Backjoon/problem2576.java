package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @author Chansik Seo
 */
public class problem2576 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<7;i++) {
            int number = sc.nextInt();
            if (number % 2 == 1) {
                sum += number;
                min = Math.min(min, number);
            }
        }
        if (min == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(sum);
            System.out.println(min);
        }
    }
}
