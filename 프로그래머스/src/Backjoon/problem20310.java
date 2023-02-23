package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class problem20310 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String word = bf.readLine();
        HashSet<Integer> set = new HashSet<>();

        int n = word.length();

        int zero = 0;
        int one = 0;

        for(int i=0;i<n;i++) {
            zero = word.charAt(i) == '0' ? zero + 1 : zero;
            one = word.charAt(i) == '1' ? one + 1 : one;
        }

        int pOne = one;
        int pZero = zero;
        for(int i=0;i<n;i++) {
            if (one == pOne/2) break;
            if (word.charAt(i) == '1') {
                one--;
                set.add(i);
            }
        }

        for(int i=n-1;i>=0;i--) {
            if (zero == pZero/2) break;
            if (word.charAt(i) == '0') {
                zero--;
                set.add(i);
            }
        }


        for(int i=0;i<n;i++) {
            if (!set.contains(i)) sb.append(word.charAt(i));
        }

        System.out.println(sb);
    }
}
