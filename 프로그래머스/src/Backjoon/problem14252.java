package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class problem14252 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        int ans = 0;

        int[] arr = new int[n];

        for(int i=0;i<n;i++) arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);


        for(int i=1;i<arr.length;i++) {
            int min = arr[i-1];
            int max = arr[i];
            int num = 0;

            num = gcd(max, min);

            if (num <= 1) continue;

            ans++;

            boolean lCheck = false;
            boolean rCheck = false;
            int val = 0;

            for(int j=min+1;j<=max;j++) {
                num = gcd(j, min);

                if (num <= 1) {
                    val = j;
                    lCheck = true;
                    num = gcd(j, max);

                    if(num <= 1) {
                        rCheck = true;
                        break;
                    }
                }
            }

            if (lCheck) {
                arr[i-1] = val;
                i--;
            }
        }

        System.out.println(ans);
    }

    public static int gcd(int n1, int n2) {
        int ans = 0;
        int tmp = 0;

        while(true) {
            if (n1%n2 == 0) {
                ans = n2;
                break;
            } else {
                tmp = n2;
                n2 = n1 % n2;
                n1 = tmp;
            }
        }

        return ans;
    }
}