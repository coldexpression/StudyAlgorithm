package Level3;

import java.util.*;

public class problem72415 {

    static int[] moveRow = new int[]{-1,1,0,0};
    static int[] moveCol = new int[]{0,0,-1,1};

    public static void main(String[] args) {
        problem72415 problem72415 = new problem72415();
        problem72415.solution(new int[][]{{1,0,0,3},{2,0,0,0},{0,0,0,2},{3,0,1,0}},1, 0);
//        problem72415.solution(new int[][]{{3,0,0,2},{0,0,1,0},{0,1,0,0},{2,0,0,3}},0, 1);
    }

    public int solution(int[][] board, int r, int c) {
        int answer = Integer.MAX_VALUE;
        int[] initPosition = new int[]{r,c,0};
        Queue<Node> queue = new LinkedList<>();
        Queue<int[]> pickQueue = new LinkedList<>();
        boolean[][] visited = new boolean[board.length][board[0].length];
        int maxRow = board.length - 1;
        int maxCol = board[0].length - 1;
        int[] pickPosition;
        int count = 0;

        visited = initVisited(visited);

        Node node = new Node(initPosition, board);

        queue.add(node);

        while(!queue.isEmpty()) {
            Node currentNode = queue.poll();
            int[] currentPosition = currentNode.getPosition();
            int[][] currentBoard = currentNode.getBoard();
            visited = initVisited(visited);
            System.out.println("현재 위치 : [" + currentPosition[0] + ", " + currentPosition[1] + "] => " + currentPosition[2]);
            if (currentBoard[currentPosition[0]][currentPosition[1]] == 0) {
                System.out.println("컴?");
                Queue<Node> waitQueue = findAdjustPictureBlockByNoneBlock(currentPosition, maxRow, maxCol, currentBoard, visited);
//                pickPosition = findAdjustPictureBlockByNoneBlock(currentPosition, maxRow, maxCol, board, visited);
                queue.addAll(waitQueue);
                continue;
//                System.out.println("가까운 그림 : [" + pickPosition[0] + ", " + pickPosition[1] + "] => " + pickPosition[2]);
            } else {
                pickPosition = currentPosition.clone();
            }

            pickPosition[2] += 1;
            System.out.println("선택한 위치 : [" + pickPosition[0] + ", " + pickPosition[1] + "] => " + pickPosition[2]);
            visited = initVisited(visited);
            Node nextNode = findAdjustPictureBlockByBlock(pickPosition, currentBoard, visited);
            int[] nextPosition = nextNode.getPosition();
            int[][] nextBoard = nextNode.getBoard();
            System.out.println("다음 위치 : [" + nextPosition[0] + ", " + nextPosition[1] + "] => " + nextPosition[2]);
            if (nextPosition[2] != -1) {
                nextBoard[pickPosition[0]][pickPosition[1]] = 0;
                nextBoard[nextPosition[0]][nextPosition[1]] = 0;
                nextPosition[2] += 1;
                queue.add(new Node(nextPosition, nextBoard));
            }
//            count++;
            if (checker(nextBoard) == 0) {
                answer = Math.min(answer,nextPosition[2]);
//                break;
            }

//            if (count == 10) break;
        }



        System.out.println(queue);
        System.out.println(pickQueue);

        for (int[] ints : pickQueue) {
            System.out.println("["+ints[0]+", "+ints[1]+"] => " + ints[2]);
        }

        System.out.println(answer);

        return answer;
    }

    public int checker(int[][] board) {
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[i].length;j++) {
                if (board[i][j] != 0) return -1;
            }
        }
        return 0;
    }

    public boolean[][] initVisited(boolean[][] visited) {
        boolean[][] v = visited.clone();
        for(int i=0;i<visited.length;i++)
            Arrays.fill(v[i], false);
        return v;
    }

    public int[] colSearch(int[][] board, int startRow, int endRow, int col, int score) {
        int totalCount = 1;
        int count = 0;
        if (startRow < endRow) {
            for(int i=startRow+1;i<=endRow;i++) {
                if (board[i][col] == 0) count++;
                else count = totalCount++;
            }
            if (totalCount == 1 && count == endRow - startRow) count = 1;
        } else {
            for(int i=startRow-1;i>=endRow;i--) {
                if (board[i][col] == 0) count++;
                else count = totalCount++;
            }
            if (totalCount == 1 && count == startRow - endRow) count = 1;
        }
        System.out.println("col Search : " + count);
        return new int[]{endRow, col, score + count};
    }

    public int[] rowSearch(int[][] board, int startCol, int endCol, int row, int score) {
        int totalCount = 1;
        int count = 0;
        if (startCol < endCol) {
            for(int i=startCol+1;i<=endCol;i++) {
                if (board[row][i] == 0) count++;
                else count = totalCount++;
            }
            if (totalCount == 1 && count == endCol - startCol) count = 1;
        } else {
            for(int i=startCol-1;i>=endCol;i--) {
                if (board[row][i] == 0) count++;
                else count = totalCount++;
            }
            if (totalCount == 1 && count == startCol - endCol) count = 1;
        }
        System.out.println("row Search : " + count);
        return new int[]{row, endCol, score + count};
    }

    public Node findAdjustPictureBlockByBlock(int[] startPosition, int[][] board, boolean[][] visited) {
        Queue<Node> queue = new LinkedList<>();
        System.out.println("여기 : " + startPosition[2]);
        queue.add(new Node(new int[]{startPosition[0], startPosition[1], startPosition[2]}, board));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int[] pickPosition = node.getPosition();
            if (!(startPosition[0] == pickPosition[0] && startPosition[1] == pickPosition[1])) {
                if (board[pickPosition[0]][pickPosition[1]] == board[startPosition[0]][startPosition[1]]) {
                    int[] t1, t2, t1Result, t2Result;
                    if (pickPosition[0] != startPosition[0] && pickPosition[1] != startPosition[1]) {
                        t1 = colSearch(board, startPosition[0], pickPosition[0], startPosition[1], startPosition[2]);
                        t2 = rowSearch(board, startPosition[1], pickPosition[1], startPosition[0], startPosition[2]);
                        t1Result = rowSearch(board, t1[1], pickPosition[1], t1[0], t1[2]);
                        t2Result = colSearch(board, t2[0], pickPosition[0], t2[1], t2[2]);
                        if (t1Result[2] > t2Result[2]) return new Node(t2Result, board);
                        else return new Node(t1Result, board);
                    } else if (pickPosition[0] == startPosition[0]) {
                        return new Node(rowSearch(board, startPosition[1],pickPosition[1], startPosition[0], startPosition[2]), board);
                    } else {
                        return new Node(colSearch(board, startPosition[0], pickPosition[0], startPosition[1], startPosition[2]), board);
                    }

                }
            }

            for(int i=0;i<4;i++) {
                int nextRow = pickPosition[0] + moveRow[i];
                int nextCol = pickPosition[1] + moveCol[i];
                if (nextRow >= 0 && nextRow < board.length && nextCol >= 0 && nextCol < board[0].length) {
                    if (!visited[nextRow][nextCol]) {
                        visited[nextRow][nextCol] = true;
                        System.out.println("그림 있는 블럭 : ["+nextRow +", " + nextCol + "] => " + (pickPosition[2]+1));
                        queue.add(new Node(new int[]{nextRow, nextCol, pickPosition[2]+1}, board));
                    }
                }

            }
        }

        return new Node(new int[]{-1, -1, -1}, board);
    }

    public Queue<Node> findAdjustPictureBlockByNoneBlock(int[] startPosition, int maxRow, int maxCol, int[][] board, boolean[][] visited) {
        Queue<Node> queue = new LinkedList<>();
        Queue<Node> returnQueue = new LinkedList<>();
        queue.add(new Node(new int[]{startPosition[0], startPosition[1], startPosition[2]}, board));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int[] pickPosition = node.getPosition();
            if (board[pickPosition[0]][pickPosition[1]] != 0) {
                System.out.println(board[pickPosition[0]][pickPosition[1]]);
                if (startPosition[0] == pickPosition[0] || startPosition[1] == pickPosition[1]) {
                    returnQueue.add(new Node(new int[]{pickPosition[0], pickPosition[1], startPosition[2] + 1}, board));
                } else if (pickPosition[0] == maxRow || pickPosition[1] == maxCol){
                    int dst = 0;
                    if (pickPosition[0] == maxRow && pickPosition[1] == maxCol) dst = 2;
                    else if (pickPosition[0] == maxRow) dst = Math.abs(pickPosition[1] - startPosition[1]) + 1;
                    else dst = Math.abs(pickPosition[0] - startPosition[0]) + 1;
                    returnQueue.add(new Node(new int[]{pickPosition[0], pickPosition[1], startPosition[2] + dst + 1}, board));
                } else {
                    returnQueue.add(new Node(new int[]{pickPosition[0], pickPosition[1], startPosition[2] + Math.abs(startPosition[0]-pickPosition[0]) + 1}, board));
                }
            }

            for(int i=0;i<4;i++) {
                int nextRow = pickPosition[0] + moveRow[i];
                int nextCol = pickPosition[1] + moveCol[i];
                if (nextRow >= 0 && nextRow < board.length && nextCol >= 0 && nextCol < board[0].length) {
                    if (!visited[nextRow][nextCol]) {
                        visited[nextRow][nextCol] = true;
                        System.out.println("["+nextRow +", " + nextCol + "] => " + (pickPosition[2]+1));
                        queue.add(new Node(new int[]{nextRow, nextCol, pickPosition[2]+1}, board));
                    }
                }

            }

        }
        return returnQueue;
    }


    public class Node {
        private int[] position;
        private int[][] board;

        public Node(int[] position, int[][] board) {
            this.position = position;
            this.board = board;
        }

        public int[] getPosition() {
            return position;
        }

        public int[][] getBoard() {
            return board;
        }

        public void setBoard(int[][] board) {
            this.board = board;
        }

        public void setPosition(int[] position) {
            this.position = position;
        }
    }
}
