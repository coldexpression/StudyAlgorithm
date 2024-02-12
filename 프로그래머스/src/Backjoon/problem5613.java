package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class problem5613 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //이 변수에 계속 연산해준다.
        int result = Integer.parseInt(br.readLine());

        while(true) {
            String S = br.readLine();

            //무한루프 종료
            if(S.equals("=")) break;

            int N = Integer.parseInt(br.readLine());


            if(S.equals("+")) {
                result += N;
            }else if(S.equals("-")){
                result -= N;
            }else if(S.equals("*")){
                result *= N;
            }else{
                result /= N;
            }
        }
        System.out.println(result);
    }

}
