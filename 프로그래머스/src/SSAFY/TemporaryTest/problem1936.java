package SSAFY.TemporaryTest;

import java.util.Scanner;

public class problem1936 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int a = sc.nextInt();
        int b = sc.nextInt();

        if (a == 1) {
            if (b == 2) sb.append("B");
            else sb.append("A");
        } else if (a == 2) {
            if (b == 1) sb.append("A");
            else sb.append("B");
        } else {
            if (b == 1) sb.append("B");
            else sb.append("A");
        }

        System.out.println(sb.toString());
    }
}
