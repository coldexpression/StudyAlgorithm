package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem12919 {
    static boolean check;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        String t = bf.readLine();

        dfs(s, t);
        System.out.println(check ? 1 : 0);
    }

    public static void dfs(String s, String t) {
        if (check || s.length() > t.length()) return;
        if (t.equals(s)) {
            check = true;
            return;
        }

        if (t.length() > s.length()) {
            if (t.charAt(t.length()-1) == 'A') dfs(s, delete(t));
            if (t.charAt(0) == 'B') dfs(s, reverse(t));
        }
    }

    public static String reverse(String input) {
        StringBuilder sb = new StringBuilder(input);
        sb.reverse();
        sb.deleteCharAt(input.length()-1);
        return sb.toString();
    }

    public static String delete(String input) {
        StringBuilder sb = new StringBuilder(input);
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

}
