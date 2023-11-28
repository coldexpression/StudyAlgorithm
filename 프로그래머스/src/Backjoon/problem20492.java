package Backjoon;

import java.util.Scanner;

public class problem20492 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        sb.append((int)(n - (n*0.22))).append(" ");
        sb.append((int)(n*0.8 + n*0.156));
        System.out.print(sb);
    }
}
