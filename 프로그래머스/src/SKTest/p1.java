package SKTest;

import java.util.*;

public class p1 {

    static int[] moneyStore = {500, 100, 50, 10, 5, 1};
    static boolean[] visited;
    static HashMap<Integer, Integer> store = new HashMap<>();
    static int answer;

    public static void main(String[] args) {
        p1 p1 = new p1();
        p1.solution(4578, new int[]{1, 4, 99, 35, 50, 1000});
    }

    public int solution(int money, int[] costs) {
        answer = 1000000;
        int cost = 0;
        visited = new boolean[moneyStore.length];
        for(int i=0;i< visited.length;i++) visited[i] = false;
        store.put(1, costs[0]);
        store.put(5, costs[1]);
        store.put(10, costs[2]);
        store.put(50, costs[3]);
        store.put(100, costs[4]);
        store.put(500, costs[5]);
        dfs(0, money, 0);
        System.out.println(answer);
        return answer;
    }

    private void dfs(int inputNum, int targetNum, int sum) {
        if (inputNum == targetNum) {
            System.out.println(sum);
            answer = Math.min(answer, sum);
            return;
        }

        if (inputNum < targetNum) {
            for (int i = 0; i < moneyStore.length; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    for (int j = 0; ; j++) {
                        if (inputNum + moneyStore[i] * j <= targetNum) {
                            if (inputNum == 0 && i == 5)
                                dfs(inputNum + moneyStore[i] * (j + 1), targetNum, sum + store.get(moneyStore[i]) * (j + 1));
                            else dfs(inputNum + moneyStore[i] * (j), targetNum, sum + store.get(moneyStore[i]) * (j));
                        } else break;
                    }
                    visited[i] = false;
                }
            }
        }
    }
}
