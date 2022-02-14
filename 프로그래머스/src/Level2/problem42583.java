package Level2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class problem42583 {

    public static void main(String[] args) {
        problem42583 problem42583 = new problem42583();
//        problem42583.solution(100,100, new int[]{10,10,10,10,10,10,10,10,10,10});
//        problem42583.solution(5,5,new int[]{1,1,1,1,1,2,2});
//        problem42583.solution(100,100,new int[]{10});
    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 1;
        Stack<Integer> waitList = new Stack<>();
        Queue<Integer> ridingTrucks = new LinkedList<>();
        int currentWeight = 0;
        int count = 0;
        int time = 1;
        int firstTruckWeight = 0;
        int ridingWeight = 0;
        for (int i=truck_weights.length-1;i>=0;i--) {
            waitList.push(truck_weights[i]);
        }

        System.out.println(waitList);

        while(!waitList.isEmpty()) {
            count = 0;
            currentWeight = waitList.pop();
            firstTruckWeight = currentWeight;
            count++;
            while(true) {
                if (waitList.isEmpty()) break;
                if (currentWeight + waitList.peek() <= weight) {
                    ridingTrucks.add(waitList.peek());
                    currentWeight += waitList.pop();
                    count++;
                } else break;
            }

            System.out.println("currentWeight : " + currentWeight);
            System.out.println("count : " + count);
            System.out.println("firstTruckWeight : " + firstTruckWeight);
            time += bridge_length;
            ridingWeight = currentWeight;
            for(int i=1;i<count;i++) {
               time += 1;
            }

            if (!waitList.isEmpty() && ridingTrucks.size() > 1) {
                for (int i = 1; i <= ridingTrucks.size(); i++) {
                    ridingWeight -= ridingTrucks.peek();
                    if (ridingWeight + waitList.peek() <= weight) {
                        time -= i;
                        break;
                    }
                }
            }

//            if (!waitList.isEmpty()) {
//                if (currentWeight - firstTruckWeight > 0 && currentWeight - firstTruckWeight + waitList.peek() <= weight) time -= 1;
//            }
            System.out.println("time : " + time);
        }

        answer = time;
        System.out.println(answer);

        return answer;
    }
}
