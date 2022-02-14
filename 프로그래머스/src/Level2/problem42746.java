package Level2;

import java.util.*;

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
        String answer ="";
        Integer[] array = new Integer[numbers.length];

        for(int i=0;i<numbers.length;i++) array[i] = numbers[i];

        Arrays.sort(array, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String word1 = o1.toString();
                String word2 = o2.toString();
                return ((word2+word1)).compareTo(word1+word2);
            }
        });

        for(int i=0;i<array.length;i++) {
            answer = answer.concat(String.valueOf(array[i]));
        }

        if (answer.charAt(0) == '0') answer = "0";
        System.out.println(answer);
        return answer;
    }


}
