package Level2;

import java.util.*;

public class problem92342 {

    static boolean[] visited;
    static int maxDistance;
    static int[] ryanScoreBoard;
    static int[] winner;

    public static void main(String[] args) {
        problem92342 problem92342 = new problem92342();
//        problem92342.solution(5, new int[]{2,1,1,1,0,0,0,0,0,0,0});
//        problem92342.solution(1, new int[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        problem92342.solution(10, new int[]{0,0,0,0,0,0,0,0,3,4,3});
    }

    public int[] solution(int n, int[] info) {
        int[] answer = {};
        int count = 10;
        HashMap<Integer, Integer> apeachScoreBoard = new HashMap<>();
        visited = new boolean[11];
        maxDistance = 0;
        ryanScoreBoard = new int[11];
        winner = new int[11];
        Arrays.fill(ryanScoreBoard,-1);
        Arrays.fill(visited, false);
        Arrays.fill(winner, -1);
        for(int ele: info) {
            apeachScoreBoard.put(count, ele);
            count--;
        }

        dfs(0, 11, apeachScoreBoard, n, 0);

        if (winner[0] == -1 || maxDistance <= 0) {
            answer = new int[1];
            answer[0] = -1;
        } else answer = winner;

        return answer;
    }

    private void dfs(int start, int end, HashMap<Integer, Integer> apeachScoreBoard, int pivotArrowCount, int arrowCount) {
        if (arrowCount > pivotArrowCount) return;

        if (start == end && pivotArrowCount == arrowCount) {

            int count = 10;
            int distance = -1;
            int ryanScore = 0;
            int apeachScore = 0;

            for(int arrow: ryanScoreBoard) {
                if (!(apeachScoreBoard.get(count) == 0 && arrow == 0)) {
                    if (apeachScoreBoard.get(count) < arrow) ryanScore += count;
                    else apeachScore += count;
                }
                count--;
            }
            distance = ryanScore-apeachScore;

            if (distance <= 0) return;

            if (maxDistance <= distance) {
                if (distance == maxDistance) winner = thanBigger();
                else winner = ryanScoreBoard.clone();
                maxDistance = distance;
            }
        }

        for(int i=start;i<=10;i++) {
            if (!visited[i]) {
                int[] scoreList = findScoreList(apeachScoreBoard.get(10-i));
                visited[i] = true;
                for(int j=scoreList.length-1;j>=0;j--) {
                    ryanScoreBoard[i] = scoreList[j];
                    dfs(start + 1, end, apeachScoreBoard, pivotArrowCount, arrowCount + scoreList[j]);
                    ryanScoreBoard[i] = -1;
                }
                visited[i] = false;
            }
        }
    }

    private int[] findScoreList(int number) {
        int[] answer;
        if (number == 0) {
            answer = new int[2];
            answer[0] = 0;
            answer[1] = 1;
        } else {
            answer = new int[number+2];
            for(int i=0;i<answer.length;i++) answer[i] = i;
        }
        return answer;
    }

    private int[] thanBigger() {
        int ryan1 = 0;
        int ryan2 = 0;
        int[] answer = new int[11];

        for(int i=10;i>=0;i--) {
            ryan1 = winner[i];
            ryan2 = ryanScoreBoard[i];
            if (ryan1 > ryan2) {
                answer = winner.clone();
                break;
            }
            else if (ryan1 < ryan2) {
                answer = ryanScoreBoard.clone();
                break;
            }
        }

        return answer;
    }
}
