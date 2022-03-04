package Level2;

import java.util.*;

public class problem12981 {

    public static void main(String[] args) {

    }

    public int[] solution(int n, String[] words) {
        HashMap<String, Integer> wordInfo = new HashMap<>();
        int[] answer = new int[2];
        int peopleNum = 1;
        int index = 0;
        int round = 1;
        char prev = words[0].charAt(words[0].length()-1);
        while(index != words.length) {
            if (index > 0 && prev != words[index].charAt(0)) break;

            if (wordInfo.containsKey(words[index])) break;

            prev = words[index].charAt(words[index].length()-1);
            wordInfo.put(words[index++], 0);

            if (peopleNum == n) {
                peopleNum = (peopleNum - n) + 1;
                round++;
            } else peopleNum++;
        }
        answer[0] = index == words.length ? 0 : peopleNum;
        answer[1] = index == words.length ? 0 : round;

        return answer;
    }
}
