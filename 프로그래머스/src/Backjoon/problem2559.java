package Backjoon;

import java.util.*;

public class problem2559 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int answer = Integer.MIN_VALUE;
        int[] arr = new int[N+1];

        for(int i=1;i<=N;i++) {
            arr[i] = sc.nextInt();
        }

        for(int i=1;i<=N;i++) {
            arr[i] = arr[i-1] + arr[i];
            System.out.println("arr["+i+"] : " + arr[i]);
        }

        for(int i=K;i<=N;i++) {
            answer = Math.max(answer, arr[i] - arr[i-K]);
        }

        System.out.print("정답 : " + answer);
    }
}
