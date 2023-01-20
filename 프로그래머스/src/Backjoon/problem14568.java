package Backjoon;

import java.util.Scanner;

public class problem14568 {

    static int ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] people = new int[3];

        ans = 0;
        dfs(0, people, N, 0);

        System.out.println(ans);
    }

    static void dfs(int count, int[] people, int N, int sum){
        if (count == 3) {
            if (sum == N) {
                if (people[0] == 0 || people[1] == 0 || people[2] == 0) return;
                if (people[0] % 2 == 0 && people[1] + 2 <= people[2]) {
                    ans++;
                }
            }
            return ;
        }

        for(int i=1;i<=N;i++) {
            people[count] += i;
            dfs(count+1, people, N, sum + i);
            people[count] -= i;
        }
    }
}
