package Level2;

import java.util.Arrays;

public class problem42746 {

    static boolean[] visited;
    static int count ;
    static String board;
    static int max;

    public static void main(String[] args) {
        problem42746 problem42746 = new problem42746();
        problem42746.solution(new int[]{6,10,2});
    }

    public String solution(int[] numbers) {
        String answer = "";
        String[] number = new String[numbers.length];
        for(int i=0;i<number.length;i++) number[i] = String.valueOf(numbers[i]);
        visited = new boolean[numbers.length];
        count = numbers.length;
        board = "";
        max = -1;
        dfs(0, number);
        answer = String.valueOf(max);
        System.out.println(answer);
        return answer;
    }

    public static void dfs(int start, String[] number) {
        if (start == count) {
            max = Math.max(max, Integer.parseInt(board));
            System.out.println("board : " + board);
        }
            for(int i=0;i<number.length;i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    board = board.concat(number[i]);
                    dfs(start+1, number);
                    board = board.substring(0, board.length()-number[i].length());
                    visited[i] = false;
                }
            }

    }
}
