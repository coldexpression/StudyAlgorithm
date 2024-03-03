package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem10539 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        //A 수열을 저장 할 배열
        int[] arr = new int[N];
        //현재 값 이전 수열 값들의 합을 저장할 변수
        int sum = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            int M = Integer.parseInt(st.nextToken());

            //첫 값은 그대로 받아온다.
            if(i == 0) {
                arr[0] = M;
                //두번째 값부터는 연산 식을 적용해 가져온다.
            }else {
                arr[i] = (M * (i + 1)) - sum;
            }
            //값이 구해지면 변수에 더한다.
            sum += arr[i];
        }
        //배열에 저장된 값을 {}없이 출력하기 위해 for문 사용
        for(int K : arr) {
            System.out.print(K + " ");
        }
    }

}
