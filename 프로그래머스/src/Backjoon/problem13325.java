package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class problem13325 {
    static int ans;
    static Queue<Integer> newQueue;

    public static class Tree {
        private Node root;

        public Tree(Node root) { this.root = root; }
    }

    public static class Node {
        private int weight;
        private int totalWeight;
        private int index;
        private Node leftChild;
        private Node rightChild;

        public Node(int weight, int totalWeight, int index, Node leftChild, Node rightChild) {
            this.weight = weight;
            this.totalWeight = totalWeight;
            this.index = index;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }

        public void setLeftChild(Node leftChild) {
            this.leftChild = leftChild;
        }

        public void setRightChild(Node rightChild) {
            this.rightChild = rightChild;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(bf.readLine());

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int maxSize = st.countTokens();
        int[] arr = new int[maxSize];

        for(int i=0;i<arr.length;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            ans += arr[i];
        }
        int index = 0;

        Tree tree = new Tree(new Node(0, 0, 0, null, null));

        Node node = tree.root;
        Queue<Node> queue = new LinkedList<>();

        queue.add(node);

        while(!queue.isEmpty()) {
            node = queue.poll();

            int leftWeight = arr[index];
            int rightWeight = arr[index+1];

            Node leftNode = new Node(leftWeight, node.totalWeight + leftWeight, index, null, null);
            Node rightNode = new Node(rightWeight, node.totalWeight + rightWeight, index + 1, null, null);

            node.setLeftChild(leftNode);
            node.setRightChild(rightNode);

            queue.add(leftNode);
            queue.add(rightNode);

            index = index + 2;
            if (index == maxSize) break;
        }

        newQueue = new LinkedList<>();

        findLeafNode(tree.root);

        while(!newQueue.isEmpty()) {
            if (newQueue.size() == 1) break;
            int front = newQueue.poll();
            int rear = newQueue.poll();

            ans += Math.abs(front - rear);
            newQueue.add(Math.max(front, rear));
        }

        System.out.println(ans);
    }

    // +2 +2 +2
    public static void findLeafNode(Node node){
        if (node.leftChild == null && node.rightChild == null) {
            newQueue.add(node.totalWeight);
            return;
        }

        findLeafNode(node.leftChild);
        findLeafNode(node.rightChild);
    }
}