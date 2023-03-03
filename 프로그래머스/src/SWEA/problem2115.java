package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class problem2115 {

    static int n;
    static int m;
    static int c;
    static int[][] map;
    static boolean[][] visited;
    static StringBuilder sb;
    static String[] arr;
    static int ans;
    static int innerAns;

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        sb = new StringBuilder();
        StringBuilder ansSb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());
        for(int t=1;t<=T;t++) {
            st = new StringTokenizer(bf.readLine());

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            arr = new String[2];
            map = new int[n][n];
            visited = new boolean[n][n];
            ans = Integer.MIN_VALUE;
            for(int i=0;i<n;i++) {
                st = new StringTokenizer(bf.readLine());
                for(int j=0;j<n;j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            permulation(0, 0, 0);
            ansSb.append("#").append(t).append(" ").append(ans).append("\n");
        }
        System.out.println(ansSb);
    }

    public static void pick(int[] numbers, int[] pers, int index, int count) {
        if (count > m) return;
        int pivot = c;
        int sum = 0;

        for(int i=0;i<count;i++) {
            if (pivot >= pers[i]) {
                pivot -= pers[i];
                sum += (pers[i]*pers[i]);
            }
        }

        innerAns = Math.max(sum, innerAns);

        for(int i=index;i<m;i++) {
            pers[count] = numbers[i];
            pick(numbers, pers, i+1, count+1);
            pers[count] = 0;
        }
    }

    public static void start() {
        int score = 0;

        for (String input : arr) {
            innerAns = 0;
            String[] words = input.split(",");
            int sr = Integer.parseInt(words[0]);
            int sc = Integer.parseInt(words[1]);
            int[] numbers = new int[m];
            int[] pers = new int[m];

            for(int i=sc;i<sc+m;i++) numbers[i-sc] = map[sr][i];

            pick(numbers, pers, 0, 0);

            score += innerAns;
        }


        ans = Math.max(ans, score);
    }

    public static void permulation(int count, int rIdx, int cIdx) {
        if (count == 2) {
            // 설치할 별통의 위치를 모두 골랐으면 로직 실행
            start();
            return;
        }

        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if (isCheck(i, j)) {
                    fillVisited(i, j, 0);
                    sb.setLength(0);
                    sb.append(i).append(",").append(j);
                    arr[count] = sb.toString();
                    permulation(count + 1, i, j);
                    fillVisited(i, j, 1);
                }
            }
        }
    }

    public static boolean isCheck(int r, int c) {
        for(int i=c;i<c+m;i++) {
            if (i == n || visited[r][i]) return false;
        }

        return true;
    }

    public static void fillVisited(int r, int c, int type) {
        for(int i=c;i<c+m;i++) {
            visited[r][i] = type == 0;
        }
    }

}
