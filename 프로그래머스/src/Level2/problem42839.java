package Level2;

import java.util.*;

public class problem42839 {

    static boolean[] visited;
    static int max_length;
    static List<Integer> primeStore = new ArrayList<>();
    static List<Integer> indexStore = new ArrayList<>();
//    static List<Integer> logStore = new ArrayList<>();
    static HashMap<Integer, String> logStore = new HashMap<>();
    static String board;

    public static void main(String[] args) {
        problem42839 problem42839 = new problem42839();
        problem42839.solution("12345");
    }

    public int solution(String numbers) {
        int answer = 0;
        max_length = numbers.length();
        for(int i=1; i<=max_length;i++) {
            visited = new boolean[i];
            for(int j=0; j<visited.length;j++) visited[j] = false;
            board = "";
            dfs(0, i, numbers);
        }
        System.out.println(primeStore);
        answer = primeStore.size();
        System.out.println(answer);
        return answer;
    }

    static public void dfs(int count, int length, String numbers) {
        if (count == length) {
            findPrimeNumber();
        }

        if (length == 1) {
            for(int i=0;i<numbers.length();i++) {
                board = String.valueOf(numbers.charAt(i));
                findPrimeNumber();
            }
        } else {
            for (int i = 0; i < length; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    for (int j = 0; j<numbers.length();j++) {
                        if (board.length() > 0 && board.charAt(0) == '0') break;
                        if (!indexStore.contains(j)) {
                            indexStore.add(j);
                            board = board.concat(String.valueOf(numbers.charAt(j)));
//                            System.out.println("깊은 board : " + board);
                            dfs(count + 1, length, numbers);
                            indexStore.remove(indexStore.size()-1);
                            board = board.substring(0, board.length() - 1);
                        }
                    }
                    visited[i] = false;
                }
            }
        }
    }

    static public void findPrimeNumber() {
        int boardNumber = Integer.parseInt(board);
        if (logStore.containsKey(boardNumber)) return;
        logStore.put(boardNumber, "");
        System.out.println("boardNumber : " + boardNumber);
        if (boardNumber == 1 || boardNumber == 0) return;
        for(int i=2;i<= (int)Math.sqrt(boardNumber) ; i++) {
            if (boardNumber % i == 0) return;
        }

        if (!primeStore.contains(boardNumber)) primeStore.add(boardNumber);
    }
}
