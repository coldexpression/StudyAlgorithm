package Level3;


import java.util.*;

public class problem152995 {

    public static void main(String[] args) {
        problem152995 problem152995 = new problem152995();

    }

    public int solution(int[][] scores) {
        int answer = 0;

        if (scores.length == 1) return 1;

        int[][] pScores = new int[scores.length][3];
        boolean[] visited = new boolean[scores.length];

        for (int i = 0; i < pScores.length; i++) {
            pScores[i][0] = scores[i][0];
            pScores[i][1] = scores[i][1];
            pScores[i][2] = i;
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // TODO Auto-generated method stub
                int sumA = o1[0] + o1[1];
                int sumB = o2[0] + o2[1];
                if (sumA == sumB) {
                    return o2[0] - o1[0];
                }
                return sumB - sumA;
            }
        });

        Arrays.stream(pScores).forEach(x -> queue.add(new int[]{x[0], x[1], x[2]}));


        int currentRank = 0;
        int pivot = 200001;
        int totalCount = 0;


        while (!queue.isEmpty()) {
            int[] info = queue.poll();
            int sum = info[0] + info[1];

            if (!visited[info[2]]) {
                totalCount++;
                if (pivot > sum) {
                    pivot = sum;
                    currentRank = totalCount;
                }
            }

            if (info[2] == 0) break;

            for (int[] ints : pScores) {
                if (!visited[ints[2]] && ints[0] < info[0] && ints[1] < info[1]) {
                    visited[ints[2]] = true;
                    if (ints[2] == 0) return -1;
                }
            }


        }

        answer = visited[0] ? -1 : currentRank;
        return answer;
    }
}
