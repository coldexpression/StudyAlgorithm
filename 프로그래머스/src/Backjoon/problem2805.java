package Backjoon;

import java.util.Arrays;
import java.util.Scanner;

public class problem2805 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long answer = 0;
        int n = sc.nextInt();
        long m = sc.nextLong();

        long[] tree = new long[n];
        for(int i=0;i<n;i++) tree[i] = sc.nextLong();

        Arrays.sort(tree);

        long start = 1;
        long end = tree[n-1];
        long middle = 0;

        while(true) {
            long sum = 0;
            if (start > end) break;
            middle = (start + end) / 2;

            System.out.println("middle 값 : " + middle);
            for(int i=0;i<n;i++) {
                sum += Math.max(tree[i] - middle, 0);
            }

            if (sum >= m) {
                start = middle + 1;
                answer = Math.max(answer, middle);
            } else {
                end = middle - 1;
            }

        }

        System.out.println(answer);
    }
}
