package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem20033 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());

        int[] arr = new int[n];
        for(int i=0;i<n;i++) arr[i] = Integer.parseInt(st.nextToken());

        int left = 1;
        int right = n;
        int middle = 0;
        int ans = 0;

        while(left <= right) {
            middle = (left + right) / 2;
            System.out.println("middle : " + middle);

            if (isCheck(arr, middle)) {
                ans = middle;
                left = middle + 1;
                System.out.println("크다");
            } else {
                right = middle - 1;
                System.out.println("작다");
            }
        }
        System.out.println(ans);
    }

    public static boolean isCheck(int[] arr, int size) {
        int count = 0;
        for(int i=0;i<size;i++) count = arr[i] < size ? count + 1 : count;
        if (count == 0) return true;

        for(int i=1;i<arr.length-size+1;i++) {
            if (arr[i-1] < size) count--;
            if (arr[i+size-1] < size) count++;

            if (count == 0) return true;
        }
        return false;
    }

}
