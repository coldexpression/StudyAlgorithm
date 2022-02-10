package Level2;

import java.util.*;

public class problem67257 {

    static List<Long> numStore = new ArrayList<>();
    static List<Character> opStore = new ArrayList<>();
    static List<Character> defaultOp = new ArrayList<>();
    static long max = -1;
    static boolean[] visited = new boolean[3];

    public static void main(String[] args) {
        problem67257 problem67257 = new problem67257();
        String test = "100-200*300-500+20";
//        System.out.println(test.charAt(4));
//        System.out.println(test.indexOf("-"));
//        System.out.println(test.indexOf("-",4));
        problem67257.solution("100-200*300-500+20");
    }

    public long solution(String expression) {
        long answer = 0;
        String num = "";
        Arrays.fill(visited, false);
        defaultOp.add('+');
        defaultOp.add('-');
        defaultOp.add('*');
        for(int i=0;i<expression.length();i++){
            if (expression.charAt(i) >= '0' && expression.charAt(i) <= '9') {
                num = num + expression.charAt(i);
            } else {
                numStore.add(Long.parseLong(num));
                opStore.add(expression.charAt(i));
                num = "";
            }
        }
        numStore.add(Long.parseLong(num));
        System.out.println(numStore);
        System.out.println(opStore);
        dfs(0, new char[3]);
        answer = max;
        System.out.println(answer);
        return answer;
    }

    public static void dfs(int length, char[] ops) {
        if (length == 3) {
            List<Long> tmpNumStore = new ArrayList<>(numStore);
            List<Character> tmpOpStore = new ArrayList<>(opStore);
//            for (char op : ops) {
//                System.out.print(op+" ");
//            }
            System.out.println();
            for(int i=0; i<ops.length;i++) {
                for(int j=0;j<tmpOpStore.size();j++) {
                    if (ops[i] == tmpOpStore.get(j)) {
//                        System.out.println("j : " + j);
//                        System.out.println("ops : " + ops[i] );
//                        System.out.println("tmpOpStoreSize : " + tmpOpStore.size());
                        long sum = calc(tmpNumStore.remove(j), tmpNumStore.remove(j), tmpOpStore.remove(j));
//                        char sumOp = sum > 0 ? '+' : '-';
                        System.out.println("sum : " + sum);
//                        System.out.println("sumOp : " + sumOp);
                        tmpNumStore.add(j, sum);
//                        tmpOpStore.add(sumOp);
                        System.out.println("tmpNumStore : "+ tmpNumStore);
                        System.out.println("tmpOpStore : "+tmpOpStore);
                        j--;
                    }
                }
//                if (tmpNumStore.size() == 1 && tmpOpStore.size() == 1) break;
            }
            max = Math.max(max, Math.abs(tmpNumStore.get(0)));
            System.out.println("max : " + max);
//            return;
        }
            for(int i=0;i<ops.length;i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    ops[length] = defaultOp.get(i);
                    System.out.println("첫 진입 ops : " + Arrays.toString(ops));
                    dfs(length + 1, ops);
                    visited[i] = false;
                }
            }
    }

    public static long calc(long num1, long num2, char op) {
        System.out.println("num1 : " + num1);
        System.out.println("num2 : " + num2);
        System.out.println("op : " + op);
        switch (op) {
            case '+' : return num1+num2;
            case '-' : return num1-num2;
            case '*' : return num1*num2;
            default: break;
        }
        return 0;
    }
}


