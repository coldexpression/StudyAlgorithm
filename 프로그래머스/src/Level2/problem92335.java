package Level2;

import java.util.*;

public class problem92335 {

    public static void main(String[] args) {
        problem92335 problem92335 = new problem92335();
        problem92335.solution(110011, 10);
    }

    public long solution(int n, int k) {
        long answer = 0;
        String board = trans(n, k);
        String[] words = board.split("0");
        for (String word : words) {
            if (word.length() != 0) {
                long num = Long.parseLong(word);
                System.out.println(num);
                answer = prime(num) ? answer + 1 : answer;
            }
        }
        System.out.println(answer);
        return answer;
    }

    public boolean prime(long input) {
        boolean check = true;
        if (input == 1) return false;
        for(int i=2;i<(int)Math.sqrt(input)+1;i++) {
            if (input % i == 0) {
                check = false;
                break;
            }
        }
        return check;
    }

    public String trans(int n, int k) {
        StringBuilder sb = new StringBuilder();
        while(true) {
            int rest = n % k;
            sb.insert(0, rest);
            n = n / k;
            if (n == 0) break;
        }
        return sb.toString();
    }

//    public long solution(int n, int k) {
//        long answer = 0;
//        int index = 0;
//        int count = 0;
//        String board = "";
//        board = transNum(n, k);
//
//        for(String word: board.split("0")) {
//            if (!word.equals("")) answer = findPrimeNum(Long.parseLong(word)) ? answer + 1 : answer;
//        }
//
//        return answer;
//    }
//
//    private String transNum(int n, int k) {
//        Stack<Integer> store = new Stack<>();
//        int rest = 0;
//        int mok = n;
//        String board = "";
//        while(mok != 0) {
//            rest = mok % k;
//            mok = mok / k;
//            store.push(rest);
//        }
//
//        while(!store.isEmpty()) board = board.concat(String.valueOf(store.pop()));
//        return board;
//    }
//
//    private boolean findPrimeNum(long n) {
//        if ( n == 0 || n == 1) return false;
//
//        for(int i=2;i<=Math.sqrt(n);i++) {
//            if (n % i == 0) return false;
//        }
//
//        return true;
//    }
}
