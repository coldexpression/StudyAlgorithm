package Level3;

import java.util.*;

public class problem42892 {

    static List<Integer> prev;
    static List<Integer> back;

    public static void main(String[] args) {
        problem42892 problem42892 = new problem42892();
        problem42892.solution(new int[][]{{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}});
    }

    public int[][] solution(int[][] nodeinfo) {
        int[][] answer = {};
        Node graph;
        prev = new ArrayList<>();
        back = new ArrayList<>();
        List<Node> nodeList = new ArrayList<>();
        for(int i=0;i<nodeinfo.length;i++) {
            Node node;
            if (i != 0) {
                node = new Node(i, nodeinfo[i]);
            } else {
                node = new Node(i, nodeinfo[i]);
            }
            nodeList.add(node);
        }

        Collections.sort(nodeList, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                int[] pos1 = o1.pos;
                int[] pos2 = o2.pos;
                if(pos1[1] == pos2[1]) return pos1[0] - pos2[0];
                return pos2[1] - pos1[1];
            }
        });


        graph = new Node(nodeList.get(0).index, nodeList.get(0).pos);

        for(int i=1;i<nodeList.size();i++) {
            installEdge(graph, nodeList.get(i).index, nodeList.get(i).pos);
        }

        findNode(graph);

        answer = new int[2][nodeList.size()];
        answer[0] = prev.stream().mapToInt(i -> i).toArray();
        answer[1] = back.stream().mapToInt(i -> i).toArray();
        return answer;
    }

    private void nodePrevPrint(Node node) {
        if (node == null) return;

        System.out.println("노드 : " + node.index);
        prev.add(node.index + 1);
        nodePrevPrint(node.leftChild);
        nodePrevPrint(node.rightChild);
    }

    private void nodeBackPrint(Node node) {
        if (node == null) return;

        nodeBackPrint(node.leftChild);
        nodeBackPrint(node.rightChild);
        back.add(node.index + 1);
        System.out.println("노드 : " + node.index);
    }

    private void findNode(Node node) {
        if (node == null) return;

        prev.add(node.index + 1);
        findNode(node.leftChild);
        findNode(node.rightChild);
        back.add(node.index + 1);
    }

    private void installEdge(Node graph, int nodeIndex, int[] nodePos) {
        if (graph.pos[0] > nodePos[0]) {
            installLeftEdge(graph, nodeIndex, nodePos);
        } else if (graph.pos[0] < nodePos[0]) {
            installRightEdge(graph, nodeIndex, nodePos);
        }
    }

    private void installLeftEdge(Node graph, int nodeIndex, int[] nodePos) {
        if (graph.leftChild == null) graph.setLeftChild(new Node(nodeIndex, nodePos));
        else installEdge(graph.leftChild, nodeIndex, nodePos);
    }

    private void installRightEdge(Node graph, int nodeIndex, int[] nodePos) {
        if (graph.rightChild == null) graph.setRightChild(new Node(nodeIndex, nodePos));
        else installEdge(graph.rightChild, nodeIndex, nodePos);
    }

    private void printf(int[][] nodeinfo) {
        for (int[] ints : nodeinfo) {
            for(int i=0;i<ints.length;i++){
                System.out.print(ints[i] +" ");
            }
            System.out.println();
        }
    }

    public class Node {
        private int index;
        private int[] pos;
        private int parentX;
        private Node leftChild;
        private Node rightChild;

        public Node(int index, int[] pos) {
            this.index = index;
            this.pos = pos;
        }

        public Node(int index, int[] pos, int parentX) {
            this.index = index;
            this.pos = pos;
            this.parentX = parentX;
        }

        public void setLeftChild(Node node) {
            this.leftChild = node;
        }

        public void setRightChild(Node node) {
            this.rightChild = node;
        }
    }
}
