package Level2;

import java.util.*;

public class problem1829 {

    static boolean[][] visited;
    static boolean check;
    static List<Integer> store;
    static int colorCount;
    static int[] cols;
    static int[] rows;

    public static void main(String[] args) {
        problem1829 problem1829 = new problem1829();
        problem1829.solution(6,4,new int[][]{{1,1,1,0},{1,2,2,0},{1,0,0,1},{0,0,0,1},{0,0,0,3},{0,0,0,3}});
    }

    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        int[] answer = new int[2];
        visited = new boolean[m][n];
        check = false;
        store = new ArrayList<>();
        colorCount = 0;
        cols = new int[]{-1,0,0,1};
        rows = new int[]{0,-1,1,0};

        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
                visited[i][j] = false;

        dfs(0, 0, picture, 0, 0);
        System.out.println(store);
        numberOfArea = store.size();
        for(int i=0;i<store.size();i++) {
            maxSizeOfOneArea = Math.max(maxSizeOfOneArea, store.get(i));
        }
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    public static void dfs(int row, int col, int[][] picture, int pickColor, int pivotColor) {
        if (check) {
            if (pivotColor != 0) {


                    // 왼쪽, 오른쪽 탐색
                    for (int i = 0; i < cols.length; i++) {
                        if (col + cols[i] >= 0 && col + cols[i] < picture[i].length && !visited[row][col + cols[i]] && pivotColor == picture[row][col+cols[i]]) {
                            System.out.println("좌우 탐색");
                            System.out.println("[left-right] row : " + row);
                            System.out.println("[left-right] col : " + (col + cols[i]));
                            System.out.println("기준 색상 : " + pivotColor);
                            System.out.println("고른 색상 : picture["+ row + "][" + (col + cols[i]) + "] = " + picture[row][col+cols[i]]);
                            store.set(colorCount, store.get(colorCount)+1);
                            visited[row][col + cols[i]] = true;
                            dfs(row , col + cols[i], picture, picture[row][col + cols[i]], pivotColor);
                        }
                    }

                    // 위, 아래 탐색
                    for (int i = 0; i < rows.length; i++) {
                        if (row + rows[i] >= 0 && row + rows[i] < picture.length && !visited[row + rows[i]][col] && pivotColor == picture[row + rows[i]][col]) {
                            System.out.println("상하 탐색");
                            System.out.println("[up-down] row : " + (row + rows[i]));
                            System.out.println("[up-down] col : " + col);
                            System.out.println("기준 색상 : " + pivotColor);
                            System.out.println("고른 색상 : picture["+ (row+rows[i]) + "][" + col + "] = " + picture[row+rows[i]][col]);
                            store.set(colorCount, store.get(colorCount)+1);
                            visited[row + rows[i]][col] = true;
                            dfs(row + rows[i], col, picture, picture[row + rows[i]][col], pivotColor);
                        }
                    }

            } else {
                return;
            }
        } else {
            for (int i = 0; i < picture.length; i++) {
                for (int j = 0; j < picture[i].length; j++) {
                    if (!visited[i][j] && picture[i][j] != 0) {
                        visited[i][j] = true;
                        check = true;
                        store.add(1);
                        System.out.println("첫 진입");
                        System.out.println("[row] : " + i);
                        System.out.println("[col] : " + j);
                        System.out.println("기준 색상 : " + picture[i][j]);
                        dfs(i, j, picture, picture[i][j], picture[i][j]);
                        System.out.println(store);
                        check = false;
                        colorCount++;
                    }
                }
            }
        }
    }
}
