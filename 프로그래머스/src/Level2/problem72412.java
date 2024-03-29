package Level2;

import java.util.*;

public class problem72412 {

    public static void main(String[] args) {
        problem72412 problem72412 = new problem72412();
//        problem72412.solution(new String[]{"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"},
//                new String[]{"java and frontend and - and - 1"});
        problem72412.solution(new String[]{"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"},
                new String[]{"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"});
    }

    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        int count = 0;
        int index = 0;
        HashMap<String, List<Integer>> originalPeopleInfos = new HashMap<>();
        HashMap<String, List<Integer>> copyPeopleInfos = new HashMap<>();

        for(String infos: info) {
            List<Integer> scoreStore = new ArrayList<>();
            String[] information = infos.split(" ");
            String key = information[0] + information[1] +information[2] + information[3];
            int point = Integer.parseInt(information[4]);
            if (!originalPeopleInfos.containsKey(key)) {
                scoreStore.add(point);
                originalPeopleInfos.put(key, scoreStore);
            } else {
                scoreStore = originalPeopleInfos.get(key);
                scoreStore.add(point);
                originalPeopleInfos.put(key, scoreStore);
            }
        }

        for(String key : originalPeopleInfos.keySet()) {
            List<Integer> score = originalPeopleInfos.get(key);
            Collections.sort(score, Collections.reverseOrder());
            originalPeopleInfos.put(key, score);
        }

        copyPeopleInfos = (HashMap<String, List<Integer>>) originalPeopleInfos.clone();

        for(String querys: query) {
            String board = querys.replaceAll(" and ", " ");
//            board = board.replaceAll("-"," ");
            String[] boards = board.split(" ");
            for(String word: copyPeopleInfos.keySet()) System.out.println(word);
            System.out.println("룰 시작");
            for(String rule: boards) {
                System.out.println(rule);
                if (rule.charAt(0) >= '0' && rule.charAt(0) <= '9') {
                    answer[index] = rulesScoreCheck(copyPeopleInfos, Integer.parseInt(rule));
                } else if (!rule.equals("-")) {
                    copyPeopleInfos = rulesCheck(copyPeopleInfos, rule);
                }
            }
            System.out.println("룰 종료");

            for (String s : copyPeopleInfos.keySet()) {
                System.out.println("key => " + s);
                System.out.println("value => " + copyPeopleInfos.get(s));
            }


            copyPeopleInfos = (HashMap<String, List<Integer>>) originalPeopleInfos.clone();
            index++;
        }
        for (int i : answer) {
            System.out.println(i);
        }

        return answer;
    }

    static HashMap<String, List<Integer>> rulesCheck(HashMap<String, List<Integer>> prevInfos, String rule) {
        System.out.println("진입 룰 : " + rule);
        HashMap<String, List<Integer>> tempPeopleInfos = new HashMap<>();
        for(String info: prevInfos.keySet()) {
            if (info.contains(rule)) {
                tempPeopleInfos.put(info, prevInfos.get(info));
            }
        }
        return tempPeopleInfos;
    }

    static int rulesScoreCheck(HashMap<String, List<Integer>> prevInfos, int score) {
        System.out.println("진입 숫자 룰 : " + score);
        int answer = 0;
        HashMap<String, List<Integer>> tempPeopleInfos = new HashMap<>();
        for(List<Integer> info: prevInfos.values()) {

            for(int ele: info) {
                if (ele >= score) answer++;
                else break;
            }
        }
        return answer;
    }

}
