package Backjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class problem17471 {

    static int A;
    static int B;
    static int ans;
    static int totalPeople;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        totalPeople = 0;

        HashMap<Integer, List<Integer>> map = new HashMap<>();

        int[] peopleCount = new int[N];
        int[] villige = new int[N];
        boolean[] visited = new boolean[N];

        for(int i=0;i<N;i++) {
            peopleCount[i] = sc.nextInt();
            totalPeople += peopleCount[i];
        }

        for(int i=0;i<N;i++) {
            List<Integer> list = new ArrayList<>();

            int count = sc.nextInt();

            for(int j=0;j<count;j++) list.add(sc.nextInt() - 1);

            map.put(i, list);

        }

        A = B = 0;
        ans = Integer.MAX_VALUE;

        dfs(map, 0, villige, visited, peopleCount,N);

        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }

    static void findArea(int type, HashMap<Integer, List<Integer>> map ,int[] villige, int[] peopleCount,int stVNum, int N) {
        if (type == 1 && A > 0) return;
        if (type == 2 && B > 0) return;

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N];

        queue.add(stVNum);
        visited[stVNum] = true;

        if (type == 1) A += peopleCount[stVNum];
        else B += peopleCount[stVNum];

        while(!queue.isEmpty()) {
            int pick = queue.poll();

            List<Integer> list = map.getOrDefault(pick, new ArrayList<>());
            if (list.isEmpty()) return;

            for (int ele : list) {
                if (!visited[ele] && villige[ele] == type) {
                    visited[ele] = true;
                    queue.add(ele);

                    if (type == 1) A += peopleCount[ele];
                    else B += peopleCount[ele];
                }
            }
        }


    }

    static void dfs(HashMap<Integer, List<Integer>> map ,int count, int[] villige, boolean[] visited, int[] peopleCount, int N) {
        if (count == villige.length) {
            /* 마을 유효성 검사 [type -> 1 : A구역 , 2 : B구역] */
            A = 0;
            B = 0;
            for(int i=0;i<N;i++) {
                findArea(villige[i], map, villige, peopleCount ,i, N);
            }

            ans = A + B == totalPeople ? Math.min(ans,  Math.abs(A-B)) : ans;

            return;
        }

        for(int i=1;i<=2;i++) {
            if(!visited[count]) {
                visited[count] = true;
                villige[count] = i;
                dfs(map, count+1, villige, visited, peopleCount,N);
                villige[count] = 0;
                visited[count] = false;
            }
        }
    }


}