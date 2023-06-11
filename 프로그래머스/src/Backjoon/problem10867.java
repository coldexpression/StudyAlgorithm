package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class problem10867 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n  = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        TreeSet<Integer> set = new TreeSet<>();
        for(int i=0;i<n;i++) set.add(Integer.parseInt(st.nextToken()));
        for (Integer integer : set) {
            System.out.print(integer + " ");
        }
    }
}
