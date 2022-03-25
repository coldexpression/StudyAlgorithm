package Level3;

import java.util.*;

public class problem72414 {

    public static void main(String[] args) {
        problem72414 problem72414 = new problem72414();
//        problem72414.solution("02:03:55","00:14:15",new String[]{"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"});
        problem72414.solution("99:59:59","25:00:00",new String[]{"69:59:59-89:59:59", "01:00:00-21:00:00", "79:59:59-99:59:59", "11:00:00-31:00:00"});
//        problem72414.solution("02:03:55","00:14:15",new String[]{"01:20:15-01:45:14", "00:25:50-00:48:29", "00:40:31-01:00:00", "01:37:44-02:02:30", "01:30:59-01:53:29"});
    }

    public String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";
        HashMap<Integer, int[]> logStore = new HashMap<>();
        HashMap<Integer, Integer> answerStore = new HashMap<>();
        int playTime = stringToInt(play_time);
        int advTime = stringToInt(adv_time);
        int answerTime = Integer.MAX_VALUE;
        int resultCount = Integer.MIN_VALUE;
        int count = 1;
        if (playTime == advTime) return "00:00:00";
        for(int i=0;i<logs.length;i++) {
            String start = logs[i].split("-")[0];
            String end = logs[i].split("-")[1];
            int startTime = stringToInt(start);
            int endTime = stringToInt(end);
            logStore.put(i, new int[]{startTime, endTime});
        }

        for(int i=0;i<logs.length;i++) {
            count = 1;
            int[] pivotTime = logStore.get(i);
            System.out.println("pivotTime : " + intToString(pivotTime[0]));
            for(int j=0;j<logs.length;j++) {
                if(i != j) {
                    if(pivotTime[0] + advTime >= logStore.get(j)[0] && pivotTime[0] <= logStore.get(j)[1]) {
                        System.out.println(j+" 번째는 통과");
                        count++;
                    }
                }
            }
            if(resultCount <= count) {
//                System.out.println("pivotTime : " + intToString(pivotTime[0]));
                System.out.println("count : " + count);
                answerStore.put(count, Math.min(answerStore.getOrDefault(count, Integer.MAX_VALUE), pivotTime[0]));
                resultCount = count;
            }
        }
        System.out.println(answerStore);
        answer = intToString(answerStore.get(resultCount));
        System.out.println("정답 " + answer);
        return answer;
    }

    private String intToString(int time) {
        int hour = time / 3600;
        time -= hour * 3600;
        int minutes = time / 60;
        time -= minutes * 60;
        int second = time;
        String strHour = hour < 10 ? "0"+hour : String.valueOf(hour);
        String strMinutes = minutes < 10 ? "0"+minutes : String.valueOf(minutes);
        String strSecond = second < 10 ? "0"+second : String.valueOf(second);
        return strHour+":"+strMinutes+":"+strSecond;
    }

    private int stringToInt(String time) {
        int hour = Integer.parseInt(time.split(":")[0]);
        int minutes = Integer.parseInt(time.split(":")[1]);
        int second = Integer.parseInt(time.split(":")[2]);
        int totalTime = (hour*3600) + (minutes*60) + second;
        return totalTime;
    }
}
