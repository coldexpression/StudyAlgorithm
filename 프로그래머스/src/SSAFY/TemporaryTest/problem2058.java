package SSAFY.TemporaryTest;

import java.util.Scanner;

public class problem2058 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int ans = 0;
        int num = 3;

        while(num >= 0) {
            ans += N / Math.pow(10, num);
            N = (int) (N % Math.pow(10, num));
            num--;
        }

        System.out.println(ans);
    }
}
