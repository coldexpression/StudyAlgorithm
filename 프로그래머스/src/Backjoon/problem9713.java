package Backjoon;

import java.util.Scanner;

public class problem9713 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for(int i=0;i<t;i++) {
            int number = sc.nextInt();
            int n = 0;
            for(int j=1;j<=number;j+=2) n += j;
            sb.append(n).append("\n");
        }
        System.out.print(sb);
    }
}
