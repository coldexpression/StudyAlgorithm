package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem11367 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        for(int i=0;i<n;i++) {
            st = new StringTokenizer(bf.readLine());
            String name = st.nextToken();
            int score = Integer.parseInt(st.nextToken());
            sb.append(name).append(" ").append(getScore(score)).append("\n");
        }
        System.out.print(sb);
    }

    public static String getScore(int score) {
        if (score >= 97 && score <= 100) return "A+";
        else if (score >= 90 && score <= 96) return "A";
        else if (score >= 87 && score <= 89) return "B+";
        else if (score >= 80 && score <=86) return "B";
        else if (score >= 77 && score <= 79) return "C+";
        else if (score >= 70 && score <= 76) return "C";
        else if (score >= 67 && score <= 69) return "D+";
        else if (score >= 60 && score <= 66) return "D";
        return "F";
    }
}
