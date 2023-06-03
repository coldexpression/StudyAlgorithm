package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class problem1026 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> pqA = new PriorityQueue<>();
        PriorityQueue<Integer> pqB = new PriorityQueue<>((o1,o2)-> o2-o1);
        st = new StringTokenizer(bf.readLine());
        for(int i=0;i<n;i++) pqA.add(Integer.parseInt(st.nextToken()));
        st = new StringTokenizer(bf.readLine());
        for(int i=0;i<n;i++) pqB.add(Integer.parseInt(st.nextToken()));
        int sum = 0;
        while(!pqB.isEmpty()) sum += pqB.poll()*pqA.poll();
        System.out.print(sum);
    }
}
