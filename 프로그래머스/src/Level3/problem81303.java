package Level3;

import java.util.*;

public class problem81303 {

    public static void main(String[] args) {
        problem81303 problem81303 = new problem81303();
        problem81303.solution(8, 2, new String[]{"D 2","C","U 3","C","D 4","C","U 2","Z","Z"});
//        problem81303.solution(8, 2, new String[]{"D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"});
    }

    public String solution(int n, int k, String[] cmd) {
        String answer = "";
        HashMap<Integer, Integer> board = new HashMap<>();
        Stack<Integer> junk = new Stack<>();
        int lastIndex = n-1;
        for(int i=0;i<n;i++) {
            board.put(i, 0);
        }

        System.out.println("초기 노드 : " + board);

        for(String command: cmd) {
            System.out.println("현재 인덱스 >> " + k);
            if (command.equals("C")) {
                board.put(k, 1);
                System.out.println("삭제 인덱스 : " + k);
                junk.add(k);
                if (k == lastIndex) {
                    lastIndex = findLastIndex(board, lastIndex);
                    k = lastIndex;
                } else {
                    k = findIndex(board, k);
                }

                System.out.println("삭제 후 노드 : " + board);
            } else if (command.equals("Z")) {
                int rollBackIndex = junk.pop();
                System.out.println("복구 인덱스 : " + rollBackIndex);
                lastIndex = Math.max(rollBackIndex, lastIndex);
                board.put(rollBackIndex, 0);
                System.out.println("되돌리기 후 노드 : " + board);
            } else {
                String direction = command.split(" ")[0];
                int distance = Integer.parseInt(command.split(" ")[1]);
                k = move(board, direction, k, distance);
            }
        }
        System.out.println(board);
        answer = check(board);
        System.out.println(answer);
        return answer;
    }

    private int findIndex(HashMap<Integer, Integer> board,int index) {
        for(int i=index+1;i<board.size();i++)
            if (board.get(i) == 0) return i;

            return index;
    }

    private int findLastIndex(HashMap<Integer, Integer> board, int index) {
        for(int i=index;i>=0;i--) {
            if (board.get(i) == 0) return i;
        }
        return index;
    }

    private String check(HashMap<Integer, Integer> board) {
        String answer = "";
        StringBuilder sb = new StringBuilder(answer);
        for(int i=0;i<board.size();i++) {
            if (board.get(i) == 1) {
                sb.append("X");
            } else {
                sb.append("O");
            }
        }

        answer = sb.toString();
        return answer;
    }

    private int move(HashMap<Integer ,Integer> board, String direction, int currentIndex, int distance) {
        int nextIndex = 0;
        if (direction.equals("U")) {
            for(int i=currentIndex-1;i>=0;i--) {
                if (distance == 0) break;
                if (board.get(i) == 0) {
                    nextIndex = i;
                    distance--;
                }
            }
        } else {
            for(int i=currentIndex+1;i<board.size();i++) {
                if (distance == 0) break;
                if(board.get(i) == 0) {
                    nextIndex = i;
                    distance--;
                }
            }
        }
        return nextIndex;
    }

}
