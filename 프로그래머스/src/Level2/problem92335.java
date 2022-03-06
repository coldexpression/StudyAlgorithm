package Level2;

import java.util.*;

public class problem92335 {

    public static void main(String[] args) {

    }

    public long solution(int n, int k) {
        long answer = 0;
        int index = 0;
        int count = 0;
        String board = "";
        board = transNum(n, k);

        for(String word: board.split("0")) {
            if (!word.equals("")) answer = findPrimeNum(Long.parseLong(word)) ? answer + 1 : answer;
        }

        return answer;
    }

    private String transNum(int n, int k) {
        Stack<Integer> store = new Stack<>();
        int rest = 0;
        int mok = n;
        String board = "";
        while(mok != 0) {
            rest = mok % k;
            mok = mok / k;
            store.push(rest);
        }

        while(!store.isEmpty()) board = board.concat(String.valueOf(store.pop()));
        return board;
    }

    private boolean findPrimeNum(long n) {
        if ( n == 0 || n == 1) return false;

        for(int i=2;i<=Math.sqrt(n);i++) {
            if (n % i == 0) return false;
        }

        return true;
    }
}
