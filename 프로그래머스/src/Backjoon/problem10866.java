package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class problem10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<n;i++) {
            st = new StringTokenizer(bf.readLine());
            String command = st.nextToken();
            if (command.equals("push_front")) {
                int num = Integer.parseInt(st.nextToken());
                deque.addFirst(num);
            } else if (command.equals("push_back")) {
                int num = Integer.parseInt(st.nextToken());
                deque.addLast(num);
            } else if (command.equals("front")) sb.append(deque.isEmpty() ? -1 : deque.peekFirst()).append("\n");
            else if (command.equals("back")) sb.append(deque.isEmpty() ? -1 : deque.peekLast()).append("\n");
            else if (command.equals("size")) sb.append(deque.size()).append("\n");
            else if (command.equals("empty")) sb.append(deque.isEmpty() ? 1 : 0).append("\n");
            else if (command.equals("pop_front")) sb.append(deque.isEmpty() ? -1 : deque.pollFirst()).append("\n");
            else sb.append(deque.isEmpty() ? -1 : deque.pollLast()).append("\n");
        }
        System.out.println(sb);
    }
}
