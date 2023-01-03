package SSAFY.TemporaryTest;

import java.util.Scanner;

public class p1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<T;i++) {
            double ans = 0;

            for(int j=0;j<10;j++)
                ans += sc.nextDouble();

            sb.append("#").append(i+1).append(" ").append(Math.round(ans/10)).append("\n");
        }

        System.out.println(sb.toString());
    }
}
