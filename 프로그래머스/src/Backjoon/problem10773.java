package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class problem10773 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int K = Integer.parseInt(br.readLine());
        int ans = 0;

        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<K;i++) {
            int num = Integer.parseInt(br.readLine());

            if (num == 0) stack.pop();
            else stack.add(num);
        }

        while(!stack.isEmpty()) ans += stack.pop();

        sb.append(ans);
        System.out.println(sb);
    }
}