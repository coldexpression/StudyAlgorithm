package Level3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class problem17678 {

    public static void main(String[] args) {
        problem17678 problem17678 = new problem17678();
//        problem17678.solution(1, 1, 5, new String[]{"08:00", "08:01", "08:02", "08:03"});
//        problem17678.solution(2, 10, 2, new String[]{"09:10", "09:09", "08:00"});
//        problem17678.solution(1, 1, 5, new String[]{"00:01", "00:01", "00:01", "00:01", "00:01"});
//        problem17678.solution(2, 1, 2, new String[]{"09:00", "09:00", "09:00", "09:00"});
//        problem17678.solution(10,60,45, new String[]{"23:59","23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59"});
        problem17678.solution(10,60,45, new String[]{"1:00","11:00", "10:59", "2:12", "2:00", "13:59", "15:59", "24:00", "24:00", "24:00", "24:00", "24:00", "24:00", "24:00", "24:00"});
    }

    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        String startTime = "09:00";
        HashMap<String, Stack<String>> busTime = new HashMap<>();
        PriorityQueue<String> originTimes = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
                Date date1 = null;
                Date date2 = null;
                try {
                    date1 = simpleDateFormat.parse(o1);
                    date2 = simpleDateFormat.parse(o2);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                return date1.compareTo(date2);
            }
        });
        PriorityQueue<String> nextTimes = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
                Date date1 = null;
                Date date2 = null;
                try {
                    date1 = simpleDateFormat.parse(o1);
                    date2 = simpleDateFormat.parse(o2);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                return date2.compareTo(date1);
            }
        });
        int originM = m;
        for(int i=0;i<timetable.length;i++) timetable[i] = timetable[i].equals("24:00") ? "23:59" : timetable[i];


        for(String time: timetable) originTimes.add(time);

        while(n != 0) {
//            PriorityQueue<String> times = new PriorityQueue<>(Collections.reverseOrder());
            Stack<String> times = new Stack<>();
            int startHour = Integer.parseInt(startTime.split(":")[0]);
            int startMinutes = Integer.parseInt(startTime.split(":")[1]);
            int waitHour = 0;
            int waitMinutes = 0;
            nextTimes.add(startTime);
            m = originM;
            while (m != 0) {
                String waitTime = originTimes.peek();
                if (originTimes.isEmpty()) break;
                waitHour = Integer.parseInt(waitTime.split(":")[0]);
                waitMinutes = Integer.parseInt(waitTime.split(":")[1]);

                if (startHour > waitHour || (startHour == waitHour && startMinutes >= waitMinutes)) {
                    times.add(waitTime);
                    originTimes.poll();
                    m--;
                } else break;
            }

            busTime.put(startTime, times);
            System.out.println(busTime);
            n--;
            startMinutes = startMinutes + t < 60 ? startMinutes + t : 60 - t;
            startHour = startMinutes <= 0 ? startHour + 1 : startHour;
            startMinutes = Math.abs(startMinutes);
            startTime = "";
            startTime = startHour < 10 ? startTime.concat("0" + String.valueOf(startHour)) : startTime.concat(String.valueOf(startHour));
            startTime += ":";
            startTime = startMinutes < 10 ? startTime.concat("0" + String.valueOf(startMinutes)) : startTime.concat(String.valueOf(startMinutes));
            System.out.println("startTime : " + startTime);
        }

        System.out.println(busTime);
        System.out.println(nextTimes);
        String pickTime = nextTimes.poll();
        System.out.println("pickTime : " + pickTime);
        if (!busTime.get(pickTime).isEmpty() && busTime.get(pickTime).size() == originM) {
            int timeHour = Integer.parseInt(busTime.get(pickTime).peek().split(":")[0]);
            int timeMinutes = Integer.parseInt(busTime.get(pickTime).peek().split(":")[1]);
            timeMinutes -= 1;
            timeHour = timeMinutes < 0 ? timeHour - 1 : timeHour;
            timeHour = timeHour >= 24 ? timeHour - 24 : timeHour;
            timeMinutes = timeMinutes < 0 ? 60 + timeMinutes : timeMinutes;
            answer = "";
            answer = timeHour < 10 ? answer.concat("0" + String.valueOf(timeHour)) : answer.concat(String.valueOf(timeHour));
            answer += ":";
            answer = timeMinutes < 10 ? answer.concat("0" + String.valueOf(timeMinutes)) : answer.concat(String.valueOf(timeMinutes));
        } else {
            answer = pickTime;
        }
        System.out.println("정답 : " + answer);
        return answer;
    }

//    public String solution(int n,int t, int m, String[] timetable) {
//        String answer = "";
//        String startTime = "09:00";
//        int originM = m;
//        HashMap<String, Integer> peopleTable = new HashMap<>();
//        PriorityQueue<String> queue = new PriorityQueue<>();
//
//        for(String table: timetable) {
////            if (!table.equals("23:59")) {
//                table = table.equals("23:59") ? "09:01" : table;
//                peopleTable.put(table, peopleTable.getOrDefault(table, 0) + 1);
//                queue.add(table);
////            }
//        }
//
//        while(n != 0) {
//            System.out.println(startTime);
//            int startHour = Integer.parseInt(startTime.split(":")[0]);
//            int startMinute = Integer.parseInt(startTime.split(":")[1]);
//            int waitHour = 0;
//            int waitMinute = 0;
//            m = originM;
//            while (m != 0) {
//                if (queue.isEmpty()) break;
//                String waitTime = queue.peek();
//                if (waitTime.equals("23:59")) {
//                    queue.poll();
//                    break;
//                } else {
//                    System.out.println("waitTime : " + waitTime);
//                    waitHour = Integer.parseInt(waitTime.split(":")[0]);
//                    waitMinute = Integer.parseInt(waitTime.split(":")[1]);
//                    if (startHour > waitHour || (startHour == waitHour && startMinute >= waitMinute)) {
//                        if (peopleTable.get(waitTime) > 0) {
//                            m--;
//                            System.out.println("m >> " + m);
//                            peopleTable.put(waitTime, peopleTable.get(waitTime) - 1);
//                            queue.poll();
//                        }
//                    } else break;
//                }
//            }
//
//            if (m > 0) {
//                if (queue.isEmpty()) {
//                    answer = startTime;
//                } else {
//                    startMinute = startMinute + t < 60 ? startMinute + t : 60 - startMinute;
//                    startHour = startMinute <= 0 ? startHour + 1 : startHour;
//                    startMinute = Math.abs(startMinute);
//                    startTime = "";
//                    startTime = startHour < 10 ? startTime.concat("0" + String.valueOf(startHour)) : startTime.concat(String.valueOf(startHour));
//                    startTime += ":";
//                    startTime = startMinute < 10 ? startTime.concat("0" + String.valueOf(startMinute)) : startTime.concat(String.valueOf(startMinute));
//                }
//            } else if (m == 0) {
//                if (queue.isEmpty()) {
//                    System.out.println("waitHour : " + waitHour);
//                    System.out.println("waitMinute : " + waitMinute);
//                    waitMinute -= 1;
//                    waitHour = waitMinute < 0 ? waitHour - 1 : waitHour;
//                    waitMinute = waitMinute < 0 ? 60+waitMinute : waitMinute;
//                    answer = "";
//                    answer = waitHour < 10 ? answer.concat("0"+String.valueOf(waitHour)) : answer.concat(String.valueOf(waitHour));
//                    answer += ":";
//                    answer = waitMinute < 10 ? answer.concat("0"+String.valueOf(waitMinute)) : answer.concat(String.valueOf(waitMinute));
//                }
//            }
//            n--;
//        }
//        System.out.println("정답 " + answer);
//        return answer;
//    }
}
