package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class problem12904 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String before = bf.readLine();
        String after = bf.readLine();
        boolean check = false;
        while(true) {
            if (after.charAt(after.length()-1) == 'A') {
                after = processF(after);
            } else {
                after = processS(after);
            }

            if (after.length() == before.length()) {
                check = after.equals(before);
                break;
            }
        }
        System.out.println(check ? 1 : 0);
    }

    public static String processF(String input) {
        // 끝에 A가 나올 경우 A만 지우고 리턴
        return input.substring(0, input.length() - 1);
    }

    public static String processS(String input) {
        // 끝에 B가 나올 경우 B제거 후 뒤집은 문자열 리턴
        StringBuilder sb = new StringBuilder();
        for(int i=input.length()-2;i>=0;i--) sb.append(input.charAt(i));
        return sb.toString();
    }
}
