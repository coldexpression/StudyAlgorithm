package SkillUp;

import java.util.*;

public class p4 {

    public static void main(String[] args) {
        p4 p4 = new p4();
//        p4.solution("ABCDEFG", new String[]{"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"});
        p4.solution("ABC", new String[]{"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"});
    }

    public String solution(String m, String[] musicinfos) {
        String answer = "";
        String[] melody = new String[]{"C","C#","D","D#","E","F","F#","G","G#","A","A#","B"};
        HashMap<Integer, String> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        for(String info: musicinfos) {
            int useTime = timeToMinutes(info.split(",")[0], info.split(",")[1]);
            int count = 0;
            int index = 0;
            String music = info.split(",")[3];
            String board = "";
            System.out.println(useTime);
            for(int i=0;i<useTime;i++) {
                if (index == music.length()) index = 0;
                if (index < music.length() -1 && music.charAt(index+1) == '#') {
                    board += String.valueOf(music.charAt(index)) + String.valueOf(music.charAt(index+1));
                    index += 2;
                    count++;
                } else {
                    board += String.valueOf(music.charAt(index));
                    index++;
                    count++;
                }
            }
            if (board.contains(m)) {
                if (m.charAt(m.length()-1) != '#' && (board.indexOf(m)+m.length() < board.length()) && (board.charAt(board.indexOf(m)+m.length()) != '#')) {
                    list.add(info);
                } else if (m.charAt(m.length()-1) == '#') list.add(info);
            }
            System.out.println(list);
        }
        if (list.isEmpty()) return "(None)";
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int t1 = timeToMinutes(o1.split(",")[0], o1.split(",")[1]);
                int t2 = timeToMinutes(o2.split(",")[0], o2.split(",")[1]);
                if (t1 > t2) return t1 - t2;
                else if (t2 > t1) return t2 - t1;
                return 0;
            }
        });
        answer = list.get(0).split(",")[2];
        System.out.println(answer);
        return answer;
    }

    private int timeToMinutes(String startTime, String endTime) {
        int t1 = Integer.parseInt(startTime.split(":")[0]) * 60 + Integer.parseInt(startTime.split(":")[1]);
        int t2 = Integer.parseInt(endTime.split(":")[0]) * 60 + Integer.parseInt(endTime.split(":")[1]);
        return t2 - t1;
    }
}
