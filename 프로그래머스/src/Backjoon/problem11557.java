package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class problem11557 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(st.nextToken());
        for(int i=0;i<t;i++) {
            HashMap<String, Integer> map = new HashMap<>();
            st = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(st.nextToken());
            for(int j=0;j<n;j++) {
                st = new StringTokenizer(bf.readLine());
                String school = st.nextToken();
                int score = Integer.parseInt(st.nextToken());
                map.put(school, map.getOrDefault(school, 0) + score);
            }
            int max = -1;
            String ans = "";
            for(String key: map.keySet()) {
                int input = map.get(key);
                if (input > max) {
                    max = input;
                    ans = key;
                }
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}
