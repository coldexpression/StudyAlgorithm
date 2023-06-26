package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class problem16472 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        String input = bf.readLine();
        int[] alph = new int[26];
        char[] arr = input.toCharArray();

        int left = 0;
        int right = n-1;
        int count = 0;
        for(int i=left;i<right;i++) alph[arr[i]-97]++;

        if (arr.length <= n) System.out.println(arr.length);
        else {
            while (true) {
                if (left >= right || right == arr.length) break;

                if (isCheck(alph, arr, right, n)) {
                    alph[arr[right] - 97]++;
                    count = Math.max(count, right - left + 1);
                    right++;
                } else if (isCheck(alph, arr, left, n)) {
                    alph[arr[left] - 97]--;
                    left++;
                    count = Math.max(count, right - left + 1);
                }
            }
            System.out.println(count);
        }
    }

    public static boolean isCheck(int[] alph, char[] arr, int flag, int n) {
        int count = 0;
        int[] comp = alph.clone();
        comp[arr[flag]-97]++;
        for(int i=0;i<alph.length;i++) count = comp[i] > 0 ? count + 1 : count;
        return count <= n;
    }
}
