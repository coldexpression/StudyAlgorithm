package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class problem17835 {

    static HashMap<Integer, List<Node>> map;
    static long[] dst;

    public static class Node {
        private int index;
        private int val;

        public Node(int val, int index) {
            this.val = val;
            this.index = index;
        }


    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine();
        String[] word = input.split(" ");

        int n = Integer.parseInt(word[0]);
        int m = Integer.parseInt(word[1]);
        int k = Integer.parseInt(word[2]);

        dst = new long[n + 1];

        map = new HashMap<>();
        int[] companys = new int[k];

        for (int i = 1; i <= n; i++)
            map.put(i, new ArrayList<>());

        for (int i = 1; i <= m; i++) {
            input = bf.readLine();
            word = input.split(" ");

            int st = Integer.parseInt(word[1]);
            int ed = Integer.parseInt(word[0]);
            int val = Integer.parseInt(word[2]);

            List<Node> list = map.get(st);
            list.add(new Node(val, ed));
        }

        input = bf.readLine();
        word = input.split(" ");

        for (int i = 0; i < k; i++) {
            companys[i] = Integer.parseInt(word[i]);
        }

        Arrays.fill(dst, Integer.MAX_VALUE);

        dijk(companys);

        long max = Long.MIN_VALUE;
        int maxIndex = 0;

        for(int i=1;i<=n;i++) {
            if (dst[i] > max) {
                max = dst[i];
                maxIndex = i;
            }
        }

        System.out.println(maxIndex);
        System.out.println(max);
    }



    public static void dijk(int[] companys) {
        PriorityQueue<long[]> queue = new PriorityQueue<>(new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2) {
                if (o1[1] == o2[1]) return (int)(o1[0] - o2[0]);
                return (int)(o1[1]-o2[1]);
            }
        });

        for (int company : companys) {
            queue.add(new long[]{company, 0});
            dst[company] = 0;
        }


        while (!queue.isEmpty()) {
            long[] currentInfo = queue.poll();
            int index = (int)currentInfo[0];

            if (dst[index] < currentInfo[1]) continue;

            for (Node nextNode : map.get(index)) {

//                if (dst[nextNode.index] < dst[index] + nextNode.val) continue;

                if (dst[nextNode.index] > dst[index] + nextNode.val) {
                    dst[nextNode.index] = dst[index] + nextNode.val;
                    queue.add(new long[]{nextNode.index, dst[nextNode.index]});
                }
            }
        }
    }

}