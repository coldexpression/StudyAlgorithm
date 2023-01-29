package Backjoon;

import java.util.*;

public class problem17136 {

    static int ans;

    static boolean check;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] board = new int[10][10];
        boolean[][] visited = new boolean[10][10];


        List<int[]> list = new ArrayList<>();

        ans = Integer.MAX_VALUE;
        check = false;

        for(int i=0;i<10;i++) {
            for(int j=0;j<10;j++) {
                int input = sc.nextInt();
                board[i][j] = input;
                visited[i][j] = input == 0;

                if(input == 1) list.add(new int[] {i,j});
            }
        }

        int[] paper = new int[5];

        Arrays.fill(paper, 5);

        if (list.isEmpty()) {
            ans = 0;
        } else {
            dfs(list, 0, visited, paper, 0);
        }

        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }

    static void dfs(List<int[]> list , int listIdx, boolean[][] visited ,int[] paper, int count) {
        if (listIdx == -1) {
            if (mapCheck(visited)) {
                if (count < ans) {
                    ans = count;
                    check = true;
                }
            }
            return ;
        }

        int[] pos = list.get(listIdx);
        int row = pos[0];
        int col = pos[1];

            for(int i=0;i<5;i++) {
                int paperCount = paper[i];
                if (!visited[row][col]) {
                    if (validation(visited, row, col, (i + 1))) {
                        if (paperCount > 0) {
                            paper[i]--;
                            fillBoard(visited, row, col, (i + 1), true);
                            int start = -1;
                            for(int idx = listIdx + 1;idx<list.size();idx++) {
                                int[] nextPos = list.get(idx);

                                if (!visited[nextPos[0]][nextPos[1]]) {
                                    start = idx;
                                    break;
                                }
                            }

                            dfs(list, start, visited, paper, count + 1);
                            fillBoard(visited, row, col, (i + 1), false);
                            paper[i]++;
                        }
                    }
                }
            }
    }

    static void fillBoard(boolean[][] visited, int row, int col, int size, boolean type) {
        if (row + size - 1 >= 10 || col + size - 1 >= 10) return;


        for(int i=0;i<size;i++)
            for(int j=0;j<size;j++)
                visited[row+i][col+j] = type;
    }

    static boolean mapCheck(boolean[][] visited) {
        for(int i=0;i<visited.length;i++)
            for(int j=0;j<visited[i].length;j++)
                if (!visited[i][j]) return false;

        return true;
    }

    static boolean validation(boolean[][] visited, int row, int col, int size) {
        if (row + size - 1 >= 10 || col + size - 1 >= 10) return false;

        for(int i=0;i<size;i++) {
            for(int j=0;j<size;j++) {
                if (visited[row+i][col+j]) return false;
            }
        }


        return true;
    }
}
