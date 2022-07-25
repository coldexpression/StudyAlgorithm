package Backjoon;

import java.util.*;

public class problem2231 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int answer = Integer.MAX_VALUE;

        for(int i=2;i<=N;i++) {
            int sum = i;
            char[] word = String.valueOf(i).toCharArray();
            for (char c : word) {
                sum += Character.getNumericValue(c);
            }


            if (sum == N) answer = Math.min(answer, i);
        }

        answer = answer == Integer.MAX_VALUE ? 0 : answer;
        System.out.println(answer);
    }
}
