package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author Chansik Seo
 */
public class problem20361 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken()) - 1;
        int x = Integer.parseInt(st.nextToken());
        boolean[] arr = new boolean[n];
        Arrays.fill(arr, false);
        arr[k] = true;
        for(int i=0;i<x;i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            swap(a, b, arr);
        }
        System.out.println(find(arr));
    }

    public static int find(boolean[] arr) {
        for(int i=0;i<arr.length;i++) {
            if (arr[i]) return i+1;
        }
        return -1;
    }

    public static void swap(int a, int b, boolean[] arr) {
        boolean temp = false;
        temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
