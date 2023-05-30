package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class problem3687 {
    static int[][] nums = {{1, 2}, {7, 3}, {4, 4}, {5, 5}, {3, 5}, {2, 5}, {9, 6}, {6, 6}, {0, 6}, {8, 7}};
    static String min;
    static String max;
    static boolean minCheck;
    static boolean maxCheck;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t= Integer.parseInt(bf.readLine());
        String[] minDp = new String[101];
        String[] zeroMinDp = new String[101];
        Arrays.fill(minDp, "99999999999999999999999999999999999999999999999999");
        Arrays.fill(zeroMinDp, "99999999999999999999999999999999999999999999999999");
        minDp[2] = zeroMinDp[2] = "1";
        minDp[3] = zeroMinDp[3] = "7";
        minDp[4] = zeroMinDp[4] = "4";
        minDp[5] = zeroMinDp[5] = "2";
        zeroMinDp[6] = "0";
        minDp[6] = "6";
        minDp[7] = zeroMinDp[7] = "8";
        for(int i=8;i<=100;i++) {
            for(int j=2;j<i;j++) {
                if (zeroMinDp[j].length() == 0 || zeroMinDp[i-j].length() == 0) continue;
                zeroMinDp[i] = findMin(zeroMinDp[i], zeroMinDp[i-j]+zeroMinDp[j]);
            }
        }
        for(int i=8;i<=100;i++) {
            for(int j=2;j<i;j++) {
                if (zeroMinDp[j].length() == 0 || minDp[i-j].length() == 0 || minDp[i].equals("0")) continue;
                minDp[i] = findMin(minDp[i], minDp[i-j]+zeroMinDp[j]);
            }
        }

//        System.out.println("zeroMin : " + Arrays.toString(zeroMinDp));
//        System.out.println("min : " + Arrays.toString(minDp));
        for(int i=0;i<t;i++) {
            int n = Integer.parseInt(bf.readLine());
            min = "11111111111111111111111111111111111111111111111111";
            max = "";
            maxCheck = false;
            maxPerm("", n);
            sb.append(minDp[n]).append(" ").append(max).append("\n");
        }
        System.out.println(sb);
    }


    public static void maxPerm(String number, int n) {
        if(maxCheck) return;
        if (n == 0) {
            max = number;
            maxCheck = true;
            return;
        }

        for(int i=0;i<10;i++) {
            if (n - nums[i][1] >= 0) {
                maxPerm(nums[i][0] + number, n - nums[i][1]);
            }
        }
    }

    public static String findMin(String pivot, String compare) {
        if (pivot.length() < compare.length()) return pivot;
        if (pivot.length() > compare.length()) return compare;

        for(int i=0;i<pivot.length();i++) {
            int n1 = Character.getNumericValue(pivot.charAt(i));
            int n2 = Character.getNumericValue(compare.charAt(i));
            if (n1 > n2) return compare;
            if (n1 < n2) return pivot;
        }
        return pivot;
    }

    public static boolean findMax(String pivot, String compare) {
        if (pivot.length() < compare.length()) return true;
        if (pivot.length() > compare.length()) return false;

        for(int i=0;i<pivot.length();i++) {
            int n1 = Character.getNumericValue(pivot.charAt(i));
            int n2 = Character.getNumericValue(compare.charAt(i));
            if (n1 > n2) return false;
            if (n1 < n2) return true;
        }
        return false;
    }
}
