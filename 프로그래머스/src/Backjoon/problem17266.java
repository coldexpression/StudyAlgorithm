package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class problem17266 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(bf.readLine());
        st = new StringTokenizer(bf.readLine());
        int[] light = new int[m];
        for(int i=0;i<m;i++) light[i] = Integer.parseInt(st.nextToken());
        int left = 0;
        int right = 100001;
        int middle = 0;
        int answer= 0;

        while(true) {
            if (left >= right) break;
            middle = (left + right) / 2;

            if (isCheck(middle, light, n)) {
                answer = middle;
                right = middle;
            } else {
                left = middle + 1;
            }
        }
        System.out.println(answer);
    }

    public static boolean isCheck(int weight, int[] light, int n) {
        int tStart = Math.max(0, light[0] - weight);
        int tEnd = Math.min(n, light[0] + weight);

        if (tStart > 0) return false;

        for(int i=1;i<light.length;i++) {
            int start = light[i] - weight;
            int end = light[i] + weight;
            if (tEnd < start) return false;
            tEnd = end;
        }

        return tEnd >= n;
    }
}
