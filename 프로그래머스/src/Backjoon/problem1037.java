package Backjoon;

import java.util.Arrays;
import java.util.Scanner;

public class problem1037 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] store = new int[N];

        for(int i=0;i<N;i++) store[i] = sc.nextInt();

        int min = Arrays.stream(store).min().getAsInt();
        int max = Arrays.stream(store).max().getAsInt();

        System.out.println(min*max);
    }
}
