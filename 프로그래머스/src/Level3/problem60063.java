package Level3;

import java.util.*;

public class problem60063 {

    public static void main(String[] args) {
        problem60063 problem60063 = new problem60063();
//        problem60063.solution(new int[][]{{0,0,0,1,1},{0,0,0,1,0},{0,1,0,1,1},{1,1,0,0,1},{0,0,0,0,0}});
//        problem60063.solution(new int[][]{{0,0,1,1,0,0},{0,0,0,0,0,0},{0,1,0,0,0,0},{0,1,0,1,1,0},{0,0,0,1,1,0},{0,0,0,1,1,0}});
//        problem60063.solution(new int[][]{{0, 0, 0, 0, 1, 0},{0, 0, 1, 1, 1, 0},{0, 1, 1, 1, 1, 0},{0, 1, 0, 0, 1, 0},{0, 0, 1, 0, 0, 0},{0, 0, 0, 0, 0, 0}});
//        problem60063.solution(new int[][]{{0, 0, 0, 0, 0, 0, 1},{1, 1, 1, 1, 0, 0, 1},{0, 0, 0, 0, 0, 0, 0},{0, 0, 1, 1, 1, 1, 0},{0, 1, 1, 1, 1, 1, 0},{0, 0, 0, 0, 0, 1, 1},{0, 0, 1, 0, 0, 0, 0}});
        problem60063.solution(new int[][]{{0,0,0,0,1},{1,0,0,0,1},{0,1,0,0,0},{0,0,1,0,0},{0,0,0,1,0}});
    }

    public class Robot {
        private int dst;
        private int[] pos1;
        private int[] pos2;
        private boolean[][] visited;

        public Robot(int dst, int[] pos1, int[] pos2, boolean[][] visited) {
            this.dst = dst;
            this.pos1 = pos1;
            this.pos2 = pos2;
            boolean[][] newVisited = new boolean[visited.length][visited[0].length];
            for(int i=0;i<visited.length;i++) {
                for(int j=0;j<visited[i].length;j++) {
                    newVisited[i][j] = visited[i][j];
                }
            }

            this.visited = newVisited;
        }

        public void setVisitedPos(int row1, int col1, int row2, int col2) {
            visited[row1][col1] = true;
            visited[row2][col2] = true;
        }
    }

    public int solution(int[][] board) {
        Queue<Robot> queue = new LinkedList<>();
        int row = board.length;
        int col = board[0].length;
        int answer = Integer.MAX_VALUE;

        boolean[][] visited = new boolean[row][col];
//        visited[0][0] = true;
        Robot robot = new Robot(0, new int[]{0,0}, new int[]{0,1}, visited);
        queue.add(robot);

        while(!queue.isEmpty()) {
            Robot nextRobot = queue.poll();
            int[] pos1 = nextRobot.pos1;
            int[] pos2 = nextRobot.pos2;
            System.out.println("현재 위치1 : ["+nextRobot.pos1[0]+","+nextRobot.pos1[1]+"]");
            System.out.println("현재 위치2 : ["+nextRobot.pos2[0]+","+nextRobot.pos2[1]+"]");
            System.out.println("현재 거리 : " + nextRobot.dst);
            if ((nextRobot.pos1[0] == row - 1 && nextRobot.pos1[1] == col - 1) || (nextRobot.pos2[0] == row - 1 && nextRobot.pos2[1] == col - 1)) {
                answer = Math.min(answer, nextRobot.dst);
            }
            visited[pos1[0]][pos1[1]] = true;
            visited[pos2[0]][pos1[1]] = true;
            visited[pos2[0]][pos2[1]] = true;
            visited[pos1[0]][pos2[1]] = true;
            validRotation(nextRobot, queue, board);
//            System.out.println("회전 후 queue : " + queue);
            validMove(nextRobot, queue, board);
//            System.out.println("이동 후 queue : " + queue);
        }

        System.out.println(answer);

        return answer;
    }

    public void validMove(Robot robot, Queue<Robot> queue, int[][] board) {
        int[] pos1 = robot.pos1;
        int[] pos2 = robot.pos2;
        boolean[][] visited = robot.visited;
        int maxRow = board.length - 1;
        int maxCol = board[0].length - 1;

        /* 로봇이 수평 일 때*/
        if (pos1[0] == pos2[0] && ((pos1[1] >= 0 && pos1[1] <= maxCol) && (pos2[1] >= 0 && pos2[1] <= maxCol))) {
            if ((pos1[1] + 1 <= maxCol && pos2[1] + 1 <= maxCol) && board[pos1[0]][pos1[1] + 1] != 1 && board[pos1[0]][pos2[1] + 1] != 1) {
                if (!(visited[pos1[0]][pos1[1]+1] && visited[pos1[0]][pos2[1]+1])) {
                    System.out.println("이동 위치1 : ["+pos1[0]+","+(pos1[1]+1)+"]");
                    System.out.println("이동 위치2 : ["+pos2[0]+","+(pos2[1]+1)+"]");
                    Robot newRobot1 = new Robot(robot.dst + 1, new int[]{pos1[0], pos1[1]+1}, new int[]{pos1[0], pos2[1]+1}, visited);
                    Robot newRobot2 = new Robot(robot.dst + 1, new int[]{pos1[0], pos2[1]+1}, new int[]{pos1[0], pos1[1]+1}, visited);
//                    newRobot1.setVisitedPos(pos1[0], pos1[1]+1, pos1[0], pos2[1]+1);
//                    newRobot2.setVisitedPos(pos1[0], pos2[1]+1, pos1[0], pos1[1]+1);
                    queue.add(newRobot1);
                    queue.add(newRobot2);
                }
            }
            if ((pos1[1] - 1 >= 0 && pos2[1] - 1 >= 0 ) && board[pos1[0]][pos1[1] - 1] != 1 && board[pos1[0]][pos2[1] - 1] != 1) {
                if (!(visited[pos1[0]][pos1[1]-1] && visited[pos1[0]][pos2[1]-1])) {
                    Robot newRobot1 = new Robot(robot.dst + 1, new int[]{pos1[0], pos1[1]-1}, new int[]{pos1[0], pos2[1]-1}, visited);
                    Robot newRobot2 = new Robot(robot.dst + 1, new int[]{pos1[0], pos2[1]-1}, new int[]{pos1[0], pos1[1]-1}, visited);
//                    newRobot1.setVisitedPos(pos1[0], pos1[1]-1, pos1[0], pos2[1]-1);
//                    newRobot2.setVisitedPos(pos1[0], pos2[1]-1, pos1[0], pos1[1]-1);
                    queue.add(newRobot1);
                    queue.add(newRobot2);
                }
            }
            if ((pos1[0] + 1 <= maxRow && pos2[0] + 1 <= maxRow) && board[pos1[0] + 1][pos1[1]] != 1 && board[pos1[0] + 1][pos2[1]] != 1) {
                if (!(visited[pos1[0] + 1][pos1[1]] && visited[pos1[0] + 1][pos2[1]])) {
                    Robot newRobot1 = new Robot(robot.dst + 1, new int[]{pos1[0] + 1, pos1[1]}, new int[]{pos1[0] + 1, pos2[1]}, visited);
                    Robot newRobot2 = new Robot(robot.dst + 1, new int[]{pos1[0] + 1, pos2[1]}, new int[]{pos1[0] + 1, pos1[1]}, visited);
//                    newRobot1.setVisitedPos(pos1[0] + 1, pos1[1], pos1[0] + 1, pos2[1]);
//                    newRobot2.setVisitedPos(pos1[0] + 1, pos2[1], pos1[0] + 1, pos1[1]);
                    queue.add(newRobot1);
                    queue.add(newRobot2);
                }
            }
            if ((pos1[0] - 1 >= 0 && pos2[0] - 1 >= 0) && board[pos1[0] - 1][pos1[1]] != 1 && board[pos1[0] - 1][pos2[1]] != 1) {
                if (!(visited[pos1[0] - 1][pos1[1]] && visited[pos1[0] - 1][pos2[1]])) {
                    Robot newRobot1 = new Robot(robot.dst + 1, new int[]{pos1[0] - 1, pos1[1]}, new int[]{pos1[0] - 1, pos2[1]}, visited);
                    Robot newRobot2 = new Robot(robot.dst + 1, new int[]{pos1[0] - 1, pos2[1]}, new int[]{pos1[0] - 1, pos1[1]}, visited);
//                    newRobot1.setVisitedPos(pos1[0] - 1, pos1[1], pos1[0] - 1, pos2[1]);
//                    newRobot2.setVisitedPos(pos1[0] - 1, pos2[1], pos1[0] - 1, pos1[1]);
                    queue.add(newRobot1);
                    queue.add(newRobot2);
                }
            }
        }
        /* 로봇이 수직 일 때 */
        else if (pos1[1] == pos2[1] && ((pos1[0] >= 0 && pos1[0] <= maxRow) && (pos2[0] >= 0 && pos2[0] <= maxRow))){
            if ((pos1[1] + 1 <= maxCol && pos2[1] + 1 <= maxCol) && board[pos1[0]][pos1[1] + 1] != 1 && board[pos1[0]][pos2[1] + 1] != 1) {
                if (!(visited[pos1[0]][pos1[1]+1] && visited[pos1[0]][pos2[1]+1])) {
                    Robot newRobot1 = new Robot(robot.dst + 1, new int[]{pos1[0], pos1[1]+1}, new int[]{pos1[0], pos2[1]+1}, visited);
                    Robot newRobot2 = new Robot(robot.dst + 1, new int[]{pos1[0], pos2[1]+1}, new int[]{pos1[0], pos1[1]+1}, visited);
//                    newRobot1.setVisitedPos(pos1[0], pos1[1]+1, pos1[0], pos2[1]+1);
//                    newRobot2.setVisitedPos(pos1[0], pos2[1]+1, pos1[0], pos1[1]+1);
                    queue.add(newRobot1);
                    queue.add(newRobot2);
                }
            }
            if ((pos1[1] - 1 >= 0 && pos2[1] - 1 >= 0 ) && board[pos1[0]][pos1[1] - 1] != 1 && board[pos1[0]][pos2[1] - 1] != 1) {
                if (!(visited[pos1[0]][pos1[1]-1] && visited[pos1[0]][pos2[1]-1])) {
                    Robot newRobot1 = new Robot(robot.dst + 1, new int[]{pos1[0], pos1[1]-1}, new int[]{pos1[0], pos2[1]-1}, visited);
                    Robot newRobot2 = new Robot(robot.dst + 1, new int[]{pos1[0], pos2[1]-1}, new int[]{pos1[0], pos1[1]-1}, visited);
//                    newRobot1.setVisitedPos(pos1[0], pos1[1]-1, pos1[0], pos2[1]-1);
//                    newRobot2.setVisitedPos(pos1[0], pos2[1]-1, pos1[0], pos1[1]-1);
                    queue.add(newRobot1);
                    queue.add(newRobot2);
                }
            }
            if ((pos1[0] + 1 <= maxRow && pos2[0] + 1 <= maxRow) && board[pos1[0] + 1][pos1[1]] != 1 && board[pos1[0] + 1][pos2[1]] != 1) {
                if (!(visited[pos1[0] + 1][pos1[1]] && visited[pos1[0] + 1][pos2[1]])) {
                    Robot newRobot1 = new Robot(robot.dst + 1, new int[]{pos1[0] + 1, pos1[1]}, new int[]{pos1[0] + 1, pos2[1]}, visited);
                    Robot newRobot2 = new Robot(robot.dst + 1, new int[]{pos1[0] + 1, pos2[1]}, new int[]{pos1[0] + 1, pos1[1]}, visited);
//                    newRobot1.setVisitedPos(pos1[0] + 1, pos1[1], pos1[0] + 1, pos2[1]);
//                    newRobot2.setVisitedPos(pos1[0] + 1, pos2[1], pos1[0] + 1, pos1[1]);
                    queue.add(newRobot1);
                    queue.add(newRobot2);
                }
            }
            if ((pos1[0] - 1 >= 0 && pos2[0] - 1 >= 0) && board[pos1[0] - 1][pos1[1]] != 1 && board[pos1[0] - 1][pos2[1]] != 1) {
                if (!(visited[pos1[0] - 1][pos1[1]] && visited[pos1[0] - 1][pos2[1]])) {
                    Robot newRobot1 = new Robot(robot.dst + 1, new int[]{pos1[0] - 1, pos1[1]}, new int[]{pos1[0] - 1, pos2[1]}, visited);
                    Robot newRobot2 = new Robot(robot.dst + 1, new int[]{pos1[0] - 1, pos2[1]}, new int[]{pos1[0] - 1, pos1[1]}, visited);
//                    newRobot1.setVisitedPos(pos1[0] - 1, pos1[1], pos1[0] - 1, pos2[1]);
//                    newRobot2.setVisitedPos(pos1[0] - 1, pos2[1], pos1[0] - 1, pos1[1]);
                    queue.add(newRobot1);
                    queue.add(newRobot2);
                }
            }
        }
    }

    public void validRotation(Robot robot, Queue<Robot> queue, int[][] board) {
        int[] pos1 = robot.pos1;
        int[] pos2 = robot.pos2;
        boolean[][] visited = robot.visited;
        int maxRow = board.length - 1;
        int maxCol = board[0].length - 1;

        /* 로봇이 수평 일 때*/
        if (pos1[0] == pos2[0] && ((pos1[1] >= 0 && pos1[1] <= maxCol) && (pos2[1] >= 0 && pos2[1] <= maxCol))) {
            /* 맨위 또는 중간*/
            if (pos1[0] == 0 || pos1[0] != maxRow) {
                if (board[pos1[0]+1][pos1[1]] != 1 && board[pos1[0]+1][pos2[1]] != 1) {
                    if (!(visited[pos1[0]][pos1[1]] && visited[pos1[0]+1][pos1[1]])) {
                        Robot newRobot1 = new Robot(robot.dst + 1, new int[]{pos1[0], pos1[1]}, new int[]{pos1[0]+1, pos1[1]}, visited);
                        Robot newRobot2 = new Robot(robot.dst + 1, new int[]{pos1[0]+1, pos1[1]}, new int[]{pos1[0], pos1[1]}, visited);
//                        newRobot1.setVisitedPos(pos1[0], pos1[1], pos1[0]+1, pos1[1]);
//                        newRobot2.setVisitedPos(pos1[0]+1, pos1[1], pos1[0], pos1[1]);
                        queue.add(newRobot1);
                        queue.add(newRobot2);
                    }
                    if(!(visited[pos2[0]][pos2[1]] && visited[pos2[0]+1][pos2[1]])) {
                        Robot newRobot1 = new Robot(robot.dst + 1, new int[]{pos2[0], pos2[1]}, new int[]{pos2[0]+1, pos2[1]}, visited);
                        Robot newRobot2 = new Robot(robot.dst + 1, new int[]{pos2[0]+1, pos2[1]}, new int[]{pos2[0], pos2[1]}, visited);
//                        newRobot1.setVisitedPos(pos2[0], pos2[1], pos2[0]+1, pos2[1]);
//                        newRobot2.setVisitedPos(pos2[0]+1, pos2[1], pos2[0], pos2[1]);
                        queue.add(newRobot1);
                        queue.add(newRobot2);
                    }
                }
            }
            /* 맨 아래 또는 중간*/
            if (pos1[0] == maxRow || pos1[0] != 0) {
                if(board[pos1[0]-1][pos1[1]] != 1 && board[pos1[0]-1][pos2[1]] != 1) {
                    if (!(visited[pos1[0]][pos1[1]] && visited[pos1[0]-1][pos1[1]])) {
                        Robot newRobot1 = new Robot(robot.dst + 1, new int[]{pos1[0], pos1[1]}, new int[]{pos1[0]-1, pos1[1]}, visited);
                        Robot newRobot2 = new Robot(robot.dst + 1, new int[]{pos1[0]-1, pos1[1]}, new int[]{pos1[0], pos1[1]}, visited);
//                        newRobot1.setVisitedPos(pos1[0], pos1[1], pos1[0]-1, pos1[1]);
//                        newRobot2.setVisitedPos(pos1[0]-1, pos1[1], pos1[0], pos1[1]);
                        queue.add(newRobot1);
                        queue.add(newRobot2);
                    }
                    if (!(visited[pos2[0]][pos2[1]] && visited[pos2[0]-1][pos2[1]])) {
                        Robot newRobot1 = new Robot(robot.dst + 1, new int[]{pos2[0], pos2[1]}, new int[]{pos2[0]-1, pos2[1]}, visited);
                        Robot newRobot2 = new Robot(robot.dst + 1, new int[]{pos2[0]-1, pos2[1]}, new int[]{pos2[0], pos2[1]}, visited);
//                        newRobot1.setVisitedPos(pos2[0], pos2[1], pos2[0]-1, pos2[1]);
//                        newRobot2.setVisitedPos(pos2[0]-1, pos2[1], pos2[0], pos2[1]);
                        queue.add(newRobot1);
                        queue.add(newRobot2);
                    }
                }
            }
        }
        /* 로봇이 수직 일 때*/
        else if (pos1[1] == pos2[1] && ((pos1[0] >= 0 && pos1[0] <= maxRow) && (pos2[0] >= 0 && pos2[0] <= maxRow))) {
            /* 맨 왼쪽 또는 중간*/
            if (pos1[1] == 0 || pos1[1] != maxCol) {
                if (board[pos1[0]][pos1[1]+1] != 1 && board[pos2[0]][pos2[1]+1] != 1) {
                    if (!(visited[pos1[0]][pos1[1]] && visited[pos1[0]][pos1[1]+1])) {
                        Robot newRobot1 = new Robot(robot.dst + 1, new int[]{pos1[0], pos1[1]}, new int[]{pos1[0], pos1[1]+1}, visited);
                        Robot newRobot2 = new Robot(robot.dst + 1, new int[]{pos1[0], pos1[1]+1}, new int[]{pos1[0], pos1[1]}, visited);
//                        newRobot1.setVisitedPos(pos1[0], pos1[1], pos1[0]+1, pos1[1]);
//                        newRobot2.setVisitedPos(pos1[0]+1, pos1[1], pos1[0], pos1[1]);
                        queue.add(newRobot1);
                        queue.add(newRobot2);
                    }
                    if(!(visited[pos2[0]][pos2[1]] && visited[pos2[0]][pos2[1]+1])) {
                        Robot newRobot1 = new Robot(robot.dst + 1, new int[]{pos2[0], pos2[1]}, new int[]{pos2[0], pos2[1]+1}, visited);
                        Robot newRobot2 = new Robot(robot.dst + 1, new int[]{pos2[0], pos2[1]+1}, new int[]{pos2[0], pos2[1]}, visited);
//                        newRobot1.setVisitedPos(pos2[0], pos2[1], pos2[0]+1, pos2[1]);
//                        newRobot2.setVisitedPos(pos2[0]+1, pos2[1], pos2[0], pos2[1]);
                        queue.add(newRobot1);
                        queue.add(newRobot2);
                    }
                }
            }
            /* 맨 오른쪽 또는 중간*/
            if (pos1[1] == maxCol || pos1[1] != 0) {
                if(board[pos1[0]][pos1[1]-1] != 1 && board[pos1[0]][pos2[1]-1] != 1) {
                    if (!(visited[pos1[0]][pos1[1]] && visited[pos1[0]][pos1[1]-1])) {
                        Robot newRobot1 = new Robot(robot.dst + 1, new int[]{pos1[0], pos1[1]}, new int[]{pos1[0], pos1[1]-1}, visited);
                        Robot newRobot2 = new Robot(robot.dst + 1, new int[]{pos1[0], pos1[1]-1}, new int[]{pos1[0], pos1[1]}, visited);
//                        newRobot1.setVisitedPos(pos1[0], pos1[1], pos1[0], pos1[1]-1);
//                        newRobot2.setVisitedPos(pos1[0], pos1[1]-1, pos1[0], pos1[1]);
                        queue.add(newRobot1);
                        queue.add(newRobot2);
                    }
                    if (!(visited[pos2[0]][pos2[1]] && visited[pos2[0]][pos2[1]-1])) {
                        Robot newRobot1 = new Robot(robot.dst + 1, new int[]{pos2[0], pos2[1]}, new int[]{pos2[0], pos2[1]-1}, visited);
                        Robot newRobot2 = new Robot(robot.dst + 1, new int[]{pos2[0], pos2[1]-1}, new int[]{pos2[0], pos2[1]}, visited);
//                        newRobot1.setVisitedPos(pos2[0], pos2[1], pos2[0], pos2[1]-1);
//                        newRobot2.setVisitedPos(pos2[0], pos2[1]-1, pos2[0], pos2[1]);
                        queue.add(newRobot1);
                        queue.add(newRobot2);
                    }
                }
            }
        }
     }
//    public int solution(int[][] board) {
//        int answer = Integer.MAX_VALUE;
//        PriorityQueue<Integer> box = new PriorityQueue<>();
//        String currentPoint;
//        int[][] checkBoard = new int[board.length][board[0].length];
//        int maxRow = board.length;
//        int maxCol = board[0].length;
//        Queue<String> queue = new LinkedList<>();
//        HashSet<String> set = new HashSet<>();
//
//        currentPoint = 0+","+0+"/"+0+","+1+"/"+0;
//        queue.add(currentPoint);
//
//        for(int i=0;i< board.length;i++) {
//            for(int j=0;j<board[i].length;j++) {
//                checkBoard[i][j] = board[i][j] == 1 ? (-1) : board[i][j];
//            }
//        }
//
//        while(!queue.isEmpty()) {
//            String pick = queue.poll();
//            String[] word = pick.split("/");
//            String[] first = word[0].split(",");
//            String[] second = word[1].split(",");
//            int score = Integer.parseInt(word[2]);
//            int row1 = Integer.parseInt(first[0]);
//            int col1 = Integer.parseInt(first[1]);
//            int row2 = Integer.parseInt(second[0]);
//            int col2 = Integer.parseInt(second[1]);
//
//            if (set.contains(row1 + "," + col1 + "/" + row2 + "," + col2) || set.contains(row2 + "," + col2 + "/" + row1 + "," + col1))
//                continue;
//
//            if ((row1 == maxRow - 1 && col1 == maxCol - 1) || (row2 == maxRow - 1 && col2 == maxCol - 1)) {
//                box.add(score);
//            }
//
//            System.out.println(queue);
//
//            if (row1 >= 0 && row2 >= 0 && row1 < maxRow && row2 < maxRow && col1 >= 0 && col2 >= 0 && col1 < maxCol && col2 < maxCol) {
//                if (!(board[row1][col1] == -1 || board[row2][col2] == -1)) {
//
//                    set.add(row1 + "," + col1 + "/" + row2 + "," + col2);
//
//                    System.out.println("방문 순서 : [" + row1 + ", " + col1 + "] [" + row2 + ", " + col2 + "] : " + score);
//
//                    if (row1 == row2 && (col1 + 1 == col2 || col2 + 1 == col1)) {
//                        // 수평인 경우
//                        if (row1 > 0 && row1 < maxRow - 1) {
//                            // 왼쪽 축 기준으로, 왼쪽으로 90도 회전 == 오른쪽 축 기준으로, 오른쪽으로 90도 회전 == 위로 이동 가능
//                            // 왼쪽 축 기준으로, 오른쪽으로 90도 회전 == 오른쪽 축 기준으로, 왼쪽으로 90도 회전 == 아래로 이동 가능
//                            if (board[row1 - 1][col1] == 0 && board[row1 - 1][col2] == 0) {
//                                queue.add(row1 + "," + col1 + "/" + (row2 - 1) + "," + col1 + "/" + (score + 1));
//                                queue.add((row2 - 1) + "," + col1 + "/" + row1 + "," + col1 + "/" + (score + 1));
//                                queue.add(row2 + "," + col2 + "/" + (row1 - 1) + "," + col2 + "/" + (score + 1));
//                                queue.add((row1 - 1) + "," + col2 + "/" + row2 + "," + col2 + "/" + (score + 1));
//                                queue.add((row1 - 1) + "," + col1 + "/" + (row2 - 1) + "," + col2 + "/" + (score + 1));
//                                queue.add((row1 - 1) + "," + col2 + "/" + (row2 - 1) + "," + col1 + "/" + (score + 1));
//                            }
//                            if (board[row1 + 1][col1] == 0 && board[row1 + 1][col2] == 0) {
//                                queue.add(row1 + "," + col1 + "/" + (row2 + 1) + "," + col1 + "/" + (score + 1));
//                                queue.add((row2 + 1) + "," + col1 + "/" + row1 + "," + col1 + "/" + (score + 1));
//                                queue.add(row2 + "," + col2 + "/" + (row1 + 1) + "," + col2 + "/" + (score + 1));
//                                queue.add((row1 + 1) + "," + col2 + "/" + row2 + "," + col2 + "/" + (score + 1));
//                                queue.add((row1 + 1) + "," + col1 + "/" + (row2 + 1) + "," + col2 + "/" + (score + 1));
//                                queue.add((row1 + 1) + "," + col2 + "/" + (row2 + 1) + "," + col1 + "/" + (score + 1));
//                            }
//                        } else if (row1 == 0 && board[row1 + 1][col1] == 0 && board[row2 + 1][col2] == 0) {
//                            queue.add(row1 + "," + col1 + "/" + (row2 + 1) + "," + col1 + "/" + (score + 1));
//                            queue.add((row2 + 1) + "," + col1 + "/" + row1 + "," + col1 + "/" + (score + 1));
//                            queue.add(row2 + "," + col2 + "/" + (row1 + 1) + "," + col2 + "/" + (score + 1));
//                            queue.add((row1 + 1) + "," + col2 + "/" + row2 + "," + col2 + "/" + (score + 1));
//                            queue.add((row1 + 1) + "," + col1 + "/" + (row2 + 1) + "," + col2 + "/" + (score + 1));
//                            queue.add((row1 + 1) + "," + col2 + "/" + (row2 + 1) + "," + col1 + "/" + (score + 1));
//                        } else if (row1 == maxRow - 1 && board[row1 - 1][col1] == 0 && board[row2 - 1][col2] == 0) {
//                            queue.add(row1 + "," + col1 + "/" + (row2 - 1) + "," + col1 + "/" + (score + 1));
//                            queue.add((row2 - 1) + "," + col1 + "/" + row1 + "," + col1 + "/" + (score + 1));
//                            queue.add(row2 + "," + col2 + "/" + (row1 - 1) + "," + col2 + "/" + (score + 1));
//                            queue.add((row1 - 1) + "," + col2 + "/" + row2 + "," + col2 + "/" + (score + 1));
//                            queue.add((row1 - 1) + "," + col1 + "/" + (row2 - 1) + "," + col2 + "/" + (score + 1));
//                            queue.add((row1 - 1) + "," + col2 + "/" + (row2 - 1) + "," + col1 + "/" + (score + 1));
//                        }
//
//                        if (col1 > 0 && col1 < maxCol - 1 && col2 > 0 && col2 < maxCol - 1) {
//                            // 왼쪽 으로 이동 가능
//                            // 오른쪽 으로 이동 가능
//                            if (board[row1][col1 - 1] == 0 && board[row2][col2 - 1] == 0) {
//                                queue.add(row1 + "," + (col1 - 1) + "/" + row2 + "," + (col2 - 1) + "/" + (score + 1));
//                                queue.add(row1 + "," + (col2 - 1) + "/" + row2 + "," + (col1 - 1) + "/" + (score + 1));
//                            }
//                            if (board[row1][col1 + 1] == 0 && board[row2][col2 + 1] == 0) {
//                                queue.add(row1 + "," + (col1 + 1) + "/" + row2 + "," + (col2 + 1) + "/" + (score + 1));
//                                queue.add(row1 + "," + (col2 + 1) + "/" + row2 + "," + (col1 + 1) + "/" + (score + 1));
//                            }
//                        } else if (((col1 == 0 && col2 == col1 + 1) || (col2 == 0 && col1 == col2 + 1)) && board[row1][col2 + 1] == 0 && board[row2][col1 + 1] == 0) {
//                            queue.add(row1 + "," + (col1 + 1) + "/" + row2 + "," + (col2 + 1) + "/" + (score + 1));
//                            queue.add(row1 + "," + (col2 + 1) + "/" + row2 + "," + (col1 + 1) + "/" + (score + 1));
//                        } else if (((col1 == col2 - 1 && col2 == maxCol - 1) || (col2 == col1 - 1 && col1 == maxCol - 1)) && board[row1][col1 - 1] == 0 && board[row2][col2 - 1] == 0) {
//                            queue.add(row1 + "," + (col1 - 1) + "/" + row2 + "," + (col2 - 1) + "/" + (score + 1));
//                            queue.add(row1 + "," + (col2 - 1) + "/" + row2 + "," + (col1 - 1) + "/" + (score + 1));
//                        }
//
//                    } else if (col1 == col2 && (row1 + 1 == row2 || row2 + 1 == row1)) {
//                        // 수직인 경우
//                        if (col1 > 0 && col1 < maxCol - 1) {
//                            if (board[row1][col1 - 1] == 0 && board[row2][col2 - 1] == 0) {
//                                queue.add((row1 + 1) + "," + (col1 - 1) + "/" + row2 + "," + col2 + "/" + (score + 1));
//                                queue.add(row2 + "," + col2 + "/" + (row1 + 1) + "," + (col1 - 1) + "/" + (score + 1));
//                                queue.add((row2 - 1) + "," + (col2 - 1) + "/" + row1 + "," + col1 + "/" + (score + 1));
//                                queue.add(row1 + "," + col1 + "/" + (row2 - 1) + "," + (col2 - 1) + "/" + (score + 1));
//                                queue.add(row1 + "," + (col1 - 1) + "/" + row2 + "," + (col2 - 1) + "/" + (score + 1));
//                                queue.add(row2 + "," + (col2 - 1) + "/" + row1 + "," + (col1 - 1) + "/" + (score + 1));
//                            }
//                            if (board[row1][col1 + 1] == 0 && board[row2][col2 + 1] == 0) {
//                                queue.add((row1 + 1) + "," + (col1 + 1) + "/" + row2 + "," + col2 + "/" + (score + 1));
//                                queue.add(row2 + "," + col2 + "/" + (row1 + 1) + "," + (col1 + 1) + "/" + (score + 1));
//                                queue.add((row2 - 1) + "," + (col2 + 1) + "/" + row1 + "," + col1 + "/" + (score + 1));
//                                queue.add(row1 + "," + col1 + "/" + (row2 - 1) + "," + (col2 + 1) + "/" + (score + 1));
//                                queue.add(row1 + "," + (col1 + 1) + "/" + row2 + "," + (col2 + 1) + "/" + (score + 1));
//                                queue.add(row2 + "," + (col2 + 1) + "/" + row1 + "," + (col1 + 1) + "/" + (score + 1));
//                            }
//                        } else if (col1 == 0 && board[row1][col1 + 1] == 0 && board[row2][col2 + 1] == 0) {
//                            queue.add((row1 + 1) + "," + (col1 + 1) + "/" + row2 + "," + col2 + "/" + (score + 1));
//                            queue.add(row2 + "," + col2 + "/" + (row1 + 1) + "," + (col1 + 1) + "/" + (score + 1));
//                            queue.add((row2 - 1) + "," + (col2 + 1) + "/" + row1 + "," + col1 + "/" + (score + 1));
//                            queue.add(row1 + "," + col1 + "/" + (row2 - 1) + "," + (col2 + 1) + "/" + (score + 1));
//                            queue.add(row1 + "," + (col1 + 1) + "/" + row2 + "," + (col2 + 1) + "/" + (score + 1));
//                            queue.add(row2 + "," + (col2 + 1) + "/" + row1 + "," + (col1 + 1) + "/" + (score + 1));
//                        } else if (col1 == maxCol - 1 && board[row1][col1 - 1] == 0 && board[row2][col2 - 1] == 0) {
//                            queue.add((row1 + 1) + "," + (col1 - 1) + "/" + row2 + "," + col2 + "/" + (score + 1));
//                            queue.add(row2 + "," + col2 + "/" + (row1 + 1) + "," + (col1 - 1) + "/" + (score + 1));
//                            queue.add((row2 - 1) + "," + (col2 - 1) + "/" + row1 + "," + col1 + "/" + (score + 1));
//                            queue.add(row1 + "," + col1 + "/" + (row2 - 1) + "," + (col2 - 1) + "/" + (score + 1));
//                            queue.add(row1 + "," + (col1 - 1) + "/" + row2 + "," + (col2 - 1) + "/" + (score + 1));
//                            queue.add(row2 + "," + (col2 - 1) + "/" + row1 + "," + (col1 - 1) + "/" + (score + 1));
//                        }
//
//                        if (row1 > 0 && row1 < maxRow - 1 && row2 > 0 && row2 < maxRow - 1) {
//                            if (board[row1 - 1][col1] == 0 && board[row2 - 1][col2] == 0) {
//                                queue.add((row1 - 1) + "," + col1 + "/" + (row2 - 1) + "," + col2 + "/" + (score + 1));
//                                queue.add((row2 - 1) + "," + col2 + "/" + (row1 - 1) + "," + col1 + "/" + (score + 1));
//                            }
//                            if (board[row1 + 1][col1] == 0 && board[row2 + 1][col2] == 0) {
//                                queue.add((row1 + 1) + "," + col1 + "/" + (row2 + 1) + "," + col2 + "/" + (score + 1));
//                                queue.add((row2 + 1) + "," + col2 + "/" + (row1 + 1) + "," + col1 + "/" + (score + 1));
//                            }
//                        } else if (((row1 == 0 && row2 == row1 + 1) || (row2 == 0 && row1 == row2 + 1)) && board[row2 + 1][col2] == 0 && board[row1 + 1][col1] == 0) {
//                            queue.add((row1 + 1) + "," + col1 + "/" + (row2 + 1) + "," + col2 + "/" + (score + 1));
//                            queue.add((row2 + 1) + "," + col2 + "/" + (row1 + 1) + "," + col1 + "/" + (score + 1));
//                        } else if (((row1 == row2 - 1 && row2 == maxRow - 1) || (row2 == row1 - 1 && row1 == maxRow - 1)) && board[row1 - 1][col1] == 0 && board[row2 - 1][col2] == 0) {
//                            queue.add((row1 - 1) + "," + col1 + "/" + (row2 - 1) + "," + col2 + "/" + (score + 1));
//                            queue.add((row2 - 1) + "," + col2 + "/" + (row1 - 1) + "," + col1 + "/" + (score + 1));
//                        }
//
//                    }
//                }
//            }
//        }
//        answer = box.isEmpty() ? 0 : box.poll();
//        System.out.println(answer);
//        return answer;
//    }
}
