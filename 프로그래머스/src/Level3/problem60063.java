package Level3;

import java.util.*;

public class problem60063 {

    public static void main(String[] args) {
        problem60063 problem60063 = new problem60063();
//        problem60063.solution(new int[][]{{0,0,0,1,1},{0,0,0,1,0},{0,1,0,1,1},{1,1,0,0,1},{0,0,0,0,0}});
//        problem60063.solution(new int[][]{{0,0,1,1,0,0},{0,0,0,0,0,0},{0,1,0,0,0,0},{0,1,0,1,1,0},{0,0,0,1,1,0},{0,0,0,1,1,0}});
//        problem60063.solution(new int[][]{{0, 0, 0, 0, 1, 0},{0, 0, 1, 1, 1, 0},{0, 1, 1, 1, 1, 0},{0, 1, 0, 0, 1, 0},{0, 0, 1, 0, 0, 0},{0, 0, 0, 0, 0, 0}});
        problem60063.solution(new int[][]{{0, 0, 0, 0, 0, 0, 1},{1, 1, 1, 1, 0, 0, 1},{0, 0, 0, 0, 0, 0, 0},{0, 0, 1, 1, 1, 1, 0},{0, 1, 1, 1, 1, 1, 0},{0, 0, 0, 0, 0, 1, 1},{0, 0, 1, 0, 0, 0, 0}});
    }

    public int solution(int[][] board) {
        int answer = Integer.MAX_VALUE;
        PriorityQueue<Integer> box = new PriorityQueue<>();
        String currentPoint;
        int[][] checkBoard = new int[board.length][board[0].length];
        int maxRow = board.length;
        int maxCol = board[0].length;
        Queue<String> queue = new LinkedList<>();
        HashSet<String> set = new HashSet<>();

        currentPoint = 0+","+0+"/"+0+","+1+"/"+0;
        queue.add(currentPoint);

        for(int i=0;i< board.length;i++) {
            for(int j=0;j<board[i].length;j++) {
                checkBoard[i][j] = board[i][j] == 1 ? (-1) : board[i][j];
            }
        }

        while(!queue.isEmpty()) {
            String pick = queue.poll();
            String[] word = pick.split("/");
            String[] first = word[0].split(",");
            String[] second = word[1].split(",");
            int score = Integer.parseInt(word[2]);
            int row1 = Integer.parseInt(first[0]);
            int col1 = Integer.parseInt(first[1]);
            int row2 = Integer.parseInt(second[0]);
            int col2 = Integer.parseInt(second[1]);

            if (set.contains(row1 + "," + col1 + "/" + row2 + "," + col2) || set.contains(row2 + "," + col2 + "/" + row1 + "," + col1))
                continue;

            if ((row1 == maxRow - 1 && col1 == maxCol - 1) || (row2 == maxRow - 1 && col2 == maxCol - 1)) {
                box.add(score);
            }

            System.out.println(queue);

            if (row1 >= 0 && row2 >= 0 && row1 < maxRow && row2 < maxRow && col1 >= 0 && col2 >= 0 && col1 < maxCol && col2 < maxCol) {
                if (!(board[row1][col1] == -1 || board[row2][col2] == -1)) {

                    set.add(row1 + "," + col1 + "/" + row2 + "," + col2);

                    System.out.println("방문 순서 : [" + row1 + ", " + col1 + "] [" + row2 + ", " + col2 + "] : " + score);

                    if (row1 == row2 && (col1 + 1 == col2 || col2 + 1 == col1)) {
                        // 수평인 경우
                        if (row1 > 0 && row1 < maxRow - 1) {
                            // 왼쪽 축 기준으로, 왼쪽으로 90도 회전 == 오른쪽 축 기준으로, 오른쪽으로 90도 회전 == 위로 이동 가능
                            // 왼쪽 축 기준으로, 오른쪽으로 90도 회전 == 오른쪽 축 기준으로, 왼쪽으로 90도 회전 == 아래로 이동 가능
                            if (board[row1 - 1][col1] == 0 && board[row1 - 1][col2] == 0) {
                                queue.add(row1 + "," + col1 + "/" + (row2 - 1) + "," + col1 + "/" + (score + 1));
                                queue.add((row2 - 1) + "," + col1 + "/" + row1 + "," + col1 + "/" + (score + 1));
                                queue.add(row2 + "," + col2 + "/" + (row1 - 1) + "," + col2 + "/" + (score + 1));
                                queue.add((row1 - 1) + "," + col2 + "/" + row2 + "," + col2 + "/" + (score + 1));
                                queue.add((row1 - 1) + "," + col1 + "/" + (row2 - 1) + "," + col2 + "/" + (score + 1));
                                queue.add((row1 - 1) + "," + col2 + "/" + (row2 - 1) + "," + col1 + "/" + (score + 1));
                            }
                            if (board[row1 + 1][col1] == 0 && board[row1 + 1][col2] == 0) {
                                queue.add(row1 + "," + col1 + "/" + (row2 + 1) + "," + col1 + "/" + (score + 1));
                                queue.add((row2 + 1) + "," + col1 + "/" + row1 + "," + col1 + "/" + (score + 1));
                                queue.add(row2 + "," + col2 + "/" + (row1 + 1) + "," + col2 + "/" + (score + 1));
                                queue.add((row1 + 1) + "," + col2 + "/" + row2 + "," + col2 + "/" + (score + 1));
                                queue.add((row1 + 1) + "," + col1 + "/" + (row2 + 1) + "," + col2 + "/" + (score + 1));
                                queue.add((row1 + 1) + "," + col2 + "/" + (row2 + 1) + "," + col1 + "/" + (score + 1));
                            }
                        } else if (row1 == 0 && board[row1 + 1][col1] == 0 && board[row2 + 1][col2] == 0) {
                            queue.add(row1 + "," + col1 + "/" + (row2 + 1) + "," + col1 + "/" + (score + 1));
                            queue.add((row2 + 1) + "," + col1 + "/" + row1 + "," + col1 + "/" + (score + 1));
                            queue.add(row2 + "," + col2 + "/" + (row1 + 1) + "," + col2 + "/" + (score + 1));
                            queue.add((row1 + 1) + "," + col2 + "/" + row2 + "," + col2 + "/" + (score + 1));
                            queue.add((row1 + 1) + "," + col1 + "/" + (row2 + 1) + "," + col2 + "/" + (score + 1));
                            queue.add((row1 + 1) + "," + col2 + "/" + (row2 + 1) + "," + col1 + "/" + (score + 1));
                        } else if (row1 == maxRow - 1 && board[row1 - 1][col1] == 0 && board[row2 - 1][col2] == 0) {
                            queue.add(row1 + "," + col1 + "/" + (row2 - 1) + "," + col1 + "/" + (score + 1));
                            queue.add((row2 - 1) + "," + col1 + "/" + row1 + "," + col1 + "/" + (score + 1));
                            queue.add(row2 + "," + col2 + "/" + (row1 - 1) + "," + col2 + "/" + (score + 1));
                            queue.add((row1 - 1) + "," + col2 + "/" + row2 + "," + col2 + "/" + (score + 1));
                            queue.add((row1 - 1) + "," + col1 + "/" + (row2 - 1) + "," + col2 + "/" + (score + 1));
                            queue.add((row1 - 1) + "," + col2 + "/" + (row2 - 1) + "," + col1 + "/" + (score + 1));
                        }

                        if (col1 > 0 && col1 < maxCol - 1 && col2 > 0 && col2 < maxCol - 1) {
                            // 왼쪽 으로 이동 가능
                            // 오른쪽 으로 이동 가능
                            if (board[row1][col1 - 1] == 0 && board[row2][col2 - 1] == 0) {
                                queue.add(row1 + "," + (col1 - 1) + "/" + row2 + "," + (col2 - 1) + "/" + (score + 1));
                                queue.add(row1 + "," + (col2 - 1) + "/" + row2 + "," + (col1 - 1) + "/" + (score + 1));
                            }
                            if (board[row1][col1 + 1] == 0 && board[row2][col2 + 1] == 0) {
                                queue.add(row1 + "," + (col1 + 1) + "/" + row2 + "," + (col2 + 1) + "/" + (score + 1));
                                queue.add(row1 + "," + (col2 + 1) + "/" + row2 + "," + (col1 + 1) + "/" + (score + 1));
                            }
                        } else if (((col1 == 0 && col2 == col1 + 1) || (col2 == 0 && col1 == col2 + 1)) && board[row1][col2 + 1] == 0 && board[row2][col1 + 1] == 0) {
                            queue.add(row1 + "," + (col1 + 1) + "/" + row2 + "," + (col2 + 1) + "/" + (score + 1));
                            queue.add(row1 + "," + (col2 + 1) + "/" + row2 + "," + (col1 + 1) + "/" + (score + 1));
                        } else if (((col1 == col2 - 1 && col2 == maxCol - 1) || (col2 == col1 - 1 && col1 == maxCol - 1)) && board[row1][col1 - 1] == 0 && board[row2][col2 - 1] == 0) {
                            queue.add(row1 + "," + (col1 - 1) + "/" + row2 + "," + (col2 - 1) + "/" + (score + 1));
                            queue.add(row1 + "," + (col2 - 1) + "/" + row2 + "," + (col1 - 1) + "/" + (score + 1));
                        }

                    } else if (col1 == col2 && (row1 + 1 == row2 || row2 + 1 == row1)) {
                        // 수직인 경우
                        if (col1 > 0 && col1 < maxCol - 1) {
                            if (board[row1][col1 - 1] == 0 && board[row2][col2 - 1] == 0) {
                                queue.add((row1 + 1) + "," + (col1 - 1) + "/" + row2 + "," + col2 + "/" + (score + 1));
                                queue.add(row2 + "," + col2 + "/" + (row1 + 1) + "," + (col1 - 1) + "/" + (score + 1));
                                queue.add((row2 - 1) + "," + (col2 - 1) + "/" + row1 + "," + col1 + "/" + (score + 1));
                                queue.add(row1 + "," + col1 + "/" + (row2 - 1) + "," + (col2 - 1) + "/" + (score + 1));
                                queue.add(row1 + "," + (col1 - 1) + "/" + row2 + "," + (col2 - 1) + "/" + (score + 1));
                                queue.add(row2 + "," + (col2 - 1) + "/" + row1 + "," + (col1 - 1) + "/" + (score + 1));
                            }
                            if (board[row1][col1 + 1] == 0 && board[row2][col2 + 1] == 0) {
                                queue.add((row1 + 1) + "," + (col1 + 1) + "/" + row2 + "," + col2 + "/" + (score + 1));
                                queue.add(row2 + "," + col2 + "/" + (row1 + 1) + "," + (col1 + 1) + "/" + (score + 1));
                                queue.add((row2 - 1) + "," + (col2 + 1) + "/" + row1 + "," + col1 + "/" + (score + 1));
                                queue.add(row1 + "," + col1 + "/" + (row2 - 1) + "," + (col2 + 1) + "/" + (score + 1));
                                queue.add(row1 + "," + (col1 + 1) + "/" + row2 + "," + (col2 + 1) + "/" + (score + 1));
                                queue.add(row2 + "," + (col2 + 1) + "/" + row1 + "," + (col1 + 1) + "/" + (score + 1));
                            }
                        } else if (col1 == 0 && board[row1][col1 + 1] == 0 && board[row2][col2 + 1] == 0) {
                            queue.add((row1 + 1) + "," + (col1 + 1) + "/" + row2 + "," + col2 + "/" + (score + 1));
                            queue.add(row2 + "," + col2 + "/" + (row1 + 1) + "," + (col1 + 1) + "/" + (score + 1));
                            queue.add((row2 - 1) + "," + (col2 + 1) + "/" + row1 + "," + col1 + "/" + (score + 1));
                            queue.add(row1 + "," + col1 + "/" + (row2 - 1) + "," + (col2 + 1) + "/" + (score + 1));
                            queue.add(row1 + "," + (col1 + 1) + "/" + row2 + "," + (col2 + 1) + "/" + (score + 1));
                            queue.add(row2 + "," + (col2 + 1) + "/" + row1 + "," + (col1 + 1) + "/" + (score + 1));
                        } else if (col1 == maxCol - 1 && board[row1][col1 - 1] == 0 && board[row2][col2 - 1] == 0) {
                            queue.add((row1 + 1) + "," + (col1 - 1) + "/" + row2 + "," + col2 + "/" + (score + 1));
                            queue.add(row2 + "," + col2 + "/" + (row1 + 1) + "," + (col1 - 1) + "/" + (score + 1));
                            queue.add((row2 - 1) + "," + (col2 - 1) + "/" + row1 + "," + col1 + "/" + (score + 1));
                            queue.add(row1 + "," + col1 + "/" + (row2 - 1) + "," + (col2 - 1) + "/" + (score + 1));
                            queue.add(row1 + "," + (col1 - 1) + "/" + row2 + "," + (col2 - 1) + "/" + (score + 1));
                            queue.add(row2 + "," + (col2 - 1) + "/" + row1 + "," + (col1 - 1) + "/" + (score + 1));
                        }

                        if (row1 > 0 && row1 < maxRow - 1 && row2 > 0 && row2 < maxRow - 1) {
                            if (board[row1 - 1][col1] == 0 && board[row2 - 1][col2] == 0) {
                                queue.add((row1 - 1) + "," + col1 + "/" + (row2 - 1) + "," + col2 + "/" + (score + 1));
                                queue.add((row2 - 1) + "," + col2 + "/" + (row1 - 1) + "," + col1 + "/" + (score + 1));
                            }
                            if (board[row1 + 1][col1] == 0 && board[row2 + 1][col2] == 0) {
                                queue.add((row1 + 1) + "," + col1 + "/" + (row2 + 1) + "," + col2 + "/" + (score + 1));
                                queue.add((row2 + 1) + "," + col2 + "/" + (row1 + 1) + "," + col1 + "/" + (score + 1));
                            }
                        } else if (((row1 == 0 && row2 == row1 + 1) || (row2 == 0 && row1 == row2 + 1)) && board[row2 + 1][col2] == 0 && board[row1 + 1][col1] == 0) {
                            queue.add((row1 + 1) + "," + col1 + "/" + (row2 + 1) + "," + col2 + "/" + (score + 1));
                            queue.add((row2 + 1) + "," + col2 + "/" + (row1 + 1) + "," + col1 + "/" + (score + 1));
                        } else if (((row1 == row2 - 1 && row2 == maxRow - 1) || (row2 == row1 - 1 && row1 == maxRow - 1)) && board[row1 - 1][col1] == 0 && board[row2 - 1][col2] == 0) {
                            queue.add((row1 - 1) + "," + col1 + "/" + (row2 - 1) + "," + col2 + "/" + (score + 1));
                            queue.add((row2 - 1) + "," + col2 + "/" + (row1 - 1) + "," + col1 + "/" + (score + 1));
                        }

                    }
                }
            }
        }
        answer = box.isEmpty() ? 0 : box.poll();
        System.out.println(answer);
        return answer;
    }
}
