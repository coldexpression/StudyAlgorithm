package Backjoon;

import java.util.Scanner;

public class problem23348 {

    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int N = sc.nextInt();

        int win = 0;
        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = 0; j < 3; j++) { // 개인 점수 더하기
                int x = sc.nextInt();
                int y = sc.nextInt();
                int z = sc.nextInt();
                sum += x * a + y * b + z * c;
            }
            if (win < sum) {
                win = sum;
            }
        }
        System.out.print(win);
    }
}
