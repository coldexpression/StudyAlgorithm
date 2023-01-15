package Backjoon;

import java.util.Scanner;

public class problem17945 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int b = sc.nextInt();
        int c = sc.nextInt();

        b *= 2;

        int n1 = (int) ((-b + Math.sqrt(Math.pow(b,2) - (4*c))) / 2);
        int n2 = (int) ((-b - Math.sqrt(Math.pow(b,2) - (4*c))) / 2);

        if (n1 == n2) System.out.println(n1);
        else {
            if (n1 > n2) System.out.println(n2 + " " + n1);
            else System.out.println(n1 + " " + n2);
        }

    }
}
