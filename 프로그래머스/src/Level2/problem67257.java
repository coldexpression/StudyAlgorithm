package Level2;

import java.util.*;

public class problem67257 {

    static String op = "OOO";
    static List<Character> opStore = new ArrayList<>();
    static List<Long> sumStore = new ArrayList<>();

    public static void main(String[] args) {
        problem67257 problem67257 = new problem67257();
        String test = "100-200*300-500+20";
//        System.out.println(test.charAt(4));
//        System.out.println(test.indexOf("-"));
//        System.out.println(test.indexOf("-",4));
        problem67257.solution("177-661*999*99-133+221+334+555-166-144-551-166*166-166*166-133*88*55-11*4+55*888*454*12+11-66+444*99");
    }

    public long solution(String expression) {
        long answer = 0;
        long max = 0;
        opStore.add('+');
        opStore.add('-');
        opStore.add('*');
        dfs(expression, 0);
        for(int i=0;i<sumStore.size();i++) {
            max = Math.max(max, sumStore.get(i));
        }
        answer = max;
        System.out.println("정답 : " + answer);
        return answer;
    }

    public static void dfs(String expression, int length) {
        if (length == 3) {
            System.out.println("최종 op : " + op);
            sumStore.add(Math.abs(calc(expression)));
            System.out.println("sumStore : " + sumStore);

        } else {
            for (int i=0;i<opStore.size();i++) {
                    if (!op.contains(String.valueOf(opStore.get(i)))) {
//                        op = op.replace(op.charAt(length), opStore.get(i));
                        char[] operation = op.toCharArray();
                        operation[length] = opStore.get(i);
                        op = String.valueOf(operation[0]) + String.valueOf(operation[1]) + String.valueOf(operation[2]);
                        System.out.println("bfs 전 op : " + op);
                        length++;
                        dfs(expression, length);
                        op = op.replace(op.charAt(length-1), '0');
                        System.out.println("종료 후 op : " + op);
                        length--;
                    }
                }
        }
    }

    public static long calc(String expression) {
        boolean minus1 = false;
        boolean minus2 = false;
        long result = 0;
        long sum = 0;
        int position = 0;
        char pick_word = 0;
        int index = 0;
        char[] operation = op.toCharArray();
        System.out.println("op : " + op);
        for(int i=0;i<operation.length;i++) {
            Stack<Integer> opPositionStore = new Stack<>();
            while (true) {
                Stack<Character> tmp1 = new Stack<>();
                List<Character> tmp2 = new ArrayList<>();
                String str_num1 = "";
                String str_num2 = "";
                minus2 = false;
                minus1 = false;
//                System.out.println("[" + i + "] expression : " + expression);
                if (expression.contains(String.valueOf(operation[i]))) {
                    position = opPositionStore.contains(position) ? expression.indexOf(operation[i], opPositionStore.peek()+1) : expression.indexOf(operation[i]);
                    if (position == -1) break;
                    opPositionStore.push(position);
                    System.out.println("opPositionStore : " + opPositionStore);
//                    System.out.println("operation : " + operation[i]);
//                    System.out.println("position : " + position);

//                    if (position == 5) {
//                        System.out.println(expression.indexOf(position-1));
//                        System.out.println(expression.charAt(position-1) == '+');
//                        System.out.println(expression.charAt(position-1) == '*');
//                    }
                    if(expression.length() > position && position > 0 && (expression.charAt(position-1) == '+' || expression.charAt(position-1) == '*') && expression.indexOf('-', position+1) == -1) {
                        System.out.println("접근");
                        break;
                    }

                    System.out.println("position : " + position);

                    for (int j = position - 1; j >= 0; j--) {
                        pick_word = expression.charAt(j);
//                        System.out.println("pick_word : " + pick_word);
                        if (operation[i] == '-' && pick_word == '-') {
                            minus1 = true;
                            continue;
                        } else if (operation[i] == '+' && pick_word == '-' && j == 0) {
                            minus1 = true;
                            break;
                        }

                        if (pick_word != '+' && pick_word != '-' && pick_word != '*') {
                            tmp1.push(pick_word);
                        } else {
                            break;
                        }
                    }
                    for (int j = position + 1; j < expression.length(); j++) {
                        pick_word = expression.charAt(j);
//                        System.out.println("pick_word : " + pick_word);
                        if (j == position + 1 && pick_word == '-') {
                            minus2 = true;
                            continue;
                        }

                        if (pick_word != '+' && pick_word != '-' && pick_word != '*') {
                            tmp2.add(pick_word);
                        } else {
                            break;
                        }
                    }

//                    System.out.println(tmp1);
                    if (tmp1.isEmpty()) continue;

                    while (!tmp1.isEmpty()) {
                        str_num1 += tmp1.pop();
                    }

                    while (!tmp2.isEmpty()) {
                        str_num2 += tmp2.get(index);
                        tmp2.remove(index);
                    }



                    System.out.println("str_num1 : " + str_num1);
                    System.out.println("str_num2 : " + str_num2);
                    System.out.println("operation : " + operation[i]);
                    str_num1 = minus1 ? "-" + str_num1 : str_num1;
                    str_num2 = minus2 ? "-" + str_num2 : str_num2;
                    System.out.println("str_num1 minus : " +str_num1);
                    System.out.println("str_num2 minus : " +str_num2);
                    result = operator(str_num1, str_num2, operation[i]);
                    System.out.println(result);
                    expression = expression.replace(str_num1 + operation[i] + str_num2, String.valueOf(result));
                    expression = expression.replaceAll("--","");
                    opPositionStore.clear();
                    System.out.println("expression : " + expression);
                } else {
                    break;
                }

                if (!(expression.contains("+") || expression.contains("-") || expression.contains("*"))) {
                    sum = Long.parseLong(expression);
                } else if (expression.charAt(0) == '-' && expression.charAt(1) == '-') {
                    sum = Long.parseLong(expression.substring(2));
                } else if (expression.charAt(0) == '-' && (expression.indexOf('+') == -1 && expression.indexOf('*') == -1 && expression.indexOf('-', 1) == -1)) {
                    sum = Long.parseLong(expression);
                }
            }
        }
        System.out.println("sum : " + sum);
        return sum;
    }

    public static long operator(String n1, String n2, char ops) {
        long sum = 0;
        switch (ops) {
            case '+' : sum = Long.parseLong(n1) + Long.parseLong(n2); break;
            case '-' : sum = Long.parseLong(n1) - Long.parseLong(n2); break;
            case '*' : sum = Long.parseLong(n1) * Long.parseLong(n2); break;
            default: break;
        }
        return sum;
    }
}
