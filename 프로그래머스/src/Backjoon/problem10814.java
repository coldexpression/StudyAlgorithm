package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class problem10814 {

    public static class Node {
        private int age;
        private int index;
        private String name;

        public Node(int age, int index, String name) {
            this.age = age;
            this.index = index;
            this.name = name;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());

        PriorityQueue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.age == o2.age) return o1.index - o2.index;
                return o1.age - o2.age;
            }
        });

        for(int i=0;i<n;i++) {
            st = new StringTokenizer(bf.readLine());

            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            queue.add(new Node(age, i, name));
        }

        while(!queue.isEmpty()) {
            Node node = queue.poll();

            System.out.println(node.age + " " + node.name);
        }

    }
}
