package Level3;

import java.util.*;

public class problem81303 {

    public static void main(String[] args) {
        problem81303 problem81303 = new problem81303();
        problem81303.solution(8, 2, new String[]{"D 2","C","U 3","C","D 4","C","U 2","Z","Z"});
//        problem81303.solution(8, 2, new String[]{"D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"});
    }

    public String solution(int n, int k, String[] cmd) {
        String answer = "";
        List<Integer> list = new LinkedList<>();
        Stack<int[]> stack = new Stack<>();
        StringBuilder sb = new StringBuilder("");

        for(int i=0;i<n;i++) list.add(i);

        for(String command : cmd) {
            if (command.equals("C")) {
                int id = list.get(k);
                stack.push(new int[]{k, id});
                list.remove(k);
                k = k == n - 1 ? k - 1 : k;
            } else if (command.equals("Z")) {
                int[] boxes = stack.pop();
                int index = boxes[0];
                int id = boxes[1];
                list.add(index, id);
            } else {
                String direction = command.split(" ")[0];
                int distance = Integer.parseInt(command.split(" ")[1]);
                if (direction.equals("U")) {
                    k -= distance;
                } else {
                    k += distance;
                }
            }
        }
        for(int i=0;i<n;i++) {
            if (list.contains(i)) sb.append("O");
            else sb.append("X");
        }
        answer = sb.toString();
        System.out.println(answer);
        return answer;
    }

}
