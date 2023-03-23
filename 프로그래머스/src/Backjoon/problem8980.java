package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class problem8980 {
    static int n;
    static int c;
    static int m;
    static int[] board;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());

        m = Integer.parseInt(st.nextToken());

        int ans = Integer.MIN_VALUE;
        int sum = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {

                if (o1[1] == o2[1]) {
                    if (o1[0] == o2[0])
                        return o1[2] - o2[2];
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            pq.add(new int[]{start - 1, end - 1, weight});
        }

        board = new int[n-1];
        Arrays.fill(board, c);

        while (!pq.isEmpty()) {
            int[] info = pq.poll();

            int s = info[0];
            int e = info[1];
            int val = info[2];

            if (isCheck(s, e, val)) {
                isFill(s, e, val);
                sum += val;
            } else {
                int min = findMin(s, e);
                if (min > 0) {
                    isFill(s, e, min);
                    pq.add(new int[]{s,e, val - min});
                    sum += min;
                }
            }

        }

        ans = Math.max(ans, sum);


        System.out.println(ans);
    }

    public static int findMin(int s, int e) {
        int min = Integer.MAX_VALUE;
        for (int i = s; i < e; i++) {
            min = Math.min(min, board[i]);
        }

        return min;
    }

    public static void isFill(int s, int e, int weight) {
        for (int i = s; i < e; i++) {
            board[i] -= weight;
        }
    }

    public static boolean isCheck(int s, int e, int weight) {

        for (int i = s; i < e; i++) {
            if (board[i] - weight < 0)
                return false;
        }

        return true;
    }

}