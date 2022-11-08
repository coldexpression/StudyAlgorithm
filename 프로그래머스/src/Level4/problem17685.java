package Level4;

import java.util.Arrays;
import java.util.Comparator;

public class problem17685 {

    public static void main(String[] args) {
        problem17685 problem17685 = new problem17685();
//        problem17685.solution(new String[]{"aba", "abba", "aabbba", "abbaaba"});
        problem17685.solution(new String[]{"go","gone","guild"});
//        problem17685.solution(new String[]{"aaaaa", "aaaab", "aaabb", "aabbb", "abbbb"});
    }

    public int solution(String[] words) {
        // a = 97, z = 122
        int answer = 0;
        int alphaLength = 'z' - 'a' + 1;
        int wordLength = 0;

//        Arrays.sort(words, Comparator.reverseOrder());

        for (String word : words) {
            wordLength = Math.max(wordLength, word.length());
        }

        int[][] board = new int[wordLength][alphaLength];



        for (int i = 0; i < words.length; i++) {
            int prevIdx = 0;
            System.out.println("현재 단어 : " + words[i]);

                for (int j = 0; j < words[i].length(); j++) {
                    int n = (int) words[i].charAt(j) - 97;
                    board[j][n] += 1;
                }

            for (int k = 0; k < wordLength; k++) {
                System.out.println();
                for (int j = 0; j < alphaLength; j++) {
                    System.out.print("[ "+ board[k][j] + " ]");
                }
            }

            System.out.println();

            for (int j = 0; j < words[i].length(); j++) {
                int idx = (int) words[i].charAt(j) - 97;

                prevIdx = j > 0 ? (int)words[i].charAt(j-1) - 97: 0;
                System.out.println("이전 순서 : " + prevIdx);
                System.out.println("현재 순서 : " + idx);
                answer++;
                if (board[j][idx] == 1) break;
                if (j > 0 && idx == prevIdx && board[j][idx] > board[j-1][prevIdx]) {
                    answer--;
                    System.out.println("접근");
                    break;
                }
            }

            System.out.println("현재 카운트 : " + answer);
        }


        System.out.println(answer);
        return answer;
    }
}
