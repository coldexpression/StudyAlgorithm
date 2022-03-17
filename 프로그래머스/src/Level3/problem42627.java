package Level3;

import java.util.*;

public class problem42627 {

    public static void main(String[] args) {
        problem42627 problem42627 = new problem42627();
//        problem42627.solution(new int[][]{{0,3},{1,9},{2,6}});
//        problem42627.solution(new int[][]{{0,3},{4,4},{5,3},{4,1}});
        problem42627.solution(new int[][]{{0,4},{0,3},{0,2},{0,1}});
    }

    public int solution(int[][] jobs) {
        HashMap<Integer, PriorityQueue<Integer>> waitList = new HashMap<>();
        PriorityQueue<Integer> timeList = new PriorityQueue<>();
        PriorityQueue<Integer> scoreList = new PriorityQueue<>();

        int answer = 0;
        int finishTime = 1001;
        int removeKey = -1;

        for (int i = 0; i < jobs.length; i++) {
            waitList.put(jobs[i][0], timeList);
            finishTime = Math.min(finishTime, jobs[i][0]);
        }

        for (int key : waitList.keySet()) {
            timeList = new PriorityQueue<>();
            for (int i = 0; i < jobs.length; i++) {
                if (jobs[i][0] == key) {
                    timeList.add(jobs[i][1]);
                }
            }
            waitList.put(key, timeList);
        }

//        scoreList.add(jobs[0][1]);
//        jobs[0][0] = -1;
//        finishTime = jobs[0][1];

        while (scoreList.size() != jobs.length) {
            int useTime = 100001;
            int nextPoint = 100001;
            removeKey = -1;
            System.out.println("대기 리스트" + waitList);
            for (int subKey : waitList.keySet()) {
                System.out.println("요청 시간 : " + subKey);
                System.out.println("작업 시간 : " + waitList.get(subKey));
                if (!waitList.get(subKey).isEmpty()) {
                    int pick = waitList.get(subKey).peek();
                    boolean check = false;
                    for (int i = 0; i < jobs.length; i++) {
                        if (jobs[i][0] == subKey && jobs[i][1] == pick) {
                            check = true;
                            break;
                        }
                    }

                    System.out.println("finishTime : " + finishTime);
                    System.out.println("check : " + check);

                    if (check) {
                        if (subKey <= finishTime && useTime > finishTime + pick - subKey) {
                            useTime = finishTime + pick - subKey;
                            removeKey = subKey;
                        } else if (subKey > finishTime) {
                            nextPoint = Math.min(nextPoint, subKey);
                        }
                    } else {
                        waitList.get(subKey).poll();
                    }
                }
            }

            if (removeKey != -1) {
                int pickNum = waitList.get(removeKey).peek();
                for(int i=0;i<jobs.length;i++)
                    if (jobs[i][0] == removeKey && jobs[i][1] == pickNum) {
                        jobs[i][0] = -1;
                        break;
                    }
                scoreList.add(useTime);
                finishTime = finishTime + pickNum;
                waitList.get(removeKey).poll();
                if (waitList.get(removeKey).isEmpty()) waitList.remove(removeKey);
            } else {
                for(int i=0;i<jobs.length;i++) {
                    if (jobs[i][0] != -1) {
                        finishTime = jobs[i][0];
                        scoreList.add(jobs[i][1]);
                        finishTime += jobs[i][1];
                        jobs[i][0] = -1;
                        break;
                    }
                }
            }

        }

        System.out.println(scoreList);
        while(!scoreList.isEmpty()) answer += scoreList.poll();
        answer /= jobs.length;
        System.out.println("정답 : " + answer);
        return answer;
    }

}
