package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem10103 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int young = 100;
        int duck = 100;
        for(int i=0;i<n;i++) {
            st = new StringTokenizer(bf.readLine());
            int youngNum = Integer.parseInt(st.nextToken());
            int changNum = Integer.parseInt(st.nextToken());
            if (youngNum > changNum) {
                duck -= youngNum;
            } else if (changNum > youngNum) {
                young -= changNum;
            }
        }
        System.out.println(young);
        System.out.println(duck);
    }
}
