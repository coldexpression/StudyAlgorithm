package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class problem16637 {

    static long ans;

    public static void main(String[] args) throws NumberFormatException, IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String board = br.readLine();

        if (n > 1) {
            String[] exp = board.split("[0-9]");
            String[] ops = new String[exp.length-1];
            boolean[] visited = new boolean[ops.length];

            for(int i=1, index=0;i<exp.length;i++) ops[index++] = exp[i];

            exp = board.split("[*+-]");

            int[] nums = new int[exp.length];

            for(int i=0;i<exp.length;i++) nums[i] = Integer.parseInt(exp[i]);

            ans = Long.MIN_VALUE;


            int[] store = new int[ops.length];

            for(int i=0;i<ops.length;i++) store[i] = i;

            dfs(0, ops.length, 0, ops.length, nums, ops, visited, store);
        } else {
            ans = Long.parseLong(board);
        }


        System.out.println(ans);
    }

    public static long execute(int count, int[] nums, String[] ops, int[] store) {
        long sum = 0;
        Queue<Long> nQueue = new LinkedList<>();
        Queue<String> oQueue = new LinkedList<>();
        boolean[] numVisited = new boolean[nums.length];
        boolean[] opVisited = new boolean[ops.length];

        for(int i=0;i<count;i++) {
            opVisited[store[i]] = true;
            numVisited[store[i]] = numVisited[store[i]+1] = true;
        }

        for(int i=0;i<ops.length;i++) {
            if (opVisited[i]) {
                long out = calc(ops[i], nums[i], nums[i+1]);
                nQueue.add(out);
            } else {
                if (!numVisited[i]) {
                    nQueue.add((long)nums[i]);
                    numVisited[i] = true;
                }
                if (!numVisited[i+1]) {
                    nQueue.add((long)nums[i+1]);
                    numVisited[i+1] = true;
                }
                oQueue.add(ops[i]);
            }
        }


        long n1 = nQueue.poll();



        while(true) {
            long n2 = nQueue.poll();
            String op = oQueue.poll();

            sum += calc(op, n1, n2);

            n1 = sum;
            if (nQueue.isEmpty() || oQueue.isEmpty()) break;

            sum = 0;
        }


        return sum;
    }

    public static void dfs(int stIdx, int edIdx ,int stCount, int edCount, int[] nums, String[] ops, boolean[] visited, int[] store) {
        if (stCount >= edCount) return;


        if (stCount >= 0) {
            ans = Math.max(ans, execute(stCount, nums, ops, store));
        }

        if (stCount == 0) {
            for(int i=0;i<edIdx;i++) {
                if (!visited[stCount]) {
                    visited[stCount] = true;
                    store[stCount] = i;
                    dfs(i+2, edIdx, stCount + 1, edCount, nums, ops, visited, store);
                    store[stCount] = -1;
                    visited[stCount] = false;
                }
            }
        } else {
            for(int i=stIdx;i<edIdx;i++) {
                if (!visited[stCount]) {
                    visited[stCount] = true;
                    store[stCount] = i;
                    dfs(i+2, edIdx, stCount + 1, edCount, nums, ops, visited, store);
                    visited[stCount] = false;
                    store[stCount] = -1;
                }
            }
        }
    }


    public static long calc(String exp, long n1, long n2) {
        switch (exp) {
            case "+":
                return n1 + n2;
            case "-":
                return n1 - n2;
            default:
                return n1 * n2;
        }
    }
}