package Backjoon;

import java.util.*;

public class problem1002 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for(int i=0;i<T;i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int r1 = sc.nextInt();

            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            int r2 = sc.nextInt();

            double d = Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1));

            if (d == 0 && r1 == r2) System.out.println(-1);
            else if (d > r1 + r2 || d < Math.abs(r1 - r2)) System.out.println(0);
            else if (d == (r1 + r2) || d == Math.abs(r1 - r2)) System.out.println(1);
            else if (d < r1 + r2) System.out.println(2);

        }
    }
}
