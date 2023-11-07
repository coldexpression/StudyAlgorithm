package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class problem3758 {
    static class Team{
        private int team;
        private int time;
        private int score;
        private int submitCnt;
        private int[] problems;

        public Team(int team, int time, int score, int submitCnt, int k) {
            this.time = time;
            this.team = team;
            this.score = score;
            this.problems = new int[k];
            this.submitCnt = submitCnt;
            Arrays.fill(this.problems, -1);
        }

        public void setScore(int score) {
            this.score = score;
        }

        public void updateTime(int time) {
            this.time = time;
        }

        public void submit() {
            this.submitCnt += 1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(st.nextToken());
        for(int test=0;test<T;test++) {
            st = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            Team[] teams = new Team[n];
            for(int index=0;index<n;index++) teams[index] = new Team(index+1,0, 0, 0,k);

            for(int index=0,timer=0;index<m;index++,timer++) {
                st = new StringTokenizer(bf.readLine());
                int i = Integer.parseInt(st.nextToken()) - 1;
                int j = Integer.parseInt(st.nextToken()) - 1;
                int s = Integer.parseInt(st.nextToken());
                if (teams[i].problems[j] < s) {
                    if (teams[i].problems[j] == -1) teams[i].setScore(teams[i].score + s);
                    else teams[i].setScore(teams[i].score + (s - teams[i].problems[j]));
                    teams[i].problems[j] = s;
                }
                teams[i].updateTime(timer);
                teams[i].submit();
            }

            Arrays.sort(teams, (o1, o2) -> {
                if (o1.score == o2.score) {
                    if (o1.submitCnt == o2.submitCnt) return o1.time - o2.time;
                    return o1.submitCnt - o2.submitCnt;
                }
                return o2.score - o1.score;
            });

            int rank = 0;
            for(int index=0;index<n;index++) {
                if (teams[index].team == t) {
                    rank = index + 1;
                    break;
                }
            }
            sb.append(rank).append("\n");
        }
        System.out.print(sb);
    }
}
