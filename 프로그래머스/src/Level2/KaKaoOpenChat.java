package Level2;

import java.util.*;

public class KaKaoOpenChat {
    public static void main(String[] args) {
        String[] answer = {};
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        KaKaoOpenChat kaKaoOpenChat = new KaKaoOpenChat();
        answer = kaKaoOpenChat.solution(record);
        for (String s : answer) {
            System.out.println(s);
        }
    }

    public String[] solution(String[] record) {
        String[] answer = {};
        List<String> real_answer = new ArrayList<String>();
        int index = 0;
        Map<String, String> name = new HashMap<>();
        for (String s : record) {
            String[] box = s.split(" ");
            if (box[0].equals("Enter")) {
                name.put(box[1], box[2]);
                real_answer.add(box[1] + "님이 들어왔습니다.");
            } else if (box[0].equals("Leave")) {
                real_answer.add(box[1] + "님이 나갔습니다.");
            } else if (box[0].equals("Change")) {
                name.put(box[1], box[2]);
            }

        }

        String[] simpleanswer = new String[real_answer.size()];
        real_answer.toArray(simpleanswer);

        answer = simpleanswer;

        for (String context : answer) {
            for (String key : name.keySet()) {
                if (context.contains(key)) {
                    String replace = context.replace(key, name.get(key));
                    answer[index] = replace;
                    index++;
                }
            }
        }

        return answer;
    }
}
