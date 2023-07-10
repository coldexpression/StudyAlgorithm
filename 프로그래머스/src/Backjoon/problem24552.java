package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class problem24552 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine();
        Stack<int[]> stack = new Stack<>();
        // flag = 0 [ ( ]
        // flag = 1 [ ) ]
        boolean[] vis = new boolean[input.length()];
        int[] front = new int[input.length()];
        int[] rear = new int[input.length()];
        int ans = 0;
        for(int i=0;i<input.length();i++) {
            int flag = input.charAt(i) == '(' ? 0 : 1;
            if(stack.isEmpty()) stack.push(new int[]{flag, i});
            else {
                if (stack.peek()[0] == 0) {
                    if (flag == 1) {
                        int[] info = stack.pop();
                        vis[i] = vis[info[1]] = true;
                    } else stack.push(new int[]{flag, i});
                } else stack.push(new int[]{flag, i});
            }
        }

        System.out.println(stack);
        if (stack.size() != 1) {
            System.out.println(1);
        } else {
            while(!stack.isEmpty()) {
                int[] info = stack.pop();
                int flag = info[0]; int idx = info[1];
                if (flag == 0) front[idx]++;
                else rear[idx]++;
            }

            for(int i=1;i<input.length();i++) front[i] += front[i-1];
            for(int i=input.length()-2;i>=0;i--) rear[i] += rear[i+1];

            System.out.println("front : " + Arrays.toString(front));
            System.out.println("rear : " + Arrays.toString(rear));
            System.out.println(Arrays.toString(vis));

            for(int i=0;i<input.length();i++) {
                int flag = input.charAt(i) == '(' ? 0 : 1;
                System.out.println("["+i+"] => " + flag);
                if (vis[i]) {
                    if (flag == 0) ans = front[i] == 1 ? ans + 1 : ans;
                    else ans = rear[i] == 1 ? ans + 1 : ans;
                } else {
//                    if (flag == 0) ans = rear[i] == 1 ? ans + 1 : ans;
//                    else ans = front[i] == 1 ? ans + 1 : ans;
                    ans++;
                }

                System.out.println(ans);
            }
            System.out.println(ans);
        }
    }
}
