package Backjoon;

import java.util.Arrays;
import java.util.Scanner;

public class problem11399 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] peoples = new int[N];

        for(int i=0;i<N;i++) peoples[i] = sc.nextInt();

        Arrays.sort(peoples);

        int answer = 0;
        int[] sum = new int[N];

        for(int i=0;i<N;i++) {
            answer += peoples[i];
            sum[i] = answer;
        }

        System.out.println(Arrays.stream(sum).sum());
    }
}
