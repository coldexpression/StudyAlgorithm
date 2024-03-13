package Backjoon;

import java.util.Scanner;

public class problem19572 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double d1 = sc.nextInt();
        double d2 = sc.nextInt();
        double d3 = sc.nextInt();

        double a = (d1 + d2 + d3) / 2 - d3;
        double b = (d1 + d2 + d3) / 2 - d2;
        double c = (d1 + d2 + d3) / 2 - d1;

        if (a <= 0 || b <= 0 || c <= 0) {
            System.out.println(-1);
            return;
        } else {
            System.out.println(1);
        }

        System.out.println(a + " " + b + " " + c);
    }
}
