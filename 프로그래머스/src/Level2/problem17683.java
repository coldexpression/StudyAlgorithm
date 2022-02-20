package Level2;

import java.util.*;

public class problem17683 {

    public static void main(String[] args) {

    }

    public String solution(String m, String[] musicinfos) {
        String answer = "";
        HashMap<Integer, String> melodyInfo = new HashMap<>();

        for(String infos: musicinfos) {
            String[] info = infos.split(",");
            int time = timeCalc(info[0], info[1]);
            int count = 1;
            melodyInfo.put(0, info[2]); // 0번 키에는 노래의 제목을 저장

            for(int i=0;i<info[3].length();i++) {
                if (i == info[3].length() - 1) {
                    melodyInfo.put(count, String.valueOf(info[3].charAt(i)));
                    break;
                }

                if (info[3].charAt(i+1) == '#') {
                    melodyInfo.put(count, String.valueOf(info[3].charAt(i)) + "#");
                    i++;
                } else {
                    melodyInfo.put(count, String.valueOf(info[3].charAt(i)));
                }
                count++;
            }


        }
        return answer;
    }

    static int timeCalc(String start, String end) {
        int startHour = Integer.parseInt(start.split(":")[0]);
        int startMinute = Integer.parseInt(start.split(";")[1]);
        int endHour = Integer.parseInt(end.split(":")[0]);
        int endMinute = Integer.parseInt(end.split(":")[1]);;
        int hour = endHour - startHour;
        int minute = endMinute - startMinute;
        return minute + (60*hour);
    }
}
