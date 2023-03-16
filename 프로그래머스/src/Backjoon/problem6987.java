package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class problem6987 {

    static int N;
    static int[] win;
    static int[] lose;
    static int[] draw;

    static int[] team1;
    static int[] team2;

    static boolean check;


    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        win = new int[6];
        lose = new int[6];
        draw = new int[6];

        team1 = new int[15];
        team2 = new int[15];

        int cnt = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = i + 1; j < 6; j++) {
                team1[cnt] = i;
                team2[cnt] = j;
                cnt++;
            }
        }

        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int idx = 0;
            int sum = 0;
            for (int j = 0; j < 18; j += 3) {
                win[idx] = Integer.parseInt(st.nextToken());
                draw[idx] = Integer.parseInt(st.nextToken());
                lose[idx] = Integer.parseInt(st.nextToken());
                sum += win[idx] + draw[idx] + lose[idx];
                idx++;
            }
            check = false;

            if (sum == 30) dfs(0);


            sb.append(check ? 1 : 0).append(" ");
        }

        System.out.println(sb);
    }

    public static void dfs(int index) {
        if (check) return;

        if (index == 15) {
            check = true;
            return;
        }

        int t1 = team1[index];
        int t2 = team2[index];


        if (win[t1] > 0 && lose[t2] > 0) {
            win[t1]--;
            lose[t2]--;
            dfs(index+1);
            win[t1]++;
            lose[t2]++;
        }

        if (draw[t1] > 0 && draw[t2] > 0) {
            draw[t1]--;
            draw[t2]--;
            dfs(index + 1);
            draw[t1]++;
            draw[t2]++;
        }

        if (lose[t1] > 0 && win[t2] > 0) {
            lose[t1]--;
            win[t2]--;
            dfs(index + 1);
            lose[t1]++;
            win[t2]++;
        }

    }
}