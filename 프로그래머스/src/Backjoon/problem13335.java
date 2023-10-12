package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class problem13335 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int[] trucks = new int[n];
        int[] times = new int[n];
        Arrays.fill(times, w);
        List<Integer> bridge = new ArrayList<>();
        st = new StringTokenizer(bf.readLine());
        for(int i=0;i<n;i++) trucks[i] = Integer.parseInt(st.nextToken());
        int time = 0;
        int index = 0;
        int cWeight = 0;
        while(true) {
            if (index == n && bridge.isEmpty()) break;

            if (index < n) {
                if (bridge.isEmpty()) {
                    bridge.add(index);
                    cWeight += trucks[index];
                    index++;
                } else {
                    if (cWeight + trucks[index] <= l) {
                        bridge.add(index);
                        cWeight += trucks[index];
                        index++;
                    }
                }
            }

            for(int i=0;i<bridge.size();i++) {
                times[bridge.get(i)]--;
                if (times[bridge.get(i)] == 0) {
                    cWeight -= trucks[bridge.get(i)];
                    bridge.remove(i);
                    i--;
                }
            }

            time++;
        }
        System.out.println(time+1);
    }
}
