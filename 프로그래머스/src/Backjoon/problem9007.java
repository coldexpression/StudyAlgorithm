package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.StringTokenizer;

public class problem9007 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(bf.readLine());
            int k = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int ans = 0;
            boolean check = false;

            int[][] arr = new int[4][n];
            int[][] board = new int[2][n * n];
            int[] upArr = new int[n * n];
            int[] downArr = new int[n * n];
            int idx = 0;

            for (int i = 0; i < 4; i++) {
                st = new StringTokenizer(bf.readLine());
                for (int j = 0; j < n; j++) {
                    int input = Integer.parseInt(st.nextToken());
                    arr[i][j] = input;
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    upArr[idx] = arr[0][i] + arr[1][j];
                    downArr[idx] = arr[2][i] + arr[3][j];
                    idx++;
                }
            }

            Arrays.sort(upArr);
            Arrays.sort(downArr);
            int minNum = Integer.MAX_VALUE;
            int minAns = 0;
            int maxNum = Integer.MIN_VALUE;
            int maxAns = 0;

            for (int i = 0; i < upArr.length; i++) {
                if (check)
                    break;
                int pivot = upArr[i];

                int left = 0;
                int right = (n * n) - 1;
                int middle = 0;
                int weight = 0;

                while (left <= right) {
                    middle = (left + right) / 2;
                    weight = pivot + downArr[middle];

                    if (weight < k) {
                        if (weight - k > maxNum) {
                            maxNum = weight - k;
                            maxAns = weight;
                        }
                        left = middle + 1;
                    } else if (weight > k) {
                        if (weight - k < minNum) {
                            minNum = weight - k;
                            minAns = weight;
                        }
                        right = middle - 1;
                    } else {
                        check = true;
                        break;
                    }
                }
            }

            if (maxNum == Integer.MIN_VALUE) {
                ans = minAns;
            } else if (minNum == Integer.MAX_VALUE) {
                ans = maxAns;
            } else if (minNum > Math.abs(maxNum)) {
                ans = maxAns;
            } else if (minNum < Math.abs(maxNum)) {
                ans = minAns;
            } else {
                ans = Math.min(maxAns, minAns);
            }
            sb.append(check ? k : ans).append("\n");
        }

        System.out.println(sb);
    }
}