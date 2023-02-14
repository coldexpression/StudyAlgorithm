package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class problem22988 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine();
        String[] word = input.split(" ");
        List<Long> list = new ArrayList<>();

        int n = Integer.parseInt(word[0]);
        long x = Long.parseLong(word[1]);
        int ans = 0;

        input = bf.readLine();
        word = input.split(" ");

        long[] arr = new long[n];

        for(int i=0;i<arr.length;i++) arr[i] = Long.parseLong(word[i]);

        for(int i=0;i<arr.length;i++)
            if (arr[i] >= x) ans++;
            else list.add(arr[i]);

        arr = new long[list.size()];

        for(int i=0;i<list.size();i++) arr[i] = list.get(i);

        Arrays.sort(arr);

        int left = 0;
        int right = arr.length-1;
        int cnt = 0;

        if (!list.isEmpty()) {
            double num = arr[left] + arr[right] + ((double) x / 2);

            while(left < right) {
                if(num >= x) {
                    cnt+=2;
                    ans++;
                    left++;
                    right--;
                    num = arr[left] + arr[right] + ((double)x/2);
                } else {
                    left++;
                    num = arr[left] + arr[right] + ((double)x/2);
                }
            }

            ans = ans + ((arr.length - cnt) / 3);
        }

        System.out.println(ans);
    }


}