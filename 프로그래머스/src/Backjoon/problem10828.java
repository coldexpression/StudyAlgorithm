package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class problem10828 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] stack = new int[N];
        int idx = 0;

        for(int i=0;i<N;i++) {
            String command = br.readLine();

            switch(command) {
                case "pop" :
                    sb.append(idx == 0 ? -1 : stack[--idx]);
                    sb.append("\n");
                    break;
                case "size" :
                    sb.append(idx);
                    sb.append("\n");
                    break;
                case "empty" :
                    sb.append(idx == 0 ? 1 : 0);
                    sb.append("\n");
                    break;
                case "top" :
                    sb.append(idx == 0 ? -1 : stack[idx-1]);
                    sb.append("\n");
                    break;
                default :
                    stack[idx++] = Integer.parseInt(command.split(" ")[1]);
                    break;
            }

        }

        System.out.println(sb);
    }
}