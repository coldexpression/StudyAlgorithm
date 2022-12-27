package Backjoon;

import java.util.Scanner;

public class problem1676 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int zeroCount = 0;

        int num = 1;

        for(int i=1;i<=N;i++) {
            if ((num * i) / 100 >= 1) {
                num *= i;
                String word = String.valueOf(num);
                for(int j=word.length()-1;j>=0;j--) {
                    zeroCount = word.charAt(j) == '0' ? zeroCount + 1 : zeroCount;

                    if (word.charAt(j) != '0') break;
                }

                System.out.println(word);
                StringBuilder sb = new StringBuilder();

                for(int j=word.length()-1;j>=0;j--) {
                    if (word.charAt(j) != '0') sb.append(word.charAt(j));

                    if (sb.length() == (zeroCount+1)) break;
                }
                num = Integer.parseInt(sb.reverse().toString());
            } else {
                num *= i;
            }
        }

        System.out.println(zeroCount);
    }
}
