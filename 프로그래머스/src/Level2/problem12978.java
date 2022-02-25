package Level2;
import java.util.*;

public class problem12978 {


    static HashMap<Integer, HashMap<Integer, PriorityQueue<Integer>>> loadInfo = new HashMap<>();
    static Stack<Integer> passList = new Stack<>();
    static int sum;
    static boolean check;

    public static void main(String[] args) {
        problem12978 problem12978 = new problem12978();
//        problem12978.solution(5, new int[][]{{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}}, 3);
        problem12978.solution(6, new int[][]{{1,2,1},{1,3,2},{2,3,2},{3,4,3},{3,5,2},{3,5,3},{5,6,1}}, 4);
    }

    public int solution(int N, int[][] road, int K) {
        Stack<Integer> waitingList = new Stack<>();
        HashMap<Integer, Integer> answerStore = new HashMap<>();
        int answer = 0;
        int villiageNumber = 1;
        sum = 0;
        check = false;
        while(villiageNumber != N+1) {
            HashMap<Integer, PriorityQueue<Integer>> distanceInfo = new HashMap<>();
            for(int i=0;i<road.length;i++) {
                PriorityQueue<Integer> dst = new PriorityQueue<>();
                if (road[i][0] == villiageNumber && road[i][0] < K) {
                    if (distanceInfo.containsKey(road[i][1])) {
                        dst = distanceInfo.get(road[i][1]);
                        dst.add(road[i][2]);
                        distanceInfo.put(road[i][1], dst);
                    } else {
                        dst.add(road[i][2]);
                        distanceInfo.put(road[i][1], dst);
                    }
                }
                else if (road[i][1] == villiageNumber && road[i][0] < K) {
                    if (distanceInfo.containsKey(road[i][0])) {
                        dst = distanceInfo.get(road[i][0]);
                        dst.add(road[i][2]);
                        distanceInfo.put(road[i][0], dst);
                    } else {
                        dst.add(road[i][2]);
                        distanceInfo.put(road[i][0], dst);
                    }
                }
            }
            loadInfo.put(villiageNumber, distanceInfo);
            villiageNumber++;
        }

        for(int villiageNum: loadInfo.get(1).keySet()) {
            passList.push(1);
            waitingList.push(villiageNum);
            loadSearch(waitingList, K, 1, 1);
            for (int ele : passList) {
                answerStore.put(ele, 0);
            }
            passList.clear();
        }

        answer = answerStore.size();

        return answer;
    }

    static void loadSearch(Stack<Integer> waitingList, int time, int currentVilliage, int prevVilliage) {
        System.out.println("현재 거주중인 마을 : " + currentVilliage );
        System.out.println("passList >> " + passList);
        System.out.println("waitingList >> " + waitingList);
        System.out.println("loadInfo >> " + loadInfo);
        while(!waitingList.isEmpty()) {

            int pickVilliage = waitingList.peek();
            if (pickVilliage == currentVilliage) {
                return;
            }
            for(int dstNum: loadInfo.get(currentVilliage).get(pickVilliage)) {
                System.out.println("선택한 마을 : " + pickVilliage);
                System.out.println("현재 마을 : " + currentVilliage);
                System.out.println("안에서 waitList >> " + waitingList);
                System.out.println("dstNum : " + dstNum);
                if (sum + dstNum <= time) {
                    sum += dstNum;
                    passList.add(waitingList.peek());
//                    System.out.println(loadInfo.get(currentVilliage).get(pickVilliage));
//                    System.out.println("sum : " + sum);
                    for (int villNum : loadInfo.get(pickVilliage).keySet()) {
                        if (currentVilliage != villNum) {
                            waitingList.push(villNum);
                        }
                    }
                    loadSearch(waitingList, time, pickVilliage, currentVilliage);
                    System.out.println("끝난 시점 현재 마을 : " + currentVilliage);
                    System.out.println("끝난 시점 골랐던 마을 : " + pickVilliage);
//                waitingList.pop();
                    sum -= dstNum;
                } else {
                    break;
                }
            }
            if (!waitingList.isEmpty()) waitingList.pop();
            System.out.println("[현재 마을: " + currentVilliage + "] >> " + waitingList);
        }

    }

}
