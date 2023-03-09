package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem1138 {
    static int[] board;
    static int[] arr;
    static boolean[] visited;
    static boolean check;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        arr = new int[n];
        visited = new boolean[n+1];
        board = new int[n];

        st = new StringTokenizer(bf.readLine());
        for(int i=0;i<arr.length;i++) arr[i] = Integer.parseInt(st.nextToken());

        perm(0, n);
        System.out.println(sb);
    }

    public static void perm(int count, int n) {
        if (check) return;;
        if (count == n) {
            int cnt = 0;
            for(int i=0;i<n;i++) {
                cnt = 0;
                for(int j=0;j<i;j++) {
                    if (board[i] < board[j]) cnt++;
                }
                if (arr[board[i] -1] != cnt) return;
            }

            check = true;
            for(int i=0;i<board.length;i++) sb.append(board[i]).append(" ");

            return;
        }

        for(int i=1;i<=n;i++) {
            if (!visited[i]) {
                visited[i] = true;
                board[count] = i;
                perm(count + 1, n);
                board[count] = 0;
                visited[i] = false;
            }
        }
    }
}
