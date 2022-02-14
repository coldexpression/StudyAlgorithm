package Level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class problem42746 {

    static boolean[] visited;
    static int wordCount ;
    static String board;
    static int max;
    static List<String> store = new ArrayList<>();

    public static void main(String[] args) {
        problem42746 problem42746 = new problem42746();
        problem42746.solution(new int[]{6,10,2});
    }

    public String solution(int[] numbers) {
        Stack<String> tmpStore = new Stack<>();
        String answer = "";
        char pivotWord = 0;
        int maxLength = 0;
        int count = 0;
        int startIndex = 0;
        int pivotLength = 0;
        String[] number = new String[numbers.length];
        for(int i=0;i<number.length;i++) number[i] = String.valueOf(numbers[i]);
        Arrays.sort(number);
        for(int i=number.length-1;i>=0;i--) {
            board = "";
            max = -1;
            wordCount = 0;
            if (pivotWord != number[i].charAt(0)) {
                pivotWord = number[i].charAt(0);
                maxLength = number[i].length();
                System.out.println("i : " + i);
                System.out.println("pivotWord :" + pivotWord);
                for (int j = i - 1; j >= 0; j--) {
                    if (number[j].charAt(0) == pivotWord) {
                        count++;
                    } else {
                        break;
                    }
                }
                startIndex = i - count;
                if (count == 0) {
                    answer = answer.concat(number[i]);
                } else {
                    System.out.println("startIndex : " + startIndex);
                    for (int j = 0; j <= 4; j++) {
                        pivotLength = j;
                        for (int k = startIndex; k <= i; k++) {
                            if (number[k].length() == pivotLength) {
                                store.add(number[k]);
                            }
                        }
                    }
                    visited = new boolean[count+1];
                    wordCount = store.size();
                    count = 0;
                    System.out.println("store : " + store);
                    System.out.println("wordCount : " + wordCount);
                    dfs(0);
                }
            }
        }
        System.out.println("max : " + max);
        answer = max != -1 ? answer.concat(String.valueOf(max)) : answer;
//        for(String num: number) System.out.println(num);
//        visited = new boolean[numbers.length];
//        count = numbers.length;
//        board = "";
//        max = -1;
//        dfs(0, number);
//        answer = String.valueOf(max);
        System.out.println(answer);
        return answer;
    }

    public static void dfs(int start) {
        if (start == wordCount) {
            max = Math.max(max, Integer.parseInt(board));
            System.out.println("board : " + board);
        }
            for(int i=0;i<store.size();i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    board = board.concat(store.get(i));
                    dfs(start+1);
                    board = board.substring(0, board.length()-store.get(i).length());
                    visited[i] = false;
                }
            }

    }
}
