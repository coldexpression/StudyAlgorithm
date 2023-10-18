package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class problem1700 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        HashSet<Integer> multiTab = new HashSet<>();
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int answer = 0;
        int[] arr = new int[k];
        st = new StringTokenizer(bf.readLine());
        for(int i=0;i<k;i++) arr[i] = Integer.parseInt(st.nextToken());
        int cursor = 0;
        while (multiTab.size() != n) {
            if (cursor == k) break;
            multiTab.add(arr[cursor++]);
        }

        HashMap<Integer, List<Integer>> scheduler = new HashMap<>();
        for(int i=cursor;i<k;i++) {
            if (!scheduler.containsKey(arr[i])) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                scheduler.put(arr[i], list);
            } else {
                scheduler.get(arr[i]).add(i);
            }
        }

        for(int i=cursor;i<k;i++) {
            if (multiTab.contains(arr[i])) {
                scheduler.get(arr[i]).remove(0);
                continue;
            }
            int outProduct = 0;
            int step = -1;
            for (int product : multiTab) {
                if (scheduler.getOrDefault(product, new ArrayList<>()).isEmpty()) {
                    outProduct = product;
                    break;
                }
                int nextStep = scheduler.get(product).get(0);
                if (step < nextStep) {
                    step = nextStep;
                    outProduct = product;
                }
            }
            if (!scheduler.get(arr[i]).isEmpty()) scheduler.get(arr[i]).remove(0);
            multiTab.remove(outProduct);
            multiTab.add(arr[i]);
            answer++;
        }
        System.out.println(answer);
    }
}