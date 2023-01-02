package Backjoon;

import java.util.Scanner;

public class problem2004 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] store = new int[3];

        store[0] = N;
        store[1] = M;
        store[2] = N - M;

        int[][] box = new int[3][2];

        for(int i=0;i<3;i++) {
            box[i][0] = findZeroByFive(store[i]);
            box[i][1] = findZeroByTwo(store[i]);
        }

        box[0][0] -= box[1][0] + box[2][0];
        box[0][1] -= box[1][1] + box[2][1];

        System.out.println(Math.min(box[0][0], box[0][1]));
    }

    static public int findZeroByFive(int num) {
        if (num == 0) return 0;

        long div = 1;
        int ans = 0;

        while(div <= num) {
            div *= 5;
            ans += num / div;
        }

        return ans;
    }

    static public int findZeroByTwo(int num) {
        if (num == 0) return 0;

        long div = 1;
        int ans = 0;

        while(div <= num) {
            div *= 2;
            ans += num / div;
        }

        return ans;
    }
}
