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
        int[][] map = new int[board.length+1][board[0].length+1];

        for (int[] ints : skill) {
            int type = ints[0];
            int degree = ints[5];
            int row1 = ints[1];
            int col1 = ints[2];
            int row2 = ints[3];
            int col2 = ints[4];
            degree = type == 1 ? degree*(-1) : degree;
            map[row1][col1] += degree;
            map[row1][col2+1] += degree*(-1);
            map[row2+1][col1] += degree*(-1);
            map[row2+1][col2+1] += degree;
        }

        for(int i=0;i<map.length;i++) {
            for(int j=1;j<map[i].length;j++) {
                map[i][j] += map[i][j-1];
            }
        }

        for(int i=0;i<map[0].length;i++) {
            for(int j=1;j<map.length;j++) {
                map[j][i] += map[j-1][i];
            }
        }

        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[i].length;j++) {
                answer = map[i][j] + board[i][j] > 0 ? answer + 1 : answer;
            }
        }

        return answer;
    }

}
