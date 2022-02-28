package Level2;

import java.util.*;

public class problem42890 {

    static List<String> passCols = new LinkedList<>();
    static List<String> nonePassCols = new LinkedList<>();
    static String board;
    static boolean[] visited;
    static int answer;

    public static void main(String[] args) {
        problem42890 problem42890 = new problem42890();
        problem42890.solution(new String[][]{{"100","ryan","music","2"},{"200","apeach","match","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}});
    }

    public int solution(String[][] relation) {
        answer = 0;

        for(int i=0;i<relation[0].length;i++) {
            HashMap<String, Integer> checker = new HashMap<>();
            for(int j=0;j<relation.length;j++) {
                if (checker.containsKey(relation[j][i])) break;
                else checker.put(relation[j][i], 0);
            }
            if (checker.size() == relation.length) {
                answer++;
                passCols.add(String.valueOf(i));
            }
            else nonePassCols.add(String.valueOf(i));
        }

        for(int i=2;i<=8;i++) {
            board = "";
            visited = new boolean[i];
            dfs(0, i, 0, relation);
        }

        System.out.println("answer >> " + answer);
        return answer;
    }

    static void dfs(int start, int length, int index, String[][] relation) {
        if (index == length) {
            for(int i=0;i<passCols.size();i++) {
                int count = 0;
                for(String word: passCols.get(i).split("")) {
                    if (board.indexOf(word) != -1) count++;
                }
                if (count == passCols.get(i).length()) return;
            }
            System.out.println("passCols >> " + passCols);
            System.out.println("board >> " + board);

            HashMap<String, Integer> checker = new HashMap<>();
            for(int i=0;i<relation.length;i++) {
                String context = "";
                for(String word: board.split("")) {
                    int col = Integer.parseInt(word);
                    context += relation[i][col];
                }
                if (!checker.containsKey(context)) {
                    checker.put(context, 0);
                }
            }
            System.out.println("체커 >> "+ checker);
            if (checker.size() == relation.length) {
                answer++;
                passCols.add(board);
            }
            return;
        }
        System.out.println("nonPassCols : " + nonePassCols);
        for(int i=start;i<nonePassCols.size();i++) {
            if (!visited[index] && board.indexOf(nonePassCols.get(i)) == -1) {
                visited[index] = true;
                board += nonePassCols.get(i);
                System.out.println("진입 전 board : " + board);
                dfs(i+1, length, index+1, relation);
                board = board.substring(0, board.length()-1);
                System.out.println("진입 후 board : " + board);
                visited[index] = false;
            }
        }
    }
}
