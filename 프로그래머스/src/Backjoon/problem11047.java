package Backjoon;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class problem11047 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int answer = 0;

        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] coin = new int[N];

        for(int i=0;i<N;i++) coin[i] = sc.nextInt();

        for(int i=coin.length-1;i>=0;i--) {
            if (coin[i] <= K) {
                answer += K / coin[i];
                K -= (K / coin[i]) * coin[i];
            }
        }

        System.out.println(answer);
    }
}
