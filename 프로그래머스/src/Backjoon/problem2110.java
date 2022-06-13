package Backjoon;

import java.util.*;

public class problem2110 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int c = sc.nextInt();

        int[] home = new int[n];
        for (int i = 0; i < n; i++) home[i] = sc.nextInt();
        Arrays.sort(home);
        int start = 0;
        int end = n - 1;
        int minDst = 0;
        int answer = home[end] - home[start];
        int minDstIndex = -1;
        c = c - 2;

            while (true) {
                minDst = home[end] - home[start];
                if (c == 0) break;
                System.out.println("시작 인덱스 : " + start);
                System.out.println("종료 인덱스 : " + end);
                System.out.println("중간 인덱스 : " + minDstIndex);

                for (int i = start; i <= end; i++) {
                    int dst = Math.abs((home[start] + home[end]) / 2 - home[i]);
                    if (minDst >= dst) {
                        minDst = dst;
                        minDstIndex = i;
                    } else {
                        break;
                    }
                }


                if (minDstIndex != -1) {
                    if (home[minDstIndex] - home[start] >= home[end] - home[minDstIndex]) {
                        answer = home[end] - home[minDstIndex];
                        end = minDstIndex;
                    } else {
                        answer = home[minDstIndex] - home[start];
                        start = minDstIndex;
                    }
                    c--;

                }
            }
        System.out.println(answer);
    }
}
