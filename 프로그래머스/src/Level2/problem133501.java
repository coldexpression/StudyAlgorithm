package Level2;

import java.util.Comparator;
import java.util.PriorityQueue;

public class problem133501 {

    public static void main(String[] args) {
        problem133501 problem133501 = new problem133501();
//        problem133501.solution(10, new int[][]{{3,4},{5,8}}, new int[][]{{2,5},{4,3}});
        problem133501.solution(12, new int[][]{{7,8},{4,6},{11,10}}, new int[][]{{2,2},{2,4},{3,3}});
    }

    public class Node {
        private int[] workPos;

        private int[] time;

        public Node(int[] workPos, int[] time) {
            this.workPos = workPos;
            this.time = time;
        }
    }

    public int solution(int distance, int[][] scope, int[][] times) {
        int answer = 0;
        int policeNum = scope.length;
        PriorityQueue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.workPos[0] - o2.workPos[0];
            }
        });

        for(int i=0;i<policeNum;i++) {
            int temp = scope[i][1];
            if (scope[i][0] > scope[i][1]) {
                scope[i][1] = scope[i][0];
                scope[i][0] = temp;
            }
            queue.add(new Node(scope[i], times[i]));
        }

        int currentTime = 0;

        while(!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.println("scope : [" + node.workPos[0] + ", " + node.workPos[1] + "]");
            System.out.println("times : [" + node.time[0] + ", " + node.time[1] + "]");

            if (currentTime + node.time[0] >= node.workPos[0] && currentTime + node.time[0] <= node.workPos[1]) {
                answer = node.workPos[0] - 1;
                break;
            }

            currentTime += node.time[0] + node.time[1];



        }

        answer = Math.min(answer, distance);

        System.out.println(answer);

        return answer;
    }
}
