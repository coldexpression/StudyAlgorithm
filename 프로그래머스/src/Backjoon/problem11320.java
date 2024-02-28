package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem11320 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            //2제곱이기 때문에 굳이 Math함수를 쓰지 않고 곱하기로 해준다.
            if(A % B == 0) System.out.println((A / B) * (A / B));
            else System.out.println(((A / B) + 1) * ((A / B) + 1));
        }
    }

}
