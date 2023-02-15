package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class problem2629 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine();
        String[] word = input.split(" ");
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(word[0]);

        input = bf.readLine();
        word = input.split(" ");

        int[] info = new int[n + 1];

        for (int i = 0; i < word.length; i++)
            info[i + 1] = Integer.parseInt(word[i]);

        int k = Integer.parseInt(bf.readLine());

        int[] weight = new int[k];

        int sum = Arrays.stream(info).sum();

        int[][] dp = new int[n + 1][sum + 1];

        input = bf.readLine();
        word = input.split(" ");

        for (int i = 0; i < word.length; i++)
            weight[i] = Integer.parseInt(word[i]);

        for(int i=1;i<info.length;i++) {
            search(dp, info, info[i], i, 1, n, 0);
        }

        for (int w : weight) {
            if (sum < w) {
                sb.append('N').append(" ");
            } else {
                sb.append(dp[info.length - 1][w] == 1 ? 'Y' : 'N').append(" ");
            }
        }

        print(dp);

        System.out.println(sb);
    }

    public static void print(int[][] dp) {
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }


    public static void search(int[][] dp, int[] info, int sum, int index, int count, int n, int prevSum) {
        if (count == (n + 1))
            return;

        dp[index][sum] = 1;

        System.out.println("index : " + index);
        print(dp);
        System.out.println("=================");

        if (index + 1 < info.length) {
            // 추를 오른쪽에 올릴 수 있는 경우
            if (sum + info[index + 1] > 0) {
//                dp[index + 1][info[index]] = 1;
                if (dp[index + 1][sum + info[index + 1]] != 1)
                    search(dp, info, sum + info[index + 1], index + 1, count + 1, n, sum);
            }

            // 추를 올리지 않고 다음 추로 넘어가는 경우
//            dp[index + 1][info[index]] = 1;
            if (dp[index + 1][Math.abs(sum - info[index + 1])] != 1)
                search(dp, info, Math.abs(sum - info[index + 1]), index + 1, count + 1, n, sum);
            if (dp[index + 1][sum] != 1)
                search(dp, info, sum, index + 1, count + 1, n, sum);


            System.out.println("=================");
            print(dp);
            System.out.println("=================");
        }
    }

}
