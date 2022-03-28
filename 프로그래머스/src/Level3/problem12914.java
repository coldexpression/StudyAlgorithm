package Level3;

import java.util.*;

public class problem12914 {

    static long count;

    public static void main(String[] args) {
        problem12914 problem12914 = new problem12914();
        problem12914.solution(4);
    }

    public long solution(int n) {
        long answer = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for(int i=2;i<n;i++) dp[i] = (dp[i-2] + dp[i-1]) % 1234567;
        System.out.println(dp[n-1]);
//        List<Integer> list = new ArrayList<>();
//        Queue<List<Integer>> queue = new LinkedList<>();
//        HashSet<String> currentStore = new HashSet<>();
//        for(int i=0;i<n;i++) list.add(1);
//        queue.add(list);
//        answer++;
//        while(!queue.isEmpty()) {
//            List<Integer> currentList = queue.poll();
//            System.out.println("현재 리스트 : " + currentList );
//            for(int i=0;i<currentList.size()-1;i++) {
//                if (currentList.get(i) == 1 && currentList.get(i+1) == 1) {
//                    List<Integer> tempList = new ArrayList<>(currentList);
//                    tempList.remove(i);
//                    tempList.remove(i);
//                    tempList.add(i, 2);
//                    System.out.println("i 값 : " + i);
//                    System.out.println(tempList);
//                    if (!currentStore.contains(tempList.toString())) {
//                        currentStore.add(tempList.toString());
//                        queue.add(tempList);
//                        answer++;
//                    }
//                }
//            }
//        }
//        System.out.println(answer);
        return answer;
    }
}
