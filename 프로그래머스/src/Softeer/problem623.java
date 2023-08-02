package Softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class problem623 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        if (n < m) {
            System.out.println("normal");
        } else {
            int[] checker = new int[m];
            ArrayDeque<Integer> deque = new ArrayDeque<>();
            int[] arr = new int[n];
            st = new StringTokenizer(bf.readLine());
            int index = 0;
            while (st.hasMoreTokens()) checker[index++] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(bf.readLine());
            index = 0;
            while (st.hasMoreTokens()) arr[index++] = Integer.parseInt(st.nextToken());
            for (int i = 0; i < m; i++) deque.addLast(arr[i]);

            if (isCheck(checker, deque)) System.out.println("secret");
            else {
                int left = 0;
                int right = m - 1;
                boolean check = false;
                while (true) {
                    System.out.println("[left, right] => ["+left+", "+right+"]");
                    if (right == n - 1) break;
                    deque.pollFirst();
                    left++;
                    right++;
                    deque.addLast(arr[right]);
                    if (isCheck(checker, deque)) {
                        check = true;
                        break;
                    }
                }
                System.out.println(check ? "secret" : "normal");
            }
        }
    }

    public static boolean isCheck(int[] checker, ArrayDeque<Integer> deque) {
        System.out.println(Arrays.toString(checker));
        int index = 0;
        for (int number : deque) {
            if (checker[index++] != number) return false;
        }
        return true;
    }
}
