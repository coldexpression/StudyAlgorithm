package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem22945 {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(bf.readLine());
        for(int i=0;i<n;i++) arr[i] = Integer.parseInt(st.nextToken());
        int left = 0;
        int right = n-1;
        int ans = calc(right, left);
        System.out.println("첫 => " + ans);
        while(true) {
            if (left >= right) break;
            if (arr[left] < arr[right]) {
                ans = Math.max(ans, calc(right, left));
                left++;
            } else {
                ans = Math.max(ans, calc(right, left));
                right--;
            }
        }

        System.out.println(ans);
    }

    public static int calc(int n1, int n2) {
        return n1 == n2 ? 0 : ((n1-n2)-1)*(Math.min(arr[n1],arr[n2]));
    }
}
