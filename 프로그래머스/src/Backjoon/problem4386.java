package Backjoon;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class problem4386 {
    static int[] parents;
    static int n;

    public static class Node implements Comparable<Node>{
        private int from;
        private int to;
        private double weigth;
        public Node(int from, int to, double weight) {
            this.from = from;
            this.to = to;
            this.weigth = weight;
        }
        @Override
        public int compareTo(Node node) {
            return (int)this.weigth - (int)node.weigth;
        }
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Node> queue = new PriorityQueue<Node>();
        int edge = 0;
        double sum = 0;

        n = sc.nextInt();
        List<double[]> posList = new ArrayList<double[]>();
        for(int i=0;i<n;i++) {
            double r = sc.nextDouble();
            double c = sc.nextDouble();
            posList.add(new double[] {r,c});
        }

        makeSet();

        for(int from=0;from<posList.size();from++) {
            for(int to=from+1;to<posList.size();to++) {
                if (from != to) {
                    double[] fInfo = posList.get(from);
                    double[] tInfo = posList.get(to);
                    double dst = findDst(fInfo[0], fInfo[1], tInfo[0], tInfo[1]);
                    Node node = new Node(from, to, dst);
                    queue.add(node);
                }
            }
        }

        while(!queue.isEmpty()) {
            Node node = queue.poll();

            if (union(node.from, node.to)) {
                sum += node.weigth;
                edge++;
            }

            if (edge == n-1) break;
        }

        System.out.printf("%.2f", sum);
    }

    public static void makeSet() {
        parents = new int[n];
        for(int i=0;i<n;i++) parents[i] = i;
    }

    public static int find(int n) {
        if (n == parents[n]) return n;

        return parents[n] = find(parents[n]);
    }

    public static boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB) return false;

        parents[rootB] = rootA;
        return true;
    }

    public static double findDst(double r1, double c1, double r2, double c2) {
        return Math.sqrt((r1-r2)*(r1-r2) + (c1-c2)*(c1-c2));
    }

}