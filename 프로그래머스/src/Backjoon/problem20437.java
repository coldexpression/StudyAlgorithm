package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class problem20437 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(st.nextToken());

        // 어떤 문자를 정확히 K개 포함하면서 가장 짧은것 구하기
        // 어떤 문자를 정확히 K개 포함하면서 문자열의 첫번째와 마지막이 해당 문자와 같으면서 가장 긴것 구하기
        for(int i=0;i<T;i++) {
            HashMap<Character, Integer> map = new HashMap<>();
            char[] arr = bf.readLine().toCharArray();
            int k = Integer.parseInt(bf.readLine());
            int left = 1;
            int right = arr.length;
            int middle = 0;
            int shortSize = Integer.MAX_VALUE;
            int longSize = 0;
            if (k == 1) {
                sb.append(1).append(" ").append(1).append("\n");
            } else {
                // 이분탐색으로 window 사이즈 구하기
                System.out.println(Arrays.toString(arr));

                while (true) {
                    if (left > right) break;
                    System.out.println("left : " + left + ", " + right);
                    middle = (left + right) / 2;
                    map = new HashMap<>();

                    if (isShortest(map, middle, arr, k)) {
                        right = middle - 1;
                        shortSize = Math.min(shortSize, middle);
                    } else {
                        left = middle + 1;
                    }
                }
                left = 1;
                right = arr.length;
                while (true) {
                    if (left > right) break;
                    middle = (left + right) / 2;
                    map = new HashMap<>();

                    if (isLongest(map, middle, arr, k)) {
                        right = middle - 1;
                        longSize = Math.max(longSize, middle);
                    } else {
                        left = middle + 1;
                    }
                }

                if (shortSize == Integer.MAX_VALUE && longSize == 0) sb.append(-1).append("\n");
                else sb.append(shortSize).append(" ").append(longSize).append("\n");
            }
        }
        System.out.println(sb);
    }

    public static boolean isLongest(HashMap<Character, Integer> map, int windowSize, char[] arr, int k) {
        int left = 0; int right = windowSize - 1;
        System.out.println("::isLongest()::");
        System.out.println("windowSize : " + windowSize);
        System.out.println(left + " " + right);
        for(int i=left;i<=right;i++) map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        System.out.println(map);

        if (arr[left] == arr[right])
            for (int count: map.values()) if (count == k) return true;

        while (right != arr.length - 1) {
            System.out.println("l : " + left + ", r : " + right);
            System.out.println(map);
            map.put(arr[left], map.get(arr[left]) - 1);
            left++;
            right++;
            map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);

            if (arr[left] == arr[right])
                for (int count: map.values()) if (count == k) return true;
        }
        return false;
    }

    public static boolean isShortest(HashMap<Character, Integer> map, int windowSize, char[] arr, int k) {
        // 시작 범위 알파벳 빈도 구하기
        System.out.println("::isShortest::");
        int left = 0; int right = windowSize - 1;
        for(int i=left;i<=right;i++) map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);

        System.out.println("windowSize : " + windowSize);
        System.out.println(left + " " + right);
        System.out.println(map);
        // 초기 배열이 조건에 부합 하는지 확인
        for (int count : map.values()) if (count == k) return true;

        while (right != arr.length - 1) {
//            System.out.println("l : " + left + ", r : ");
            map.put(arr[left], map.get(arr[left]) - 1);
            left++;
            right++;
            map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);

            for (int count : map.values()) if (count == k) return true;
        }
        return false;
    }
}
