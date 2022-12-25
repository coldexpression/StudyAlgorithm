package Backjoon;

import java.util.*;

public class problem1931 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int answer = 0;
        int N = sc.nextInt();
        List<int[]> list = new ArrayList<>();

        for(int i=0;i<N;i++) {
            int st = sc.nextInt();
            int et = sc.nextInt();
            list.add(new int[]{st, et});
        }

        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });

        int prev = list.get(0)[1];

        answer++;

        for(int i=1;i<list.size();i++) {
            int start = list.get(i)[0];
            int end = list.get(i)[1];

            if (start >= prev) {
                answer++;
                prev = end;
            }
        }

        System.out.println(answer);
    }
}
