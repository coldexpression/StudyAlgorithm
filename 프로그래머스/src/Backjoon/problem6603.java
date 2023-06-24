package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class problem6603 {
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        sb = new StringBuilder();

        while(true) {
            st = new StringTokenizer(bf.readLine());
            int k = Integer.parseInt(st.nextToken());
            if (k == 0) break;

            int[] arr = new int[k];
            for(int i=0;i<k;i++) arr[i] = Integer.parseInt(st.nextToken());
            perm(arr, new int[6], 0, 0);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void perm(int[] arr, int[] lotto, int index, int count) {
        if (count == 6) {
            Arrays.stream(lotto).forEach(x -> sb.append(x).append(" "));
            sb.append("\n");
            return;
        }

        for(int i=index;i<arr.length;i++) {
            lotto[count] = arr[i];
            perm(arr, lotto, i + 1, count + 1);
        }
    }
}
