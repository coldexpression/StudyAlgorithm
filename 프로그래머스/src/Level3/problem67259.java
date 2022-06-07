package Level3;

import java.util.*;

public class problem67259 {

    static int[] directRow;
    static int[] directCol;

    public static void main(String[] args) {
        problem67259 problem67259 = new problem67259();
        problem67259.solution(new int[][]{{0,0,0,0,0,0},{0,1,1,1,1,0},{0,0,1,0,0,0},{1,0,0,1,0,1},{0,1,0,0,0,1},{0,0,0,0,0,0}});
    }

    public int solution(int[][] board) {
        Queue<int[]> queue = new LinkedList<>();
        int answer = Integer.MAX_VALUE;
        int n = board.length;
        int[][] visited = new int[n][n];
        directRow = new int[]{-1,1,0,0};
        directCol = new int[]{0,0,-1,1};

        // MODE : N(0) [중립 모드]
        // MODE : V(-1) [세로 모드]
        // MODE : H(1) [가로 모드]
        visited[0][0] = 0;
        queue.add(new int[]{0,0,0,0});

        while(!queue.isEmpty()) {
            int[] ele = queue.poll();
            int mode = ele[2];
            int initPrice = ele[3];
            System.out.println("현재 좌표 : [" + ele[0] + ", " + ele[1] + "]");
            System.out.println("현재 모드 : " + mode);
            System.out.println("현재 가격 : " + initPrice);

            if (ele[0] == n-1 && ele[1] == n-1) answer = Math.min(answer, initPrice);

            for(int i=0;i<4;i++) {
                int nextRow = ele[0] + directRow[i];
                int nextCol = ele[1] + directCol[i];
                int nextMode = 0;
                int price = initPrice;

                if (nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < n && board[nextRow][nextCol] == 0) {
                    if (visited[nextRow][nextCol] == 0) {
                        if (mode == 0) {
                            nextMode = directRow[i] != 0 ? -1 : 1;
                            price += 100;
                        } else if (mode == 1) {
                            nextMode = directRow[i] != 0 ? -1 : 1;
                            price = nextMode == -1 ? price + 500 : price;
                            price += 100;
                        } else if (mode == -1) {
                            nextMode = directCol[i] != 0 ? 1 : -1;
                            price = nextMode == 1 ? price + 500 : price;
                            price += 100;
                        }
                        queue.add(new int[]{nextRow, nextCol, nextMode, price});
                        visited[nextRow][nextCol] = price;
                    } else {
                        if (visited[nextRow][nextCol] > price) {
                            if (mode == 0) {
                                nextMode = directRow[i] != 0 ? -1 : 1;
                                price += 100;
                            } else if (mode == 1) {
                                nextMode = directRow[i] != 0 ? -1 : 1;
                                price = nextMode == -1 ? price + 500 : price;
                                price += 100;
                            } else if (mode == -1) {
                                nextMode = directCol[i] != 0 ? 1 : -1;
                                price = nextMode == 1 ? price + 500 : price;
                                price += 100;
                            }
                            queue.add(new int[]{nextRow, nextCol, nextMode, price});
                            visited[nextRow][nextCol] = price;
                        }

                    }
                }
            }

        }

        System.out.println(answer);

        return answer;
    }

}
