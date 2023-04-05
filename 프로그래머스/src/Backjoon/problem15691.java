package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class problem15691 {

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int ans = 0;
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] belt = new int[n];
        for(int i=0;i<n;i++) {
            st = new StringTokenizer(bf.readLine());
            belt[i] = Integer.parseInt(st.nextToken());
        }
        HashMap<Integer, Integer> window = new HashMap<Integer, Integer>();
        window.put(c, 3000000);
        for(int i=0;i<k;i++) {
            window.put(belt[i], window.getOrDefault(belt[i], 0) + 1);
        }
        ans = Math.max(ans, window.size());

        for(int i=1;i<n;i++) {
            int start = i-1;
            int end = (i+k) - 1 >= n ? ((i+k)-1)%n : (i+k)-1;
            start = belt[start];
            end = belt[end];


            window.put(start, window.get(start) - 1);
            window.put(end, window.getOrDefault(end, 0) + 1);

            if (window.get(start) <= 0) window.remove(start);
            ans = Math.max(ans, window.size());
        }
        System.out.println(ans);
    }

}
