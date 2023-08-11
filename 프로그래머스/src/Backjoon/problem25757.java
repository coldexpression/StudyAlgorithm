package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class problem25757 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        String game = st.nextToken();
        HashSet<String> passSet = new HashSet<>();
        HashSet<String> currSet = new HashSet<>();

        int size = game.equals("Y") ? 1 : game.equals("F") ? 2 : 3;
        int ans = 0;
        for(int i=0;i<n;i++) {
            String name = bf.readLine();
            if (!passSet.contains(name)) {
                passSet.add(name);
                if (currSet.size() == size) currSet.clear();
                currSet.add(name);
                ans = currSet.size() == size ? ans + 1 : ans;
            }
        }
        System.out.print(ans);
    }
}
