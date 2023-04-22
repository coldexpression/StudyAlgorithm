package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem27866 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        String input = st.nextToken();
        st = new StringTokenizer(bf.readLine());

        System.out.println(input.charAt(Integer.parseInt(st.nextToken())-1));
    }
}
