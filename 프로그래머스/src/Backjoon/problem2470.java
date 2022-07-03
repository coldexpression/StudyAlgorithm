package Backjoon;

import java.io.*;
import java.util.*;

public class problem2470 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bf.readLine());
        int[] liquid = new int[N];
        int comp = Integer.MAX_VALUE;

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=0;i<N;i++) liquid[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(liquid);

        int front = 0;
        int rear = N - 1;
        int a1 = 1;
        int a2 = 1;

        while(true) {
            if (front >= rear) break;

            if (Math.abs(liquid[front] + liquid[rear]) < comp) {
                comp = Math.abs(liquid[front] + liquid[rear]);
                a1 = liquid[front];
                a2 = liquid[rear];
                if (comp == 0) break;
            }

            if (liquid[front] + liquid[rear] < 0) {
                front++;
            } else {
                rear--;
            }
        }

        bw.write(a1 + " " + a2);
        bw.flush();
        bw.close();
        bf.close();
    }
}
