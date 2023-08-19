package Backjoon;

import java.util.Scanner;

public class problem27433 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(fact(n));
    }

    public static long fact(long n) {
        if (n < 2) return 1;
        return n*fact(n-1);
    }
}
