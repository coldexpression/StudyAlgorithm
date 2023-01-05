package Backjoon;

import java.util.Scanner;

public class problem1629 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        System.out.println(partition(A, B, C));
    }

    static long partition(int base, int pow, int mod) {
        if (pow == 1) return base % mod;

        long n1 = partition(base, pow / 2, mod);
        long n2 = 0;

        if (pow % 2 == 0) {
            return (n1*n1) % mod;
        } else {
            n2 = partition(base, (pow / 2) + 1, mod);
            return (n1*n2) % mod;
        }
    }
}
