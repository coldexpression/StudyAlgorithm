package Backjoon;

import java.util.Scanner;
public class problem11319 {
    //입력한 문장의 자음과 모음 출력
    //공백은 다 지워야 함

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int line =sc.nextInt(); //줄 생성
        int vowels = 0;//전역변수
        int consonants= 0;
        for(int i =0; i <= line; i++){ // 입력한 line만큼 입력할 줄 생성
            String input =sc.nextLine().toLowerCase().trim().replaceAll(" ",""); // 문장 소문자화,양 끝 공백 지우기,중간공백 지우기
            for(int j =0; j < input.length();j++){ //j가 문자열 하나 하나 훑어가며 모음 자음 체크
                if(input.charAt(j)=='a'||input.charAt(j)=='e'||input.charAt(j)=='i'||input.charAt(j)=='o'||input.charAt(j)=='u') {
                    vowels++;// aeiou일경우 +1
                }
                else{
                    consonants++;// 그 외일경우 +1

                }

            }
            if (vowels != 0 && consonants !=0){ // 자음과 모음이 0이 아닐경우 출력
                System.out.println(consonants+" "+vowels);
                vowels= 0; //지역변수 0으로 값 다시 초기화해주고 for문 으로 돌아감
                consonants=0;
            }
        }
    }
}