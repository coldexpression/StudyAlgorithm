package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class problem20366 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());

        int[] arr = new int[n];
        int ans = Integer.MAX_VALUE;

        for(int i=0;i<n;i++) arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        for(int i=0;i<n;i++) {
            for(int j=i+3;j<n;j++) {
                int left = i + 1;
                int right = j - 1;

                while(left < right) {
                    int sum = (arr[i] + arr[j])  - (arr[left] + arr[right]);

                    if (sum < 0) {
                        ans = Math.min(ans, Math.abs(sum));
                        right--;
                    } else if (sum > 0) {
                        ans = Math.min(ans, sum);
                        left++;
                    } else {
                        ans = 0;
                        break;
                    }

                }
            }
            if (ans == 0) break;
        }

        System.out.println(ans);

    }
}