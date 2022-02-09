package Level2;

import java.util.*;

public class problem64065 {

    public static void main(String[] args) {
        problem64065 problem64065 = new problem64065();
        problem64065.solution("{{2},{2,1},{2,1,3},{2,1,3,4}}");
    }

    public int[] solution(String s) {
        Map<Integer, String[]> store = new HashMap<>();
        List<Integer> compare = new ArrayList<>();
        int[] answer = {};
        int front = 0;
        int rear = 0;
        int comma = 0;
        String context = "";

        s = s.substring(1, s.length() -1);
        while(s.length() != 0) {
            front = s.indexOf('{');
            rear = s.indexOf('}');
            System.out.println("s : " + s);
            System.out.println("front : " + front);
            System.out.println("rear : " + rear);
            context = s.substring(front + 1, rear);
            System.out.println("context : " + context);

            String[] element = context.split(",");
            store.put(element.length, element);
            s = s.substring(rear + 1);
        }
        compare.add(Integer.parseInt(store.get(1)[0]));
        for(int i=1;i<=store.size();i++) {
            for(int j=0;j<store.get(i).length;j++) {
                if (!compare.contains(Integer.parseInt(store.get(i)[j]))) compare.add(Integer.parseInt(store.get(i)[j]));
            }
        }
        answer = new int[compare.size()];
        for(int i=0;i< compare.size();i++) {
            answer[i] = compare.get(i);
        }
        System.out.println(compare);
        return answer;
    }
}
