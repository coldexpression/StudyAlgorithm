package Backjoon;

import java.util.Scanner;

public class problem5691 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String[] str = sc.nextLine().split(" ");
            if (str[0].equals("0"))
                break;

            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);

            System.out.println(a - (b - a));
        }
        sc.close();
    }
}
