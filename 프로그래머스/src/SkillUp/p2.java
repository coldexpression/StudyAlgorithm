package SkillUp;

import java.util.*;

public class p2 {

    public static void main(String[] args) {
        p2 p2 = new p2();
        p2.solution("100-200*300-500+20");
    }

    public long solution(String expression) {
        long answer = 0;
        int count = 0;
        String numStore = "";
        Queue<String> queue = new LinkedList<>();
        List<String> list = new ArrayList<>();
        queue.add("+-*");
        queue.add("+*-");
        queue.add("-+*");
        queue.add("-*+");
        queue.add("*+-");
        queue.add("*-+");

        for(int i=0;i<expression.length();i++) {
            char exp = expression.charAt(i);
            if (i == expression.length() -1 && !numStore.equals("")) list.add(numStore);
            if (Character.isDigit(exp)) {
                numStore += exp;
            } else {
                list.add(numStore);
                numStore = "";
                list.add(String.valueOf(exp));
            }
        }

        System.out.println(list);

        while(!queue.isEmpty()) {
            String ops = queue.poll();
            List<String> subList = new ArrayList<>(list);
            for(int i=0;i<ops.length();i++) {
                char op = ops.charAt(i);
                for(int j=0;j<subList.size();j++) {
                    if (subList.get(j).equals(String.valueOf(op))) {
                        int n1 = Integer.parseInt(list.get(j-1));
                        int n2 = Integer.parseInt(list.get(j+1));
                        int sum = calc(op, n1, n2);
                        subList.remove(j-1);
                        subList.remove(j-1);
                        subList.remove(j-1);
                        subList.add(j-1, String.valueOf(sum));
                    }
                }
                System.out.println("subList 결과 : " + subList);
            }
        }
        System.out.println(list);
        return answer;
    }

    private int calc(char op, int n1, int n2) {
        switch (op) {
            case '+' : return (n1 + n2);
            case '-' : return (n1 - n2);
            case '*' : return (n1 * n2);
        }
        return 0;
    }
}
