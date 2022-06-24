package Level3;

import java.util.Arrays;
import java.util.Comparator;

public class problem17676 {

    public static void main(String[] args) {
        problem17676 problem17676 = new problem17676();
//        problem17676.solution(new String[]{"2016-09-15 20:59:57.421 0.351s",
//                "2016-09-15 20:59:58.233 1.181s",
//                "2016-09-15 20:59:58.299 0.8s",
//                "2016-09-15 20:59:58.688 1.041s",
//                "2016-09-15 20:59:59.591 1.412s",
//                "2016-09-15 21:00:00.464 1.466s",
//                "2016-09-15 21:00:00.741 1.581s",
//                "2016-09-15 21:00:00.748 2.31s",
//                "2016-09-15 21:00:00.966 0.381s",
//                "2016-09-15 21:00:02.066 2.62s"});
//        problem17676.solution(new String[]{"2016-09-15 00:00:00.003 0.001s", "2016-09-15 23:59:59.999 0.001s"});
        problem17676.solution(new String[]{"2016-09-15 01:00:04.001 2.0s", "2016-09-15 01:00:07.000 2s"});
    }

    public int solution(String[] lines) {
        int answer = 0;
        double initStartTime = Double.MAX_VALUE;
        double initEndTime = Double.MIN_VALUE;
        int[][] input = new int[lines.length][2];

        for(int i=0;i<lines.length;i++) {
            String timeLine = lines[i];
            String timeStr = timeLine.split(" ")[1];
            String secondsStr = timeLine.split(" ")[2];
            double endTime = transTime(timeStr);
            double startTime = endTime - transSeconds(secondsStr) + 0.001;
            endTime = Math.round(endTime * 1000) / 1000.0;
            startTime = Math.round(startTime * 1000) / 1000.0;
            initStartTime = Math.min(initStartTime, startTime);
            initEndTime = Math.max(initEndTime, endTime);
            System.out.println("시작 시간 ==> " + (int)(startTime*1000));
            System.out.println("종료 시간 ==> " + (int)(endTime*1000));
            input[i][0] = (int)(startTime*1000);
            input[i][1] = (int)(endTime*1000);
        }

        Arrays.sort(input, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        for(int i=0;i<input.length;i++) {
            for (int j = 0; j < 2; j++) {
                int pivotStart = input[i][j];
                int pivotEnd = pivotStart + 999;
                int count = 0;
                for (int k = 0; k < input.length; k++) {
                    int nextStart = input[k][0];
                    int nextEnd = input[k][1];
                    if (nextStart < pivotEnd) {
                        if (nextEnd >= pivotStart) {
                            count++;
                        }
                    } else if (nextStart == pivotEnd) {
                        count++;
                    }
                }
                answer = Math.max(answer, count);
            }
        }
        System.out.println(answer);
        return answer;
    }

    public double transTime(String timeStr) {
        double time = 0;
        String[] board = timeStr.split(":");
        Double hour = Double.parseDouble(board[0]) * 3600.000;
        Double minute = Double.parseDouble(board[1]) * 60.000;
        Double second = Double.parseDouble(board[2].split("\\.")[0]) + (Double.parseDouble(board[2].split("\\.")[1]) / 1000);
        time = hour + minute + second;
        return time;
    }

    public double transSeconds(String secondsStr) {
        String seconds = secondsStr.substring(0, secondsStr.length()-1);
        double result = 0;
        if (seconds.contains("\\.")) {
            result = Double.parseDouble(seconds.split("\\.")[0]) + (Double.parseDouble(seconds.split("\\.")[1]) / 1000);
        } else {
            result = Double.parseDouble(seconds);
        }
        System.out.println("입력 초 : " + secondsStr);
        System.out.println("결과 : " + result);
        return result;
    }
}
