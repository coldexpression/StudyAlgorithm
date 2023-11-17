package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class problem2461 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        int[] indexes = new int[n];
        int answer = Integer.MAX_VALUE;

        for(int i=0;i<n;i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j=0;j<m;j++) arr[i][j] = Integer.parseInt(st.nextToken());
            Arrays.sort(arr[i]);
        }

        while(true) {
            if (answer == 0) break;
            int[] minInfo = findMinInfo(arr, indexes);
            int max = findMax(arr, indexes);
            answer = Math.min(answer, max - minInfo[0]);

            indexes[minInfo[1]] = minInfo[2] + 1;
            if (indexes[minInfo[1]] >= m) break;
        }
        System.out.println(answer);
    }

    public static int findMax(int[][] arr, int[] indexes) {
        int responseNum = 0;
        for (int i = 0; i < indexes.length; i++) {
            int index = indexes[i];
            responseNum = Math.max(responseNum, arr[i][index]);
        }
        return responseNum;
    }

    public static int[] findMinInfo(int[][] arr, int[] indexes) {
        int responseNum = Integer.MAX_VALUE;
        int spaceIndex = 0;
        int studentIndex = 0;
        for(int i=0;i<indexes.length;i++) {
            int index = indexes[i];
            if (arr[i][index] < responseNum) {
                responseNum = arr[i][index];
                spaceIndex = i;
                studentIndex = index;
            }
        }

        return new int[]{responseNum, spaceIndex, studentIndex};
    }
}
