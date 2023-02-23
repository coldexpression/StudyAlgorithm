package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;

public class problem2138 {

    static HashSet<String> set;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        String first = bf.readLine();
        String last = bf.readLine();

        ans = Integer.MAX_VALUE;

        int[] f = new int[n];
        int[] c = new int[n];
        int[] l = new int[n];

        for(int i=0;i<n;i++) {
            f[i] = Character.getNumericValue(first.charAt(i));
            c[i] = Character.getNumericValue(first.charAt(i));
        }
        for(int i=0;i<n;i++) l[i] = Character.getNumericValue(last.charAt(i));

        int onCount = 1;
        int offCount = 0;


        // 0번 스위치를 킬 때
        trans(f, 0);

        for(int i=1;i<=f.length;i++) {
            Arrays.stream(f).forEach(x -> System.out.print(x + " "));
            System.out.println();
            if (check(f, l)) {
                ans = onCount;
            }
            if (i == f.length) break;
            if (f[i-1] != l[i-1]) {
                trans(f, i);
                onCount++;
            }
        }

        Arrays.stream(f).forEach(x -> System.out.print(x + " "));
        System.out.println();

        System.out.println("off");
        // 0번 스위치를 끌 때
        for(int i=1;i<=c.length;i++) {
            Arrays.stream(c).forEach(x -> System.out.print(x + " "));
            System.out.println();
            if (check(c, l)) {
                ans = Math.min(ans, offCount);
            }
            if (i == c.length) break;
            if (c[i-1] != l[i-1]) {
                trans(c, i);
                offCount++;
            }
        }

        Arrays.stream(c).forEach(x -> System.out.print(x + " "));
        System.out.println();

        ans = ans == Integer.MAX_VALUE ? -1 : ans;

        System.out.println(ans);
    }

    public static boolean check(int[] arr, int[] brr) {
        for(int i=0;i<arr.length;i++) {
            if (arr[i] != brr[i]) return false;
        }

        return true;
    }

    public static void trans(int[] arr, int index) {

        if (index == 0) {
            arr[0] = arr[0] == 1 ? 0 : 1;
            arr[1] = arr[1] == 1 ? 0 : 1;
        } else if (index == arr.length - 1) {
            arr[index-1] = arr[index-1] == 1 ? 0 : 1;
            arr[index] = arr[index] == 1 ? 0 : 1;
        } else {
            for(int i=index-1;i<=index+1;i++) {
                arr[i] = arr[i] == 1 ? 0 : 1;
            }
        }
    }

}
