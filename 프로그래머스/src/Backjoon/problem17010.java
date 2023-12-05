package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem17010 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        for(int i=0;i<n;i++) {
            st = new StringTokenizer(bf.readLine());
            int count = Integer.parseInt(st.nextToken());
            String word = st.nextToken();
            for(int j=0;j<count;j++) sb.append(word);
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
