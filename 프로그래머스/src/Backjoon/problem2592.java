package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class problem2592 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer, Integer> map = new HashMap<>();
        int avg = 0;
        int max = -1;
        int fre = 0;
        for(int i=0;i<10;i++) {
            int num = Integer.parseInt(bf.readLine());
            int count = map.getOrDefault(num, 0);
            map.put(num, count + 1);
            avg += num;
        }

        for (int num : map.keySet()) {
            if (max < map.get(num)) {
                max = map.get(num);
                fre = num;
            }
        }
        System.out.println(avg/10);
        System.out.println(fre);
    }
}
