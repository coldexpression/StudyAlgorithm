package LinePlusTest;

import java.util.*;

public class p3 {

    public static void main(String[] args) {
        p3 p3 = new p3();
        p3.solution(3, new String[]{"development","marketing","hometask"}, new String[]{"recruitment","education","officetask"},
                new String[]{"1 development hometask","1 recruitment marketing","2 hometask","2 development marketing hometask","3 marketing","3 officetask","3 development"});
    }

    public int[] solution(int num_teams, String[] remote_tasks, String[] office_tasks, String[] employees) {
        int[] answer = {};
        HashMap<Integer,HashMap<Integer,String>> store = new HashMap<>();
        HashSet<String> remoteSet = new HashSet<>(Arrays.asList(remote_tasks));
        List<Integer> answerList = new ArrayList<>();

        for(int i=0;i<num_teams;i++) {
            HashMap<Integer, String> tempMap = new HashMap<>();
            store.put(i, tempMap);
        }

        for(int i=0;i<employees.length;i++) {
            String[] s = employees[i].split(" ");
            HashMap<Integer, String> tempMap = store.get(Integer.parseInt(s[0])-1);
            String board = "";
            for(int j=1;j<s.length;j++) {
                board = j == s.length -1 ? board + s[j] : board + s[j] + " ";
            }
            tempMap.put(i, board);
            store.put(Integer.parseInt(s[0])-1, tempMap);
        }

        for (int teamNumber : store.keySet()) {
            HashMap<Integer, String> memberMap = store.get(teamNumber);
            List<Integer> remoteList = new ArrayList<>();
            List<Integer> officeList = new ArrayList<>();
            boolean check = false;
            for (int memberIndex : memberMap.keySet()) {
                boolean homeCheck = false;
                boolean officeCheck = false;
                String tasks = memberMap.get(memberIndex);
                String[] s = tasks.split(" ");
                for (int i = 0; i < s.length; i++) {
                    if (remoteSet.contains(s[i])) homeCheck = true;
                    else officeCheck = true;

                }

                if (homeCheck && !officeCheck) {
                    remoteList.add(memberIndex);
                } else if (officeCheck) {
                    officeList.add(memberIndex);
                }

            }
            if(officeList.isEmpty()) {
                remoteList.remove(0);
                answerList.addAll(remoteList);
            } else answerList.addAll(remoteList);
        }

        answer = new int[answerList.size()];
        for(int i=0;i<answer.length;i++) {
            answer[i] = answerList.get(i) + 1;
        }
        Arrays.sort(answer);
        return answer;
    }
}
