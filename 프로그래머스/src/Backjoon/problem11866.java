package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class problem11866 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int index = 0;

        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> ansQueue = new LinkedList<>();
        for(int i=1;i<=n;i++) queue.add(i);

        while(!queue.isEmpty()) {
            int num = queue.poll();
            index++;
            if (index == k) {
                index = 0;
                ansQueue.add(num);
            } else {
                queue.add(num);
            }
        }

        sb.append("<");
        while(!ansQueue.isEmpty()) {
            int num = ansQueue.poll();

            if (ansQueue.isEmpty()) {
                sb.append(num).append(">");
            } else {
                sb.append(num).append(", ");
            }
        }

        System.out.println(sb);
    }
}
