package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class problem20920 {
    static class Node {
        private int count ;
        private String word;

        public Node(int count, String word) {
            this.count = count;
            this.word = word;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();
        HashMap<String, Integer> map = new HashMap<>();
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.count == o2.count) {
                if (o2.word.length() == o1.word.length()) return o1.word.compareTo(o2.word);
                return o2.word.length() - o1.word.length();
            }
            return o2.count - o1.count;
        });

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for(int i=0;i<n;i++) {
            String input = bf.readLine();

            if (input.length() < m) continue;
            map.put(input, map.getOrDefault(input, 0) + 1);
        }

        for (String word : map.keySet()) pq.add(new Node(map.get(word), word));
        while(!pq.isEmpty()) sb.append(pq.poll().word).append("\n");
        System.out.print(sb);
    }
}
