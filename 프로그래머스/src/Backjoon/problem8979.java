package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class problem8979 {
    static class Node {
        private int country;
        private int gold;
        private int silver;
        private int bronze;
        public Node(int country, int gold, int silver, int bronze) {
            this.country = country;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "country=" + country +
                    ", gold=" + gold +
                    ", silver=" + silver +
                    ", bronze=" + bronze +
                    '}';
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.gold == o2.gold) {
                if (o2.silver == o1.silver) return o2.bronze - o1.bronze;
                return o2.silver - o1.silver;
            }
           return o2.gold - o1.gold;
        });
        for(int i=0;i<n;i++) {
            st = new StringTokenizer(bf.readLine());
            int country = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());
            pq.add(new Node(country, gold, silver, bronze));
        }
        int pGold = -1;
        int pSilver = -1;
        int pBronze = -1;
        int rank = 0;
        int count = -1;
        while(!pq.isEmpty()) {
            Node node = pq.poll();
            System.out.println(node);
            System.out.println("rank :" + rank ) ;
            System.out.println(pGold + " " + pSilver + " " + pBronze);
            count++;
            if (!(node.gold == pGold && node.silver == pSilver && node.bronze == pBronze)) {
                rank = count + 1;
                pGold = node.gold;
                pSilver = node.silver;
                pBronze = node.bronze;
            }
            if (node.country == k) break;
        }
        System.out.println(rank);
    }
}
