package Level3;

import java.util.*;

public class problem72414 {

    public static void main(String[] args) {
        problem72414 problem72414 = new problem72414();
        problem72414.solution("02:03:55","00:14:15",new String[]{"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"});
//        problem72414.solution("99:59:59","25:00:00",new String[]{"69:59:59-89:59:59", "01:00:00-21:00:00", "79:59:59-99:59:59", "11:00:00-31:00:00"});
//        problem72414.solution("02:03:55","00:14:15",new String[]{"01:20:15-01:45:14", "00:25:50-00:48:29", "00:40:31-01:00:00", "01:37:44-02:02:30", "01:30:59-01:53:29"});
    }

    public String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";
        HashMap<Long, Long> resultMap = new HashMap<>();
        List<String> logList = new ArrayList<>();
        long playEndTime = stringToLong(play_time);
        long advTime = stringToLong(adv_time);
        Arrays.sort(logs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                long t1 = stringToLong(o1.split("-")[0]) + stringToLong(o1.split("-")[1]);
                long t2 = stringToLong(o2.split("-")[0]) + stringToLong(o2.split("-")[1]);
                return (int)t1-(int)t2;
            }
        });
        logList.addAll(Arrays.asList(logs));

        for(long i=0;advTime+i<=playEndTime;i++) {
            long start = i;
            long end = advTime + start;
            long totalPlayTime = 0;
            List<String> currentList = new ArrayList<>();
            for(int j=0;j<logList.size();j++) {
                if (logList.isEmpty()) break;
                long logStart = stringToLong(logList.get(j).split("-")[0]);
                long logEnd = stringToLong(logList.get(j).split("-")[1]);
                if ((start <= logStart && end >= logEnd) || (start > logStart && end < logEnd) || (start <= logStart && end >= logStart) || (start <= logEnd && end >= logEnd)) {
                    currentList.add(logList.get(j));
                } else if (start > logEnd) {
                    logList.remove(j);
                    j = j - 1;
                } else if (logStart > start && logStart > end) break;
            }

            if (!currentList.isEmpty()) {
                System.out.println(currentList);
//                start = Math.max(start, stringToLong(currentList.get(0).split("-")[0]));
                System.out.println("start : " + longToString(start));
                System.out.println("end : " + longToString(end));
                if (currentList.size() > 1) {
                    for (int j = 0; j < currentList.size(); j++) {
                        long t1Start = stringToLong(currentList.get(j).split("-")[0]);
                        t1Start = Math.max(t1Start, start);
                        long t1End = stringToLong(currentList.get(j).split("-")[1]);
                        t1End = Math.min(t1End, end);
                        totalPlayTime += t1End - t1Start;
                    }
                } else if (currentList.size() == 1){
                    long t1Start = stringToLong(currentList.get(0).split("-")[0]);
                    long t1End = stringToLong(currentList.get(0).split("-")[1]);
                    t1End = Math.min(t1End, end);
                    totalPlayTime += t1End - t1Start;
                }
                if (totalPlayTime > 0)
                    resultMap.put(totalPlayTime, Math.min(resultMap.getOrDefault(totalPlayTime, Long.MAX_VALUE), start));
            } else {
                i = stringToLong(logList.get(0).split("-")[0])-advTime-1;
            }
        }
        System.out.println(resultMap);
//        System.out.println(longToString(3704));
//        System.out.println(longToString(696));
        long max = 0;
        for(long key: resultMap.keySet()) max = Math.max(max, key);
        System.out.println(longToString(resultMap.get(max)));
        System.out.println(longToString(max));
        answer = longToString(resultMap.get(max));
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
