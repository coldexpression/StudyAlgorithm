package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * @author Chansik Seo
 */
public class problem3047 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Character, Integer> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[3];
        for (int i = 0; i < 3; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        map.put('A', arr[0]);
        map.put('B', arr[1]);
        map.put('C', arr[2]);
        char[] chars = bf.readLine().toCharArray();
        for (char c : chars) {
            sb.append(map.get(c)).append(" ");
        }
        System.out.print(sb);
    }
}
