package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author Chansik Seo
 */
public class problem2947 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int[] arr = new int[5];
        for(int i=0;i<5;i++) arr[i] = Integer.parseInt(st.nextToken());
        int start = 0;
        int end = 1;
        while(true) {
            if (isTrue(arr)) break;
            swap(arr, start, end);
            start++;
            end++;
            if (end == 5) {
                start = 0;
                end = 1;
            }
        }
        System.out.print(sb);
    }
    static public void write(int[] arr) {
        Arrays.stream(arr).forEach(x -> sb.append(x).append(" "));
        sb.append("\n");
    }

    static public boolean isTrue(int[] arr) {
        for(int i=0;i<5;i++)if (arr[i] != (i+1)) return false;
        return true;
    }

    static public void swap(int[] arr, int start, int end) {
        if (arr[start] > arr[end]) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            write(arr);
        }
    }
}
