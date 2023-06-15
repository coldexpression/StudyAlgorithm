package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class problem13558 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        long[] leftCnt = new long[30001];
        long[] rightCnt = new long[30001];
        int[] arr = new int[n];
        long ans = 0;
        st = new StringTokenizer(bf.readLine());
        for(int i=0;i<n;i++)  {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
            if (i == 0) leftCnt[num]++;
            else rightCnt[num]++;
        }


        for(int i=1;i<n-1;i++) {
            rightCnt[arr[i]]--;

//            System.out.println(arr[i]*2);
            System.out.println("중심 : " + arr[i]);
            for(int j=1;j<=arr[i];j++) {
                if (arr[i]*2-j > 30000) continue;
                System.out.println("["+j+", "+(arr[i]*2-j)+"] => ["+leftCnt[j]+", "+rightCnt[arr[i]*2-j]+"] : ["+leftCnt[arr[i]*2-j]+", "+rightCnt[j]+"]");
                ans += j == arr[i]*2-j ? leftCnt[j]*rightCnt[arr[i]*2-j] : (leftCnt[j]*rightCnt[arr[i]*2-j]) + (leftCnt[arr[i]*2-j] * rightCnt[j]);
            System.out.println("ans => " + ans);
            }
            leftCnt[arr[i]]++;
        }
        System.out.println(ans);
    }
}
