package Backjoon;

import java.util.Arrays;
import java.util.Scanner;

public class problem2309 {
    static boolean check;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[9];
        int[] brr = new int[7];
        for(int i=0;i<9;i++) arr[i] = sc.nextInt();
        check = false;

        perm(arr, brr, 0, 0, 0);
    }

    public static void perm(int[] arr, int[] brr, int index, int count, int sum) {
        if (check) return;
        if (count == 7) {
            if (sum == 100) {
                Arrays.sort(brr);
                Arrays.stream(brr).forEach(x -> System.out.println(x));
                check = true;
            }
            return;
        }

        for(int i=index;i<9;i++) {
            brr[count] = arr[i];
            perm(arr, brr, i+1, count + 1, sum + arr[i]);
        }
    }
}
