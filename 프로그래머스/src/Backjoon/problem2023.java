package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class problem2023 {

    static int[] num = {1,2,3,5,7,9};
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());

        dfs("");
    }

    public static void dfs (String w) {
        if (w.length() == N) {
            System.out.println(w);
            return;
        }

        if (w.length() == 0) {
            for(int i=1;i<num.length-1;i++) dfs(String.valueOf(num[i]));
        } else {
            for(int i=0;i<num.length;i++) {
                if(isPrime(Integer.parseInt(w + num[i]))) {
                    dfs(w + num[i]);
                }
            }
        }
    }

    public static boolean isPrime(int number) {
        if (number == 0 || number == 1) return false;
        if (number == 2) return true;

        for(int i=2;i<=Math.sqrt(number);i++)
            if (number % i == 0) return false;

        return true;
    }
}
