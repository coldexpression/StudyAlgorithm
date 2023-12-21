package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class problem22966 {
    static class Node {
        private String name;
        private int val;

        public Node(String name, int val) {
            this.name = name;
            this.val = val;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        Node[] nodes = new Node[n];
        for(int i=0;i<n;i++) {
            st = new StringTokenizer(bf.readLine());
            String input = st.nextToken();
            int val = Integer.parseInt(st.nextToken());
            nodes[i] = new Node(input, val);
        }
        Arrays.sort(nodes, (o1, o2) -> o1.val - o2.val);
        System.out.print(nodes[0].name);
    }
}
