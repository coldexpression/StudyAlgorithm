package Backjoon;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class problem1090 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] row = new int[N];
        int[] col = new int[N];
        int[] ans = new int[N];

        Arrays.fill(ans, Integer.MAX_VALUE);

        for(int i=0;i<N;i++) {
            col[i] = sc.nextInt();
            row[i] = sc.nextInt();
        }

        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                int mRow = row[i];
                int mCol = col[j];
                int[] store = new int[N];

                for(int k=0;k<N;k++) {
                    store[k] = Math.abs(mRow - row[k]) + Math.abs(mCol - col[k]);
                }

                Arrays.sort(store);

                int sum = 0;

                for(int k=0;k<N;k++) {
                    sum += store[k];
                    ans[k] = Math.min(ans[k], sum);
                }
            }
        }

        Arrays.stream(ans).forEach(x -> System.out.print(x + " "));
    }

}
