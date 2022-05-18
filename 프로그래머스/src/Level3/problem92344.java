package Level3;


import java.util.Comparator;
import java.util.PriorityQueue;

public class problem92344 {

    public static void main(String[] args) {
        problem92344 problem92344 = new problem92344();
        problem92344.solution(new int[][]{{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5}}, new int[][]{{1,0,0,3,4,4},{1,2,0,2,3,2},{2,1,0,3,1,2},{1,0,1,3,3,1}});
    }

    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int m = board.length;
        int n = board[0].length;
        int index = 0;
        int start = -1;
        int end = -1;
        int degree = 0;
        int count = 0;
        int[] map = new int[m*n];
        PriorityQueue<startNode> startQueue = new PriorityQueue<>(new Comparator<startNode>() {
            @Override
            public int compare(startNode o1, startNode o2) {
                return o1.getStartIndex() - o2.getStartIndex();
            }
        });
        PriorityQueue<endNode> endQueue = new PriorityQueue<>(new Comparator<endNode>() {
            @Override
            public int compare(endNode o1, endNode o2) {
                return o1.getEndIndex() - o2.getEndIndex();
            }
        });

        for(int i=0;i<m;i++) {
            for (int j = 0; j < n; j++) {
                map[index++] = board[i][j];
            }
        }
        index = 0;

        for (int[] ints : skill) {
            int type = ints[0];
            int value = type == 1 ? ints[5]*(-1) : ints[5];
            int startIndex = transPosition(ints[1], ints[2], n);
            int endIndex = transPosition(ints[3], ints[4], n);
            startNode startNode = new startNode(startIndex, value);
            endNode endNode = new endNode(endIndex, value*(-1));
            startQueue.add(startNode);
            endQueue.add(endNode);
            System.out.println("조건 startIndex : " + startIndex);
            System.out.println("조건 endIndex : " + endIndex);
        }

        for(int i=0;i<map.length;i++) {
            if (!startQueue.isEmpty()) {
                start = startQueue.peek().getStartIndex();
            }
            if (!endQueue.isEmpty()) {
                end = endQueue.peek().getEndIndex();
            }

            if (start == i) {
                while(true) {
                    startNode node = startQueue.poll();
                    degree += node.getValue();
                    if (startQueue.isEmpty() || startQueue.peek().getStartIndex() != i) break;
                }
            }

            if (end == i - 1) {
                while(true) {
                    endNode node = endQueue.poll();
                    degree += node.getValue();
                    if (endQueue.isEmpty() || endQueue.peek().getEndIndex() != i - 1) break;
                }
            }

            System.out.println("currentIndex : " + i);
            System.out.println("startIndex : " + start);
            System.out.println("endIndex : " + end);
            System.out.println("degree : " + degree);

            map[i] += degree;
            System.out.println(map[i]);
            count = map[i] > 0 ? count + 1 : count;

        }

        return count;
    }

    public int transPosition(int startRow, int startCol, int n) {
        return (startRow*n) + startCol;
    }

    public class startNode {
        private int startIndex;
        private int value;

        public startNode(int startIndex, int value) {
            this.startIndex = startIndex;
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public int getStartIndex() {
            return startIndex;
        }
    }

    public class endNode {
        private int endIndex;
        private int value;

        public endNode(int endIndex, int value) {
            this.endIndex = endIndex;
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public int getEndIndex() {
            return endIndex;
        }
    }
}
