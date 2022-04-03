package Level3;

import java.util.*;

public class problem43105 {

    public static void main(String[] args) {
        problem43105 problem43105 = new problem43105();
        problem43105.solution(new int[][]{{7},{3,8},{8,1,0},{2,7,4,4},{4,5,2,6,5}});
    }

    public int solution(int[][] triangle) {
        int answer = 0;
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.add(triangle[0][0]);
        for(int i=1;i<triangle.length;i++){
            for(int j=0;j<triangle[i].length-1;j++){
                int pivotNum = deque.poll();
                if (i<2) {
                    deque.add(pivotNum + triangle[i][j]);
                    deque.add(pivotNum + triangle[i][j + 1]);
                } else {
                    if (j > 0 && j < triangle[i].length - 1) {
                        int num = deque.pollLast();
                        num = Math.max(num, (pivotNum + triangle[i][j]));
                        deque.add(num);
                        deque.add(pivotNum + triangle[i][j+1]);
                    } else {
                        deque.add(pivotNum + triangle[i][j]);
                        deque.add(pivotNum + triangle[i][j + 1]);
                    }
                }
                System.out.println(deque);
            }
        }
        answer = deque.stream().mapToInt(i -> i).max().getAsInt();
        System.out.println(answer);
        return answer;
    }
}
