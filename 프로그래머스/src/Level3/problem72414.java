package Level3;

import java.util.*;

public class problem72414 {

    public static void main(String[] args) {
        problem72414 problem72414 = new problem72414();
//        problem72414.solution("02:03:55","00:14:15",new String[]{"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"});
//        problem72414.solution("99:59:59","25:00:00",new String[]{"69:59:59-89:59:59", "01:00:00-21:00:00", "79:59:59-99:59:59", "11:00:00-31:00:00"});
        problem72414.solution("02:03:55","00:14:15",new String[]{"01:20:15-01:45:14", "00:25:50-00:48:29", "00:40:31-01:00:00", "01:37:44-02:02:30", "01:30:59-01:53:29"});
    }

    public String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";
        HashMap<Integer, long[]> logStore = new HashMap<>();
        HashMap<Integer, Long> answerStore = new HashMap<>();
        long playTime = stringToLong(play_time);
        long advTime = stringToLong(adv_time);
        int answerTime = Integer.MAX_VALUE;
        int resultCount = Integer.MIN_VALUE;
        int count = 1;
        if (playTime == advTime) return "00:00:00";
        for(int i=0;i<logs.length;i++) {
            String start = logs[i].split("-")[0];
            String end = logs[i].split("-")[1];
            long startTime = stringToLong(start);
            long endTime = stringToLong(end);
            logStore.put(i, new long[]{startTime, endTime});
        }

        for (Integer integer : logStore.keySet()) {
            long[] temp = logStore.get(integer);
            System.out.println(integer + " 번째");
            System.out.println(longToString(temp[0]));
            System.out.println(longToString(temp[1]));
        }

        // 시작 점부터 탐색
        for(int i=0;i<logs.length;i++) {
            long[] pivotTime = logStore.get(i);
            long startTime = pivotTime[0];
            long endTime = pivotTime[0] + advTime;
            System.out.println("pivotTime : " + longToString(pivotTime[0]));
            count = 1;
            if (endTime <= playTime) {
                for(int j=0;j<logs.length;j++) {
                    if (i != j) {
                        long[] compareTime = logStore.get(j);
                        System.out.println("["+longToString(compareTime[0])+", "+longToString(compareTime[1])+"]");
                        if ((compareTime[0] >= startTime && compareTime[0] <= endTime) || (compareTime[1] >= startTime && compareTime[1] <= endTime)
                                || (compareTime[0] <= startTime && compareTime[1] >= startTime)) {
                            count++;
                            System.out.println(j+" 번째는 통과");
                        }
                    }
                }
                if (resultCount <= count) {
                    answerStore.put(count, Math.min(answerStore.getOrDefault(count, Long.MAX_VALUE), startTime));
                    resultCount = count;
                }
            }
        }

        // 종료 점부터 탐색
        for(int i=0;i<logs.length;i++) {
            long[] pivotTime = logStore.get(i);
            long startTime = pivotTime[1];
            long endTime = pivotTime[1] + advTime;
            System.out.println("pivotTime : " + longToString(pivotTime[1]));
            count = 1;
            if (endTime <= playTime) {
                for (int j=0;j<logs.length;j++) {
                    if (i != j) {
                        long[] compareTime = logStore.get(j);
                        System.out.println("["+longToString(compareTime[0])+", "+longToString(compareTime[1])+"]");
                        if ((compareTime[0] >= startTime && compareTime[0] <= endTime) || (compareTime[1] >= startTime && compareTime[1] <= endTime)
                                || (compareTime[0] <= startTime && compareTime[1] >= startTime)) {
                            count++;
                            System.out.println(j+" 번째는 통과");
                        }
                    }
                }
                if (resultCount <= count) {
                    answerStore.put(count, Math.min(answerStore.getOrDefault(count, Long.MAX_VALUE), startTime));
                    resultCount = count;
                }
            }
        }

//        for(int i=0;i<logs.length;i++) {
//            count = 1;
//            int[] pivotTime = logStore.get(i);
//            System.out.println("pivotTime : " + intToString(pivotTime[0]));
//            for(int j=0;j<logs.length;j++) {
//                if(i != j) {
//                    if(pivotTime[0] + advTime >= logStore.get(j)[0] && pivotTime[0] <= logStore.get(j)[1]) {
//                        System.out.println(j+" 번째는 통과");
//                        count++;
//                    }
//                }
//            }
//            if(resultCount <= count) {
////                System.out.println("pivotTime : " + intToString(pivotTime[0]));
//                System.out.println("count : " + count);
//                answerStore.put(count, Math.min(answerStore.getOrDefault(count, Integer.MAX_VALUE), pivotTime[0]));
//                resultCount = count;
//            }
//        }
        System.out.println(answerStore);
        answer = longToString(answerStore.get(resultCount));
        System.out.println("정답 " + answer);
        return answer;
    }

    private String longToString(long time) {
        long hour = time / 3600;
        time -= hour * 3600;
        long minutes = time / 60;
        time -= minutes * 60;
        long second = time;
        String strHour = hour < 10 ? "0"+hour : String.valueOf(hour);
        String strMinutes = minutes < 10 ? "0"+minutes : String.valueOf(minutes);
        String strSecond = second < 10 ? "0"+second : String.valueOf(second);
        return strHour+":"+strMinutes+":"+strSecond;
    }

    private long stringToLong(String time) {
        long hour = Long.parseLong(time.split(":")[0]);
        long minutes = Long.parseLong(time.split(":")[1]);
        long second = Long.parseLong(time.split(":")[2]);
        long totalTime = (hour*3600) + (minutes*60) + second;
        return totalTime;
    }
}
