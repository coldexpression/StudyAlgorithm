package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem17094 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int len = Integer.parseInt(st.nextToken());
        int a = 0;
        int b = 0;
        String input = bf.readLine();
        for(int i=0;i<len;i++) {
            if (input.charAt(i) == '2') a++;
            else if (input.charAt(i) == 'e') b++;
        }
        System.out.println(a > b ? 2 : a == b ? "yee" : "e");
    }
}
