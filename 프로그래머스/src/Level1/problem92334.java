package Level1;

import java.util.*;

public class problem92334 {
    public static void main(String[] args) {

    }

    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        int count = 0;
        HashMap<String, HashSet<String>> board = new HashMap<>();
        HashMap<String, HashSet<String>> userBoard = new HashMap<>();
        for (String id : id_list) {
            HashSet<String> set = new HashSet<>();
            HashSet<String> targetSet = new HashSet<>();
            board.put(id, set);
            userBoard.put(id, targetSet);
        }

        for (String info : report) {
            String user = info.split(" ")[0];
            String target = info.split(" ")[1];
            HashSet<String> set = board.get(target);
            HashSet<String> userSet = userBoard.get(user);
            set.add(user);
            userSet.add(target);
            board.put(target, set);
            userBoard.put(user, userSet);
        }

        for (String s : board.keySet()) {
            HashSet<String> set = board.get(s);
            if (set.size() < k) {
                Iterator<String> iter = set.iterator();
                while(iter.hasNext()) {
                    String user = iter.next();
                    userBoard.get(user).remove(s);
                }
            }
        }
        for (String key : userBoard.keySet()) {
            answer[count++] = userBoard.get(key).size();
        }
        return answer;
    }
}
