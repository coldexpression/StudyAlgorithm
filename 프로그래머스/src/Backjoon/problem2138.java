package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

        set = new HashSet<>();

        set.add(first);
        dfs(first, last, 0);

        System.out.println(ans);
    }

    public static String trans(String input, int index) {
        StringBuilder sb = new StringBuilder();

        if (index == 0) {
            for(int i=0;i<input.length();i++) {
                if (i >= 0 && i <= 1) sb.append(input.charAt(i) == '1' ? '0' : '1');
                else sb.append(input.charAt(i));
            }
        } else if (index == input.length()-1) {
            for(int i=0;i<input.length();i++) {
                if (i >= input.length()-2 && i <= input.length()-1) sb.append(input.charAt(i) == '1' ? '0' : '1');
                else sb.append(input.charAt(i));
            }
        } else {
            for(int i=0;i<input.length();i++) {
                if (i >= index-1 && i <= index+1) sb.append(input.charAt(i) == '1' ? '0' : '1');
                else sb.append(input.charAt(i));
            }
        }

        return sb.toString();
    }

    public static void dfs(String first, String last, int cnt) {
        if (ans < cnt) return;
        if (first.equals(last)) {
            ans = cnt;
            return ;
        }

        for(int i=0;i<last.length();i++) {
            if (first.charAt(i) != last.charAt(i)) {
                System.out.println(first);
                String newWord = trans(first, i);
                if (!set.contains(newWord)) {
                    set.add(newWord);
                    System.out.println(newWord);
                    dfs(newWord, last, cnt + 1);
                }
            }
        }
    }
}
