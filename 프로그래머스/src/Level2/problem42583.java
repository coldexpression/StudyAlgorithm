package Level2;

import java.util.*;

public class problem42583 {

    public static void main(String[] args) {
        problem42583 problem42583 = new problem42583();
        Queue<Integer> ridingTrucks = new LinkedList<>();
        int currentWeight = 0;
//        ridingTrucks.add(1);
//        ridingTrucks.add(2);
//        ridingTrucks.add(3);
//        ridingTrucks.add(4);
//        for(int i=0;i<ridingTrucks.size();i++) {
//            currentWeight += ridingTrucks.element();
//            System.out.println(ridingTrucks.element());
//        }
//        System.out.println(currentWeight);
//        System.out.println(ridingTrucks.element());
//        problem42583.solution(100,100, new int[]{10,10,10,10,10,10,10,10,10,10});
        problem42583.solution(2,10,new int[]{7,4,5,6});
//        problem42583.solution(100,100,new int[]{10});
    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 1;
        Stack<Integer> waitTrucks = new Stack<>();
        Queue<Integer> ridingTrucks = new ArrayDeque<>();
        Queue<Integer> waitingTrucks = new LinkedList<>();
        int currentWeight = 0;
        int time = 1;
        int index = 0;


        for (int i=0;i<bridge_length - 1;i++) {
            ridingTrucks.add(0);
        }

        currentWeight = truck_weights[0];
        ridingTrucks.add(currentWeight);
        index = 1;

        while(!ridingTrucks.isEmpty()) {
            time++;

            int truck = ridingTrucks.poll();

            currentWeight -= truck;

            if (index < truck_weights.length) {
                if (currentWeight + truck_weights[index] <= weight) {
                    currentWeight += truck_weights[index];
                    ridingTrucks.add(truck_weights[index++]);
                } else {
                    ridingTrucks.add(0);
                }
            }
        }
        answer = time;
        System.out.println(answer);

        return answer;
    }
}
