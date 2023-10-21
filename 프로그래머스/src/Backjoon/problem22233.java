package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class problem22233 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashSet<String> keyword = new HashSet<>();
        for(int i=0;i<n;i++) keyword.add(bf.readLine());
        for(int i=0;i<m;i++) {
            String input = bf.readLine();
            String[] word = input.split(",");
            for (String s : word) keyword.remove(s);
            sb.append(keyword.size()).append("\n");
        }
        System.out.print(sb);
    }
}
