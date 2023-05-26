package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem2754 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine();
        String ans = "";
        switch (input) {
            case "A+" : ans = "4.3"; break;
            case "A0" : ans = "4.0"; break;
            case "A-" : ans = "3.7"; break;
            case "B+" : ans = "3.3"; break;
            case "B0" : ans = "3.0"; break;
            case "B-" : ans = "2.7"; break;
            case "C+" : ans = "2.3"; break;
            case "C0" : ans = "2.0"; break;
            case "C-" : ans = "1.7"; break;
            case "D+" : ans = "1.3"; break;
            case "D0" : ans = "1.0"; break;
            case "D-" : ans = "0.7"; break;
            default: ans = "0.0";
        }
        System.out.println(ans);
    }
}
