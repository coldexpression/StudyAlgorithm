package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class problem17615 {
    static class Node {
        private int bCnt;
        private int rCnt;
        public Node(int bCnt, int rCnt) {
            this.bCnt = bCnt;
            this.rCnt = rCnt;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        Queue<Node> rq = new LinkedList<>();
        Queue<Node> bq = new LinkedList<>();
        int n = Integer.parseInt(st.nextToken());
        int answer = Integer.MAX_VALUE;
        String input = bf.readLine();

        answer = start('F', input, n);
        answer = Math.min(answer, start('B', input, n));

        System.out.println(answer);
    }

    public static int start(char dir, String input, int n) {
        int rCnt = 0;
        int bCnt = 0;
        int count = 0;
        char color = 0;
        int answer = Integer.MAX_VALUE;
        Queue<Node> rq = new LinkedList<>();
        Queue<Node> bq = new LinkedList<>();
        if (dir == 'F') {
            for(int i=n-1;i>=0;i--) {
                if (i != n - 1) {
                    if (color == 'R') rCnt++;
                    else bCnt++;
                }
                color = input.charAt(i);
                if (color == 'R') rq.add(new Node(bCnt, rCnt));
                if (color == 'B') bq.add(new Node(bCnt, rCnt));
            }
        } else {
            for(int i=0;i<n;i++) {
                if (i != 0) {
                    if (color == 'R') rCnt++;
                    else bCnt++;
                }
                color = input.charAt(i);
                if (color == 'R') rq.add(new Node(bCnt, rCnt));
                if (color == 'B') bq.add(new Node(bCnt, rCnt));
            }
        }

        while(!rq.isEmpty()) count = rq.poll().bCnt > 0 ? count + 1 : count;

        answer = Math.min(answer, count);
        count = 0;
        while(!bq.isEmpty()) count = bq.poll().rCnt > 0 ? count + 1 : count;
        answer = Math.min(answer, count);

        return answer;
    }

}
