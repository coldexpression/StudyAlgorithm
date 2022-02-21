package Level2;

import java.util.*;

public class problem17683 {

    public static void main(String[] args) {
        problem17683 problem17683 = new problem17683();
//        problem17683.solution("ABCDEFG", new String[]{"12:00,12:14,HELLO,CDEFGAB","13:00,13:05,WORLD,ABCDEF"});
//        problem17683.solution("ABC", new String[]{"03:00,00:00,FOO,ABC","03:00,00:00,BAR,ABC"});
        problem17683.solution("C#",new String[]{"03:00,03:01,TEST,C#","04:00,04:02,TEST2,C#CC#","04:00,04:03,TEST3,CC#"});
    }

    public String solution(String m, String[] musicinfos) {
        String answer = "";
        HashMap<Integer, String> melodyInfo = new HashMap<>();
        HashMap<String, Integer> existMelody = new HashMap<>();
        List<Integer> maxScore = new ArrayList<>();
        String[] shapBigMelody = new String[]{"A#","C#","D#","F#","G#"};
        String[] shapSmallMelody = new String[]{"a#","c#","d#","f#","g#"};

        for(int i=0;i<shapBigMelody.length;i++) {
            m = m.replaceAll(shapBigMelody[i], shapSmallMelody[i]);
        }

        for(String infos: musicinfos) {
            String[] info = infos.split(",");
//            for (String s : info) {
//                System.out.println(s);
//            }
            int time = timeCalc(info[0], info[1]);
            int timeCount = 1;
            int count = 1;
            int length = info[3].length();
            String board = "";
            melodyInfo.put(0, info[2]); // 0번 키에는 노래의 제목을 저장

            for (String value : melodyInfo.values()) {
                System.out.println(value);
            }

            for(int i=0;i<length;i++) {
                System.out.println("i > " + i);
                if (i == length - 1) {
                    melodyInfo.put(count, String.valueOf(info[3].charAt(i)));
                    break;
                }

                if (info[3].charAt(i+1) == '#') {
                    melodyInfo.put(count, String.valueOf(info[3].charAt(i)).toLowerCase() + "#");
                    i++;
                } else {
                    melodyInfo.put(count, String.valueOf(info[3].charAt(i)));
                }
                count++;
            }
            count = 1;


            // 시간에 따른 악보 값 추가
            while(timeCount != time+1) {
                if (count == melodyInfo.size()) count = 1;
                board = board.concat(melodyInfo.get(count));
                count++;
                timeCount++;
            }

            System.out.println("총 걸린 시간 : " + time);
            System.out.println("측정 시간 : " + timeCount);
            System.out.println("비교 문자 : " + m);
            System.out.println("보드 : " + board);

            if (board.indexOf(m) != -1) {
                if (maxScore.isEmpty()) {
                    maxScore.add(time);
                    answer = melodyInfo.get(0);
                }
                else {
                    if (maxScore.get(0) < time) {
                        maxScore.set(0, time);
                        answer = melodyInfo.get(0);
                    }
                }
            }
            melodyInfo.clear();
        }
        if (maxScore.isEmpty()) answer = "(None)";
        System.out.println("정답 : " + answer);
        maxScore.clear();
        return answer;
    }

    static int timeCalc(String start, String end) {
        int startHour = Integer.parseInt(start.split(":")[0]);
        int startMinute = Integer.parseInt(start.split(":")[1]);
        int endHour = Integer.parseInt(end.split(":")[0]);
        int endMinute = Integer.parseInt(end.split(":")[1]);;
        int hour = endHour - startHour;
        int minute = endMinute - startMinute;
        hour = hour < 0 ? hour + 24 : hour;
        return minute + (60*hour);
    }
}
