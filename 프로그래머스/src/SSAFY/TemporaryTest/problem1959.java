package SSAFY.TemporaryTest;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class problem1959 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();

        for(int i=1;i<=T;i++) {
            PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

            int N = sc.nextInt();
            int M = sc.nextInt();

            int[] A = new int[N];
            int[] B = new int[M];

            for(int j=0;j<N;j++) A[j] = sc.nextInt();
            for(int j=0;j<M;j++) B[j] = sc.nextInt();

            if (A.length < B.length) {
                calc(A, B, queue);
            } else {
                calc(B, A, queue);
            }


            sb.append("#").append(i).append(" ").append(queue.poll()).append("\n");
        }


        System.out.println(sb.toString());
    }

    static void calc(int[] a, int[] b, PriorityQueue<Integer> queue) {
        int moveLength = a.length;
        int fixLength = b.length;

        for(int i=0;i<=fixLength-moveLength;i++) {
            int sum = 0;
            for(int j=0;j<moveLength;j++) {
                sum += a[j]*b[i+j];
            }

            queue.add(sum);
        }

    }
}
