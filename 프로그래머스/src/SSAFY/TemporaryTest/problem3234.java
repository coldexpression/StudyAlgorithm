package SSAFY.TemporaryTest;

import java.util.Scanner;

public class problem3234 {

    static int ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();

        for(int t=1;t<=T;t++) {
            int N = sc.nextInt();

            ans = 0;

            int[] weight = new int[N];
            boolean[] check = new boolean[N];

            for(int i=0;i<N;i++) weight[i] = sc.nextInt();

            dfs(0, N, 0, 0, weight, check);

            sb.append("#").append(t).append(" ").append(ans).append("\n");
        }

        System.out.println(sb.toString());
    }

    static void dfs(int count, int endCount, int leftSum, int rightSum, int[] weight, boolean[] check) {
        if (rightSum > leftSum) return;
        if (count == endCount) {
            ans++;
            return;
        }

        for(int i=0;i<weight.length;i++) {
            if (!check[i]) {
                check[i] = true;
                dfs(count + 1, endCount, leftSum + weight[i], rightSum, weight, check);
                dfs(count + 1, endCount, leftSum, rightSum + weight[i], weight, check);
                check[i] = false;
            }
        }
    }
}
