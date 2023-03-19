package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class problem17240 {
    static int[][] arr;
    static int[][] brr;
    static int[][] crr;
    static int[][] drr;
    static int[][] err;
    static boolean[] visited;
    static int[] perm;
    static int n;
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n][2];
        brr = new int[n][2];
        crr = new int[n][2];
        drr = new int[n][2];
        err = new int[n][2];
        visited = new boolean[n];
        perm = new int[5];
        ans = -1;

        for(int i=0;i<n;i++) {
            st = new StringTokenizer(bf.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            brr[i][0] = Integer.parseInt(st.nextToken());
            crr[i][0] = Integer.parseInt(st.nextToken());
            drr[i][0] = Integer.parseInt(st.nextToken());
            err[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = brr[i][1] = crr[i][1] = drr[i][1] = err[i][1] = i;
        }

        Arrays.sort(arr, (o1, o2) -> o2[0] - o1[0]);
        Arrays.sort(brr, (o1, o2) -> o2[0] - o1[0]);
        Arrays.sort(crr, (o1, o2) -> o2[0] - o1[0]);
        Arrays.sort(drr, (o1, o2) -> o2[0] - o1[0]);
        Arrays.sort(err, (o1, o2) -> o2[0] - o1[0]);

        start(0);
        System.out.println(ans);
    }

    public static int[][] findArray(int roleNum) {
        switch (roleNum) {
            case 0 : return arr;
            case 1 : return brr;
            case 2 : return crr;
            case 3 : return drr;
            default: return err;
        }
    }

    public static void start(int currentRoleNum) {
        if (currentRoleNum == 5) {
            boolean[] peopleVisited = new boolean[n];
            int sum = 0;
            for(int i=0;i<5;i++) {
                int roleNum = perm[i];
                int[][] array = findArray(roleNum);

                for(int j=0;j<arr.length;j++) {
                    if (!peopleVisited[array[j][1]]) {
                        peopleVisited[array[j][1]] = true;
                        sum += array[j][0];
                        break;
                    }
                }
            }

            ans = Math.max(ans, sum);
            return;
        }

        for(int i=0;i<5;i++) {
            if (!visited[i]) {
                visited[i] = true;
                perm[currentRoleNum] = i;
                start(currentRoleNum + 1);
                visited[i] = false;
            }
        }

    }

}