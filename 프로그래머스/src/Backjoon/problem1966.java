package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class problem1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();
        int test = Integer.parseInt(st.nextToken());
        for(int i=0;i<test;i++) {
            st = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int ans = 1;
            ArrayDeque<int[]> deque = new ArrayDeque<>();
            PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2-o1);
            st = new StringTokenizer(bf.readLine());
            for(int j=0;j<n;j++) {
                int val = Integer.parseInt(st.nextToken());
                queue.add(val);
                deque.addLast(new int[]{j, val});
            }

            int currentVal = queue.poll();
            while(!deque.isEmpty()) {
                int[] info = deque.pollFirst();
                if (currentVal == info[1]) {
                    if (info[0] == m) {
                        sb.append(ans).append("\n");
                        break;
                    }
                    if (queue.isEmpty()) break;
                    currentVal = queue.poll();
                    ans++;
                    continue;
                }
                deque.addLast(info);
            }
        }
        System.out.println(sb);
    }
}
