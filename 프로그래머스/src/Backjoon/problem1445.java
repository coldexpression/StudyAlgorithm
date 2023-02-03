package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class problem1445 {

    public static class Node {

        private int row;
        private int col;
        private int junkCount;
        private int junkAreaCount;

        public Node(int row, int col, int junkCount, int junkAreaCount) {
            this.row = row;
            this.col = col;
            this.junkCount = junkCount;
            this.junkAreaCount = junkAreaCount;
        }

        public void setJunkAreaCount(int junkAreaCount) {
            this.junkAreaCount = junkAreaCount;
        };

        public void setJunkCount(int junkCount) {
            this.junkCount = junkCount;
        }

        @Override
        public String toString() {
            return "Node [row=" + row + ", col=" + col + ", junkCount=" + junkCount
                    + ", junkAreaCount=" + junkAreaCount + "]";
        };

    }

    static int[] moveRow = { -1, 1, 0, 0 };
    static int[] moveCol = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine();
        String[] word = input.split(" ");

        int n = Integer.parseInt(word[0]);
        int m = Integer.parseInt(word[1]);

        char[][] map = new char[n][m];
        boolean[][] visited = new boolean[n][m];
        int[] answer = new int[2];

        int stRow = 0;
        int stCol = 0;
        int edRow = 0;
        int edCol = 0;

        Node[][] nodeBoard = new Node[n][m];

        for (int i = 0; i < n; i++) {
            input = bf.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = input.charAt(j);
                nodeBoard[i][j] = new Node(i, j,  2500, 2500);
                if (map[i][j] == 'S') {
                    stRow = i;
                    stCol = j;
                } else if (map[i][j] == 'F') {
                    edRow = i;
                    edCol = j;
                }
            }
        }

        nodeBoard[edRow][edCol].setJunkCount(Integer.MAX_VALUE);
        nodeBoard[edRow][edCol].setJunkAreaCount(Integer.MAX_VALUE);

        PriorityQueue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {

                // TODO Auto-generated method stub
                if (o1.junkCount == o2.junkCount) {

                    return o1.junkAreaCount - o2.junkAreaCount;
                }
                return o1.junkCount - o2.junkCount;
            }
        });

        Node initNode = nodeBoard[stRow][stCol];
        initNode.setJunkCount(0);
        initNode.setJunkAreaCount(0);
        queue.add(nodeBoard[stRow][stCol]);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.println("현재 좌표 : [" + node.row + ", " + node.col + "]");
            System.out.println("현재 정보 : [쓰레기장 : " + node.junkCount + ", 쓰레기장 근처 : " + node.junkAreaCount + "]");

//            visited[node.row][node.col] = true;

            for (int i = 0; i < 4; i++) {
                int nRow = node.row + moveRow[i];
                int nCol = node.col + moveCol[i];

                if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m) {
                    Node nextNode = nodeBoard[nRow][nCol];
                    int newJunkCount = map[nRow][nCol] == 'g' ? node.junkCount + 1 : node.junkCount;
                    int newJunkAreaCount = countOfAroundJunk(map, nRow, nCol)
                            ? map[nRow][nCol] == 'F' ? node.junkAreaCount : node.junkAreaCount + 1
                            : node.junkAreaCount;

                    if (!visited[nRow][nCol]) {
                        visited[nRow][nCol] = true;
                        if (nextNode.junkCount > newJunkCount) {
                            nextNode.setJunkCount(newJunkCount);
                            nextNode.setJunkAreaCount(newJunkAreaCount);
                        } else if (nextNode.junkCount == newJunkCount) {
                            nextNode.setJunkAreaCount(Math.min(nextNode.junkAreaCount, newJunkAreaCount));
                        }
                        System.out.println("추가 예정 좌표 : [" + nRow + ", " + nCol + "] / 쓰레기 장 : [" + nextNode.junkCount
                                + "] 쓰레기장 근처 : [" + nextNode.junkAreaCount + "]");
                        if (nextNode.row == edRow && nextNode.col == edCol) break;

                        queue.add(nextNode);
                    } else {
                        if (nextNode.junkCount > newJunkCount) {
                            nextNode.setJunkCount(newJunkCount);
                            nextNode.setJunkAreaCount(newJunkAreaCount);
                        } else if (nextNode.junkCount == newJunkCount) {
                            nextNode.setJunkAreaCount(Math.min(nextNode.junkAreaCount, newJunkAreaCount));
                        }

                        if (nextNode.row == edRow && nextNode.col == edCol) break;
                    }
                }
            }
        }

        System.out.println("전체 노드 출력");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(nodeBoard[i][j].toString());
            }
            System.out.println();
        }
        System.out.println("출력 종료");

        System.out.println(nodeBoard[edRow][edCol].junkCount + " " + nodeBoard[edRow][edCol].junkAreaCount);
    }

    public static boolean countOfAroundJunk(char[][] map, int row, int col) {
        int n = map.length;
        int m = map[0].length;

        if (map[row][col] == 'g')
            return false;

//		System.out.println("검사 좌표 [" + row + ", " + col + "]" );

        for (int i = 0; i < 4; i++) {
            int nRow = row + moveRow[i];
            int nCol = col + moveCol[i];

            if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m) {
//				System.out.println("["+nRow+","+nCol+"] => " + map[nRow][nCol]);
                if (map[nRow][nCol] == 'g')
                    return true;
            }
        }

//		System.out.println("실패");
        return false;
    }

}