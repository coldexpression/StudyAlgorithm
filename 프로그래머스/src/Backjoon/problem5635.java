package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class problem5635 {
    static class Node {
        private String name;
        private int year;
        private int month;
        private int day;

        public Node(String name, int year, int month, int day) {
            this.name = name;
            this.year = year;
            this.month = month;
            this.day = day;
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        Node[] nodes = new Node[n];
        for(int i=0;i<n;i++) {
            st = new StringTokenizer(bf.readLine());
            String name = st.nextToken();
            int day = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken());
            int year = Integer.parseInt(st.nextToken());
            nodes[i] = new Node(name, year, month, day);
        }

        Arrays.sort(nodes, (o1, o2) -> {
            if (o1.year == o2.year) {
                if (o1.month == o2.month) return o1.day - o2.day;
                return o1.month - o2.month;
            }
            return o1.year - o2.year;
        });

        System.out.println(nodes[n-1].name);
        System.out.println(nodes[0].name);
    }
}
