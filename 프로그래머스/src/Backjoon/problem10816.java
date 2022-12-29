package Backjoon;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class problem10816 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] store = new int[20000001];

        for(int i=0;i<N;i++) {
            int num = sc.nextInt();

            if (num > 0) {
                store[num+10000000]++;
            } else {
                store[Math.abs(num)]++;
            }
        }

        int M = sc.nextInt();

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<M;i++) {
            int num = sc.nextInt();

            if (num > 0) {
                sb.append(store[num+10000000]).append(" ");
            } else {
                sb.append(store[Math.abs(num)]).append(" ");
            }
        }

        System.out.println(sb.toString());
    }
}
