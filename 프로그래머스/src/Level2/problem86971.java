package Level2;

import java.util.*;

public class problem86971 {

    public static void main(String[] args) {
        problem86971 problem86971 = new problem86971();
//        problem86971.solution(9, new int[][]{{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}});
        problem86971.solution(4, new int[][]{{1,2},{2,3},{3,4}});
    }

    public int solution(int n, int[][] wires) {
        int answer = -1;
        int topNum = 0;
        int[][] map = new int[n][n];


        map = init(map, n);
        map = mapCreate(map, wires, n);
        answer = wiresCut(map, wires, n);
        return answer;
    }

    private int[][] init(int[][] map, int n) {
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                map[i][j] = -1;
            }
        }
        return map;
    }

    private int[][] mapCreate(int[][] map, int[][] wires, int n) {
        int pick1 = 0;
        int pick2 = 0;
        for(int i=0;i<n-1;i++) {
            pick1 = wires[i][0] - 1;
            pick2 = wires[i][1] - 1;
            map[pick1][pick2] = 1;
            map[pick2][pick1] = 1;
        }
        return map;
    }

    private int wiresCut(int[][] map, int[][] wires, int n) {
        int sub1 = 0;
        int sub2 = 0;
        int total = 0;
        int answer = 1000;
        int count;
        int exclusiveNum;
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> passQueue = new LinkedList<>();
        for(int i=0;i<n-1;i++) {
            count = 1;
            exclusiveNum = wires[i][0] - 1;
            queue.add(wires[i][1] - 1);

            while(!queue.isEmpty()) {
                int pick = queue.poll();
                passQueue.add(pick);

                for(int j=0;j<n;j++) {
                    if (j != exclusiveNum && map[pick][j] == 1 && !queue.contains(j) && !passQueue.contains(j)) {
                        count++;
                        queue.add(j);
                    }
                }


            }
            passQueue.clear();

            sub1 = n - count;
            sub2 = count;
            total = Math.abs(sub1 - sub2);
            answer = Math.min(total, answer);
        }

        System.out.println(answer);
        return answer;
    }
}
