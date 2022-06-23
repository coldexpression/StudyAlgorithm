package Level3;

import java.util.*;

public class problem12904 {
    public static void main(String[] args) {
        problem12904 problem12904 = new problem12904();
//        problem12904.solution("abcdcba");
        problem12904.solution("abbb");
//        problem12904.solution("abba");
    }

    public int solution(String s) {
        int answer = Integer.MIN_VALUE;
        char[] word = s.toCharArray();
        char[] forward = s.toCharArray();
        char[] reverseWord = new char[s.length()];
        int[][] dp = new int[s.length()+1][s.length()+1];
        int[][] reverseDp = new int[s.length()+1][s.length()+1];
        int forwardMax = Integer.MIN_VALUE;
        int reverseMax = Integer.MIN_VALUE;
        int index = 0;

        for(int i=s.length()-1;i>=0;i--) {
            reverseWord[index++] = s.charAt(i);
        }

        for (char c : reverseWord) {
            System.out.print(c);
        }

        for(int i=0;i<forward.length;i++) {
            for(int j=0;j<word.length;j++) {
                if(forward[i] == word[j]) {
                    dp[i+1][j+1] = Math.max(dp[i+1][j+1], dp[i][j] + 1);
                } else {
                    dp[i+1][j+1] = Math.max(dp[i][j+1], dp[i+1][j]);
                }
                forwardMax = Math.max(forwardMax, dp[i+1][j+1]);
            }
        }

        for(int i=0;i<forward.length;i++) {
            for(int j=0;j<reverseWord.length;j++) {
                if(forward[i] == reverseWord[j]) {
                    reverseDp[i+1][j+1] = Math.max(reverseDp[i+1][j+1], reverseDp[i][j] + 1);
                } else {
                    reverseDp[i+1][j+1] = Math.max(reverseDp[i][j+1], reverseDp[i+1][j]);
                }
                reverseMax = Math.max(reverseMax, reverseDp[i+1][j+1]);
            }
        }

        for(int i=0;i<dp.length;i++) {
            System.out.println();
            for(int j=0;j<dp[i].length;j++) {
                System.out.print("["+dp[i][j]+"] ");
            }
        }

        System.out.println();

        for(int i=0;i<reverseDp.length;i++) {
            System.out.println();
            for(int j=0;j<reverseDp[i].length;j++) {
                System.out.print("["+reverseDp[i][j]+"] ");
            }
        }

        answer = Math.min(forwardMax, reverseMax);

        return answer;
    }
}
