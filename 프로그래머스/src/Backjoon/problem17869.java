package Backjoon;

import java.util.Scanner;

public class problem17869 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int count = 0;

        while (N != 1) {
            if (N % 2 == 0) {
                N = N / 2;
            } else {
                N = N + 1;
            }
            count++;
        }

        System.out.println(count);
    }
}
