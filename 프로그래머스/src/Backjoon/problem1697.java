package Backjoon;

import java.util.*;

public class problem1697 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        int answer = 0;
        boolean[] visited = new boolean[100001];

        int[] pos = new int[]{N, 0};
        Queue<int[]> queue = new LinkedList<>();

        queue.add(pos);
        while(!queue.isEmpty()) {
            int[] currentPos = queue.poll();
            if (currentPos[0] >= 0 && currentPos[0] <= 100000 && !visited[currentPos[0]]) {
                visited[currentPos[0]] = true;
                if (currentPos[0] == K) {
                    answer = currentPos[1];
                    break;
                }

                queue.add(new int[]{currentPos[0] - 1, currentPos[1] + 1});
                queue.add(new int[]{currentPos[0] + 1, currentPos[1] + 1});
                queue.add(new int[]{currentPos[0] * 2, currentPos[1] + 1});
            }
        }
        System.out.println(answer);
    }
}
