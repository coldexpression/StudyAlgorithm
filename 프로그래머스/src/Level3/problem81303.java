package Level3;

import java.util.*;

public class problem81303 {

    public static void main(String[] args) {
        problem81303 problem81303 = new problem81303();
        problem81303.solution(8, 2, new String[]{"D 2","C","U 3","C","D 4","C","U 2","Z","Z"});
    }

    public String solution(int n, int k, String[] cmd) {
        String answer = "";
        HashMap<Integer, Node> board = new HashMap<>();
        Stack<Node> junk = new Stack<>();
        for(int i=0;i<n;i++) {
            Node node = new Node(i, i,false);
            board.put(i, node);
        }

        System.out.println("초기 노드 : " + board);

        for(String command: cmd) {
            System.out.println("현재 인덱스 >> " + k);
            if (command.equals("C")) {
                Node node = board.get(k);
                node.setIndex(k);
                System.out.println("삭제 인덱스 : " + k);
                boolean checker = false;
                junk.add(node);
                checker = k == board.size() - 1;
                board.remove(k);
                for(int i=k;i< board.size();i++) {
                    Node nextNode = board.get(i+1);
                    board.put(i, nextNode);
                }
                if (!checker) {
                    board.remove(board.size()-1);
                } else {
                    k = k -1;
                }
                System.out.println("삭제 후 노드 : " + board);
            } else if (command.equals("Z")) {
                Node node = junk.pop();
                int rollBackIndex = node.index;
                System.out.println("복구 인덱스 : " + rollBackIndex);
                for(int i=board.size()-1;i>=rollBackIndex;i--) {
                    Node nextNode = board.get(i);
                    board.put(i+1, nextNode);
                }
                board.put(rollBackIndex, node);
                System.out.println("되돌리기 후 노드 : " + board);
                k = k < rollBackIndex ? k : k + 1;
            } else {
                String direction = command.split(" ")[0];
                int distance = Integer.parseInt(command.split(" ")[1]);
                k = move(direction, k, distance);
            }
        }
        System.out.println(board);
        answer = check(board, junk, n);
        System.out.println(answer);
        return answer;
    }

    private String check(HashMap<Integer, Node> board, Stack<Node> junk, int n) {
        int[] checker = new int[n];
        System.out.println("현재 쓰레기 통 : " + junk);
        String answer = "";
        StringBuilder sb = new StringBuilder(answer);
        for (Node node : board.values()) {
            System.out.println("노드 인덱스 : " + node.originalIndex);
            checker[node.originalIndex] = 1;
        }

        while(!junk.isEmpty()) {
            Node node = junk.pop();
            checker[node.originalIndex] = -1;
        }

        for (int ele : checker) {
            if (ele == 1) {
                sb.append("O");
            } else {
                sb.append("X");
            }
        }
        answer = sb.toString();
        return answer;
    }

    private int move(String direction, int currentIndex, int distance) {
        if (direction.equals("U")) return currentIndex-distance;
        else return currentIndex+distance;
    }

    public class Node {
        private int index;
        private int originalIndex;
        private boolean delType;

        public Node(int index, int originalIndex, boolean delType) {
            this.index = index;
            this.originalIndex = originalIndex;
            this.delType = delType;
        }

        public void setDelType(boolean delType) {
            this.delType = delType;
        }

        public void setIndex(int index) {
            this.index = index;
        }
    }
}
