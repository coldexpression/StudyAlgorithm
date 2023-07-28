package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class problem1292 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        List<Integer> list = new ArrayList<>();
        int index = 1;
        while(true) {
            if (list.size() == 1000) break;
            for(int i=1;i<=index;i++) {
                if (list.size() == 1000) break;
                list.add(index);
            }
            index++;
        }
        System.out.println(list);
        int sum = 0;
        for(int i=start-1;i<end;i++) sum += list.get(i);
        System.out.println(sum);
    }
}
