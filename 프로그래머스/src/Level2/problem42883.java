package Level2;

import java.util.*;

public class problem42883 {

    public static void main(String[] args) {
        problem42883 problem42883 = new problem42883();
        problem42883.solution("654321", 5);
    }

    public String solution(String number, int k) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        int index = 0;
        int max = 0;
        for(int i=0;i<number.length()-k;i++) {
            max = 0;
            for(int j=index;j<=k+i;j++) {
                if(number.charAt(j) - 48 > max) {
                    max = number.charAt(j) - 48;
                    index = j + 1;
                }
            }
            sb.append(max);
        }
//        int count = 0;
//        int start = 0;
//        boolean check;
//        int lastIndex = 0;
//        int[] numbers = new int[number.length()];
//        for(int i=0;i<number.length();i++) {
//            numbers[i] = Integer.parseInt(String.valueOf(number.charAt(i)));
//        }
//
//        Arrays.sort(numbers);
//
//        if (numbers[0] == numbers[numbers.length-1]) {
//            number = number.substring(k);
//            return number;
//        }
//
//        char maxNum = (char)(numbers[numbers.length-1] + 48);
//
//        while(count != k) {
//            char min = 100;
//            int minIndex = -1;
//            lastIndex = number.length() - 1;
//            check = false;
//            System.out.println(number);
//            System.out.println("start : " + start);
//            if (number.charAt(start) == maxNum) {
//                start++;
//            } else if (number.charAt(start) < number.charAt(start+1)) {
//                number = number.replaceFirst(String.valueOf(number.charAt(start)), "");
//                count++;
//                start = 0;
//                check = true;
//            } else {
//                if (number.charAt(start+1) <= min) {
//                    min = number.charAt(start+1);
//                    minIndex = start + 1;
//                }
//                start++;
//            }
//
//            if (lastIndex == start) {
//                if (!check) {
//                    number = number.replaceFirst(String.valueOf(number.charAt(minIndex)), "");
//                    count++;
//                }
//                start = 0;
//            }
//            for(int i=start;i<number.length()-1;i++) {
//                if (number.charAt(i) < number.charAt(i+1)) {
//                    number = number.replaceFirst(String.valueOf(number.charAt(i)), "");
//                    count++;
//                    check = true;
//                    break;
//                } else {
//                    if (number.charAt(i+1) <= min) {
//                        min = number.charAt(i+1);
//                        minIndex = i+1;
//                    }
//                }
//            }
//            if (!check) {
//                number = number.replaceFirst(String.valueOf(number.charAt(minIndex)), "");
//                count++;
//            }
//
//        }
//        answer = number;
        answer = sb.toString();
        return answer;
    }
}
