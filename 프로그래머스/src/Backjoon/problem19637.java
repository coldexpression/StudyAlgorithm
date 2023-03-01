package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class problem19637 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[] alpha = new String[n];
        String[] ans = new String[m];
        int[] arr = new int[n];

        for(int i=0;i<n;i++) {
            st = new StringTokenizer(bf.readLine());
            alpha[i] = st.nextToken();
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int cursor = 0;
        int num = 0;
        int[][] input = new int[m][2];
        for(int i=0;i<m;i++) {
            input[i][0] = Integer.parseInt(bf.readLine());
            input[i][1] = i;
        }

        Arrays.sort(input, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        for(int i=0;i<m;i++) {
            num = input[i][0];
            if (arr[cursor] >= num) ans[input[i][1]] = alpha[cursor];
            else {
                while(true) {
                    cursor++;
                    if (cursor == n) break;
                    if (arr[cursor] >= num) break;
                }
                i--;
            }
        }

        for (String an : ans) {
            sb.append(an).append("\n");
        }
        System.out.println(sb);
    }
}
