package Backjoon;

import java.util.*;

public class problem17136 {

    static int ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] board = new int[10][10];
        boolean[][] visited = new boolean[10][10];


        List<int[]> list = new ArrayList<>();

        ans = Integer.MAX_VALUE;

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
            int[] pos = list.get(0);
            dfs(list, 0, visited, paper, pos[0], pos[1], 0);
        }

        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }

    static void dfs(List<int[]> list , int listIdx, boolean[][] visited ,int[] paper, int row, int col, int count) {
        if (listIdx == list.size()) {
            System.out.println("현재 카운트 : " + count);
            if (count < ans) {
                ans = count;
            }
            return ;
        }

            for(int i=4;i>=0;i--) {
                int paperCount = paper[i];
                if (paperCount > 0 && validation(visited, row, col, (i+1))) {
                    System.out.println("통과 : ["+row+", "+col+"] => " + (i+1));
                    System.out.println("count : " + count);
                    paper[i]--;
                    fillBoard(visited, row, col, (i + 1), true);
                    if (listIdx == list.size()-1) dfs(list, listIdx + 1, visited, paper, row, col, count + 1);
                    else {
                        for (int idx = listIdx + 1; idx < list.size(); idx++) {
                            int[] pos = list.get(idx);
                            if (!visited[pos[0]][pos[1]]) dfs(list, idx, visited, paper, pos[0], pos[1], count + 1);
                        }
                    }
                    fillBoard(visited, row, col, (i + 1), false);
                    paper[i]++;
                }
        }
    }

    static boolean finalCheck (boolean[][] visited) {
        for(int i=0;i<10;i++)
            for(int j=0;j<10;j++)
                if(!visited[i][j]) return false;

        return true;
    }

    static void fillBoard(boolean[][] visited, int row, int col, int size, boolean type) {
        if (row + size - 1 >= 10 || col + size - 1 >= 10) return;
        for(int i=0;i<size;i++)
            for(int j=0;j<size;j++)
                visited[row+i][col+j] = type;
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
