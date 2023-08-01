package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class problem28417 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int ans = 0;
        for(int i=0;i<n;i++) {
            st = new StringTokenizer(bf.readLine());
            int m1 = 0;
            int m2 = 0;
            for(int j=0;j<2;j++) m1 = Math.max(m1, Integer.parseInt(st.nextToken()));
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            while(st.hasMoreTokens()) pq.add(Integer.parseInt(st.nextToken()));
            m2 = pq.poll() + pq.poll();
            ans = Math.max(ans, m1 + m2);
        }
        System.out.println(ans);
    }
}
