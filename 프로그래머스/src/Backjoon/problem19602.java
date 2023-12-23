package Backjoon;

import java.util.Scanner;

public class problem19602 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int n = sc.nextInt();
        int l = sc.nextInt();
        System.out.print(s+2*n+3*l >= 10 ? "happy" : "sad");
    }
}
