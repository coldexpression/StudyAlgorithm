package Level3;

import java.util.*;

public class problem72415 {

    static int[] moveRow = new int[]{-1,1,0,0};
    static int[] moveCol = new int[]{0,0,-1,1};

    public static void main(String[] args) {
        problem72415 problem72415 = new problem72415();
//        problem72415.solution(new int[][]{{1,0,0,3},{2,0,0,0},{0,0,0,2},{3,0,1,0}},1, 0);
//        problem72415.solution(new int[][]{{3,0,0,2},{0,0,1,0},{0,1,0,0},{2,0,0,3}},0, 1);
        problem72415.solution(new int[][]{{1,5,0,2},{6,4,3,0},{0,2,1,5},{3,0,6,4}},0, 0);
    }

    public int solution(int[][] board, int r, int c) {

        // 또 다른 아이디어
        // 해당 좌표에 그림이 있어도 다른 그림먼저 제거할 수 있는 경우우
       PriorityQueue<Integer> answerQueue = new PriorityQueue<>();
        int answer = Integer.MAX_VALUE;
        int[] initPosition = new int[]{r,c,0};
        Queue<Node> queue = new LinkedList<>();
        Queue<int[]> pickQueue = new LinkedList<>();
        boolean[][] visited = new boolean[board.length][board[0].length];
        int[] pickPosition;
        boolean check = false;
        int initPicture = board[r][c];
        HashSet<Integer> set = new HashSet<>();
        Queue<Node> initQueue = new LinkedList<>();

        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[i].length;j++) {
                if (board[i][j] != 0) set.add(board[i][j]);
            }
        }

        int[][] tempBoard = board.clone();

        Node node = new Node(initPosition, tempBoard);

        for (int ele : set) {
            visited = initVisited(visited);
            initQueue = findInitBlock(node.getPosition(), node.getBoard(), visited, ele);
            while (!initQueue.isEmpty()) {
                Node node1 = initQueue.peek();
                int[] position = node1.getPosition();
                System.out.println("초기 구한 위치 [" + position[0] + ", " + position[1] + "] => " + position[2]);
                queue.add(initQueue.poll());
            }
        }


        while(!queue.isEmpty()) {
            Node currentNode = queue.poll();
            int[] currentPosition = currentNode.getPosition();
            int[][] currentBoard = currentNode.getBoard();
            System.out.println("현재 보드");
            printf(currentBoard);
            visited = initVisited(visited);
            System.out.println("현재 위치 : [" + currentPosition[0] + ", " + currentPosition[1] + "] => " + currentPosition[2]);
            if (currentBoard[currentPosition[0]][currentPosition[1]] == 0) {
                System.out.println("컴?");
                Queue<Node> waitQueue = findAdjustPictureBlockByNoneBlock(currentPosition, currentBoard, visited);
//                pickPosition = findAdjustPictureBlockByNoneBlock(currentPosition, maxRow, maxCol, board, visited);
                queue.addAll(waitQueue);
                continue;
//                System.out.println("가까운 그림 : [" + pickPosition[0] + ", " + pickPosition[1] + "] => " + pickPosition[2]);
            } else {
                pickPosition = currentPosition.clone();
            }

            pickPosition[2] += 1;
            System.out.println("선택한 위치 : [" + pickPosition[0] + ", " + pickPosition[1] + "] => " + pickPosition[2]);
            Queue<Node> nextQueue = findAdjustPictureBlockByBlock(pickPosition, currentBoard, visited);
            while(!nextQueue.isEmpty()){
                visited = initVisited(visited);
                Node nextNode = nextQueue.poll();
                int[] nextPosition = nextNode.getPosition();
                int[][] nextBoard = nextNode.getBoard();
                System.out.println("다음 위치 : [" + nextPosition[0] + ", " + nextPosition[1] + "] => " + nextPosition[2]);
                if (nextPosition[2] != -1) {
                    printf(nextBoard);
                    nextBoard[pickPosition[0]][pickPosition[1]] = 0;
                    nextBoard[nextPosition[0]][nextPosition[1]] = 0;
                    nextPosition[2] += 1;
                    printf(nextBoard);
                    queue.add(new Node(nextPosition, nextBoard));
                }
//            count++;
                if (checker(nextBoard) == 0) {
                    answerQueue.add(nextPosition[2]);
//                break;
                }

//            if (count == 10) break;
            }
        }



        System.out.println(queue);
        System.out.println(pickQueue);

        for (int[] ints : pickQueue) {
            System.out.println("["+ints[0]+", "+ints[1]+"] => " + ints[2]);
        }

        System.out.println(answerQueue);
        answer = answerQueue.poll();
        System.out.println(answer);

        return answer;
    }

    public void printf(int[][] board) {
        for(int i=0;i<board.length;i++) {
            System.out.println();
            for(int j=0;j<board[i].length;j++) {
                System.out.print(board[i][j] + " ");
            }
        }
        System.out.println();
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

    public Queue<Node> findAdjustPictureBlockByBlock(int[] startPosition, int[][] board, boolean[][] visited) {
        Queue<Node> queue = new LinkedList<>();
        Queue<Node> returnQueue = new LinkedList<>();
        System.out.println("여기 : " + startPosition[2]);
        queue.add(new Node(new int[]{startPosition[0], startPosition[1], startPosition[2]}, board));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int[] pickPosition = node.getPosition();
            int[][] pickBoard = node.getBoard();
            if (!(startPosition[0] == pickPosition[0] && startPosition[1] == pickPosition[1])) {
                if (pickBoard[pickPosition[0]][pickPosition[1]] == pickBoard[startPosition[0]][startPosition[1]]) {
                    int[] t1, t2, t1Result, t2Result;
                    if (pickPosition[0] != startPosition[0] && pickPosition[1] != startPosition[1]) {
                        t1 = colSearch(pickBoard, startPosition[0], pickPosition[0], startPosition[1], startPosition[2]);
                        t2 = rowSearch(pickBoard, startPosition[1], pickPosition[1], startPosition[0], startPosition[2]);
                        t1Result = rowSearch(pickBoard, t1[1], pickPosition[1], t1[0], t1[2]);
                        t2Result = colSearch(pickBoard, t2[0], pickPosition[0], t2[1], t2[2]);
                        if (t1Result[2] > t2Result[2]) returnQueue.add(new Node(t2Result, pickBoard));
                        else if (t2Result[2] > t1Result[1]) returnQueue.add(new Node(t1Result, pickBoard));
                        else {
                            returnQueue.add(new Node(t2Result, pickBoard));
                            returnQueue.add(new Node(t1Result, pickBoard));
                        }
                    } else if (pickPosition[0] == startPosition[0]) {
                        returnQueue.add(new Node(rowSearch(pickBoard, startPosition[1],pickPosition[1], startPosition[0], startPosition[2]), pickBoard));
                    } else {
                        returnQueue.add(new Node(colSearch(pickBoard, startPosition[0], pickPosition[0], startPosition[1], startPosition[2]), pickBoard));
                    }

                }
            }

            for(int i=0;i<4;i++) {
                int nextRow = pickPosition[0] + moveRow[i];
                int nextCol = pickPosition[1] + moveCol[i];
                if (nextRow >= 0 && nextRow < pickBoard.length && nextCol >= 0 && nextCol < pickBoard[0].length) {
                    if (!visited[nextRow][nextCol]) {
                        visited[nextRow][nextCol] = true;
                        System.out.println("그림 있는 블럭 : ["+nextRow +", " + nextCol + "] => " + (pickPosition[2]+1));
                        queue.add(new Node(new int[]{nextRow, nextCol, pickPosition[2]+1}, pickBoard));
                    }
                }

            }
        }

        return returnQueue;
    }

    public Queue<Node> findAdjustPictureBlockByNoneBlock(int[] startPosition, int[][] board, boolean[][] visited) {
        Queue<Node> queue = new LinkedList<>();
        Queue<Node> returnQueue = new LinkedList<>();
        queue.add(new Node(new int[]{startPosition[0], startPosition[1], startPosition[2]}, board));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int[] pickPosition = node.getPosition();
            int[][] pickBoard = node.getBoard();
            int pickPicture = pickBoard[pickPosition[0]][pickPosition[1]];
            if (pickPicture != 0) {
                System.out.println(pickBoard[pickPosition[0]][pickPosition[1]]);
                if (!(startPosition[0] == pickPosition[0] && startPosition[1] == pickPosition[1])) {

                    int[] t1, t2, t1Result, t2Result;
                    System.out.println("커먼?");
                    if (pickPosition[0] != startPosition[0] && pickPosition[1] != startPosition[1]) {
                        t1 = colSearch(pickBoard, startPosition[0], pickPosition[0], startPosition[1], startPosition[2]);
                        t2 = rowSearch(pickBoard, startPosition[1], pickPosition[1], startPosition[0], startPosition[2]);
                        t1Result = rowSearch(pickBoard, t1[1], pickPosition[1], t1[0], t1[2]);
                        t2Result = colSearch(pickBoard, t2[0], pickPosition[0], t2[1], t2[2]);
                        if (t1Result[2] > t2Result[2]) returnQueue.add(new Node(t2Result, pickBoard));
                        else returnQueue.add(new Node(t1Result, pickBoard));
                    } else if (pickPosition[0] == startPosition[0]) {
                        returnQueue.add(new Node(rowSearch(pickBoard, startPosition[1], pickPosition[1], startPosition[0], startPosition[2]), pickBoard));
                    } else {
                        returnQueue.add(new Node(colSearch(pickBoard, startPosition[0], pickPosition[0], startPosition[1], startPosition[2]), pickBoard));
                    }


                }
            }

            for(int i=0;i<4;i++) {
                int nextRow = pickPosition[0] + moveRow[i];
                int nextCol = pickPosition[1] + moveCol[i];
                if (nextRow >= 0 && nextRow < board.length && nextCol >= 0 && nextCol < board[0].length) {
                    if (!visited[nextRow][nextCol]) {
                        visited[nextRow][nextCol] = true;
                        System.out.println("["+nextRow +", " + nextCol + "] => " + (pickPosition[2]+1));
                        queue.add(new Node(new int[]{nextRow, nextCol, pickPosition[2]+1}, pickBoard));
                    }
                }

            }

        }
        return returnQueue;
    }

    public Queue<Node> findInitBlock(int[] startPosition, int[][] board, boolean[][] visited, int picture) {
        Queue<Node> queue = new LinkedList<>();
        Queue<Node> returnQueue = new LinkedList<>();
        queue.add(new Node(new int[]{startPosition[0], startPosition[1], startPosition[2]}, board));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int[] pickPosition = node.getPosition();
            int[][] pickBoard = node.getBoard();
            int pickPicture = pickBoard[pickPosition[0]][pickPosition[1]];
            if (pickPicture == picture) {
                System.out.println(pickBoard[pickPosition[0]][pickPosition[1]]);
                    int[] t1, t2, t1Result, t2Result;
                    System.out.println("커먼?");
                    if (pickPosition[0] == startPosition[0] && pickPosition[1] == startPosition[1]) {
                        returnQueue.add(new Node(new int[]{pickPosition[0], pickPosition[1], 0}, pickBoard));
                    } else if (pickPosition[0] != startPosition[0] && pickPosition[1] != startPosition[1]) {
                        t1 = colSearch(pickBoard, startPosition[0], pickPosition[0], startPosition[1], startPosition[2]);
                        t2 = rowSearch(pickBoard, startPosition[1], pickPosition[1], startPosition[0], startPosition[2]);
                        t1Result = rowSearch(pickBoard, t1[1], pickPosition[1], t1[0], t1[2]);
                        t2Result = colSearch(pickBoard, t2[0], pickPosition[0], t2[1], t2[2]);
                        if (t1Result[2] > t2Result[2]) returnQueue.add(new Node(t2Result, pickBoard));
                        else returnQueue.add(new Node(t1Result, pickBoard));
                    } else if (pickPosition[0] == startPosition[0]) {
                        returnQueue.add(new Node(rowSearch(pickBoard, startPosition[1], pickPosition[1], startPosition[0], startPosition[2]), pickBoard));
                    } else {
                        returnQueue.add(new Node(colSearch(pickBoard, startPosition[0], pickPosition[0], startPosition[1], startPosition[2]), pickBoard));
                    }
            }

            for(int i=0;i<4;i++) {
                int nextRow = pickPosition[0] + moveRow[i];
                int nextCol = pickPosition[1] + moveCol[i];
                if (nextRow >= 0 && nextRow < board.length && nextCol >= 0 && nextCol < board[0].length) {
                    if (!visited[nextRow][nextCol]) {
                        visited[nextRow][nextCol] = true;
                        System.out.println("["+nextRow +", " + nextCol + "] => " + (pickPosition[2]+1));
                        queue.add(new Node(new int[]{nextRow, nextCol, pickPosition[2]+1}, pickBoard));
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
            return position.clone();
        }

        public int[][] getBoard() {
            int[][] newBoard = new int[board.length][board[0].length];
            for(int i=0;i<board.length;i++)
                for(int j=0;j<board[i].length;j++)
                    newBoard[i][j] = board[i][j];
            return newBoard;
        }

        public void setBoard(int[][] board) {
            this.board = board;
        }

        public void setPosition(int[] position) {
            this.position = position;
        }
    }
}
