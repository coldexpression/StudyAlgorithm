package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class problem9017 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(st.nextToken());
        for(int i=0;i<t;i++) {
            int n = Integer.parseInt(bf.readLine());
            st = new StringTokenizer(bf.readLine());
            int[] arr = new int[n];
            HashMap<Integer, List<Integer>> scoreMap = new HashMap<>();
            HashMap<Integer, List<Integer>> orderMap = new HashMap<>();
            HashMap<Integer, Integer> scoreCountMap = new HashMap<>();
            List<int[]> answerList = new ArrayList<>();
            int score = 1;
            for(int j=0;j<n;j++) {
                int team = Integer.parseInt(st.nextToken());
                arr[j] = team;
                scoreCountMap.put(team, scoreCountMap.getOrDefault(team, 0) + 1);
            }
            int index = 0;
            for (int team : arr) {
                if (scoreCountMap.get(team) < 6) continue;
                List<Integer> list = scoreMap.getOrDefault(team, new ArrayList<>());
                list.add(score++);
                scoreMap.put(team, list);

                list = orderMap.getOrDefault(team, new ArrayList<>());
                list.add(index++);
                orderMap.put(team, list);
            }

            for (int team : scoreMap.keySet()) {
                List<Integer> scoreList = scoreMap.get(team);
                List<Integer> orderList = orderMap.get(team);
                Collections.sort(scoreList);
                int sum = 0;
                for(int j=0;j<4;j++) sum += scoreList.get(j);
                answerList.add(new int[]{sum, orderList.get(4), team});
            }

            answerList.sort((o1, o2) -> {
                if (o1[0] == o2[0]) return o1[1] - o2[1];
                return o1[0] - o2[0];
            });

            sb.append(answerList.get(0)[2]).append("\n");
        }
        System.out.print(sb);
    }
}
