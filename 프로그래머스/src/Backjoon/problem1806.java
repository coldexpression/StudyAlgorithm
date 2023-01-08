package Backjoon;

import java.util.Scanner;

public class problem1806 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ans = Integer.MAX_VALUE;

        int N = sc.nextInt();
        int S = sc.nextInt();

        int[] data = new int[N];

        for (int i = 0; i < N; i++) data[i] = sc.nextInt();

        int left = 0;
        int right = 0;

        int sum = data[left];

        if (sum >= S) System.out.println("1");
        else {
            while (true) {
                if (sum >= S) {
                    ans = Math.min(ans, right - left + 1);
                    sum -= data[left++];
                    if (left == right) {
                        if (data[left] >= S) ans = 1;
                        break;
                    }
                } else {
                    if (right >= (N-1)) break;
                    else sum += data[++right];
                }
            }

            System.out.println(ans == Integer.MAX_VALUE ? "0" : ans);
        }
    }
}
