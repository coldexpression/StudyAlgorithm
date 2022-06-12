package Backjoon;

import java.util.Scanner;

public class problem1654 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        long answer = 0;
        long max = 0;
        long min = 1;

        long[] line = new long[k];

        for(int i=0;i<k;i++) {
            int input = sc.nextInt();
            line[i] = input;
            max = Math.max(max, line[i]);
        }

        long middle = 0;

        while(true) {
            middle = (max+min) / 2;
            if (min > max) break;

            int count = 0;
            for(int i=0;i<k;i++) {
                count += line[i] / middle;
            }

            if (count < n) {
                max = middle - 1;
            } else {
                answer = middle;
                min = middle + 1;
            }

        }

        System.out.println(answer);
    }
}
