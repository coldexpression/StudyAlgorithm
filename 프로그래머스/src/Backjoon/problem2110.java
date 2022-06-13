package Backjoon;

import java.util.*;

public class problem2110 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int answer = 1;
        int n = sc.nextInt();
        int c = sc.nextInt();
        int count = 1;

        int[] home = new int[n];
        for (int i = 0; i < n; i++) home[i] = sc.nextInt();
        Arrays.sort(home);

        int start = 1;
        int end = home[n-1];
        int middle = 0;

        while(true) {
            if (start == end || start + 1 == end) break;
            int pivot = home[0];
            count = 1;
            middle = (start+end) / 2;

            for(int i=0;i<n;i++) {
                if (pivot + middle <= home[i]) {
                    pivot = home[i];
                    count++;
                }
            }

            if (count < c) {
                end = middle;
            } else {
                answer = Math.max(middle, answer);
                start = middle;
            }
        }

        System.out.println(answer);
    }
}
