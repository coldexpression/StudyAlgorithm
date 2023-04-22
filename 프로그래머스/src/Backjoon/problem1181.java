package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class problem1181 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(bf.readLine());
        PriorityQueue<String> queue = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                }
                return o1.length() - o2.length();
            }
        });

        for(int i=0;i<n;i++) queue.add(bf.readLine());

        String prev = "";

        while(!queue.isEmpty()) {
            String word = queue.poll();

            if (prev.equals(word)) continue;

            sb.append(word).append("\n");
            prev = word;
        }

        System.out.println(sb);
    }
}
