package Level2;

import java.util.*;

public class problem17687 {

    public static void main(String[] args) {
        problem17687 problem17687 = new problem17687();
        problem17687.solution(16, 16, 2, 1);
    }

    public String solution(int n, int t, int m, int p) {
        String answer = "";
        Stack<String> board = new Stack<>();
        List<String> store = new ArrayList<>();
        store.add("0");
        int num = 1;
        int count = 1;
        int order = p - 1;
        while(answer.length() != t) {
            num = count;
            while(true) {
                board.push(String.valueOf(num%n));
                if (num / n == 0) break;
                num = num / n;
            }
            while(!board.isEmpty()) store.add(changeWord(board.pop()));
            if (order < store.size()) {
                answer = answer.concat(store.get(order));
                order = order + m;
            }
            count++;
        }

        System.out.println(answer);
        return answer;
    }

    private String changeWord(String num) {
        switch(num) {
            case "10" : return "A";
            case "11" : return "B";
            case "12" : return "C";
            case "13" : return "D";
            case "14" : return "E";
            case "15" : return "F";
            default : return num;
        }
    }

}
