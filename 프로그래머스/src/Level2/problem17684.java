package Level2;

import java.util.*;


public class problem17684 {

    HashMap<String, Integer> store = new HashMap<>();
    Queue<String> waitList = new LinkedList<>();
    List<Integer> answerList = new ArrayList<>();

    public static void main(String[] args) {
        problem17684 problem17684 = new problem17684();
        problem17684.solution("KAKAO");
    }

    public int[] solution(String msg) {
        int[] answer = {};
        String start = "";

        int maxNum = 26;
        init();
        for(int i=0;i<msg.length();i++) waitList.add(String.valueOf(msg.charAt(i)));

        while(!waitList.isEmpty()) {
            start = waitList.poll();
            while(true) {
                if (waitList.isEmpty()) {
                    answerList.add(store.get(start));
                    break;
                }

                if (!store.containsKey(start + waitList.peek())) {
                    answerList.add(store.get(start));
                    maxNum++;
                    store.put(start + waitList.peek(), maxNum);
                    break;
                } else {
                    start += waitList.poll();
                }
            }
        }

        answer = new int[answerList.size()];
        for(int i=0;i<answerList.size();i++) answer[i] = answerList.get(i);
        return answer;
    }

    private void init() {
        char word = 'A';
        int count = 1;
        while(count <= 26) {
            store.put(String.valueOf(word), count);
            count++;
            word = (char)(word + 1);
        }
    }
}
