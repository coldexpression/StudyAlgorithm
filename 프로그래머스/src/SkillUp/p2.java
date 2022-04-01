package SkillUp;

import java.util.*;

public class p2 {

    public static void main(String[] args) {
        p2 p2 = new p2();
        p2.solution(new int[][]{{2,-1,4},{-2,-1,4},{0,-1,1},{5,-8,-12},{5,8,12}});
//        p2.solution(new int[][]{{0,1,-1},{1,0,-1},{1,0,1},{1,0,2}});
//        p2.solution(new int[][]{{1,0,-1},{0,1,-1},{0,1,3},{0,1,-2}});
//        p2.solution(new int[][]{{1,-1,0},{2,-1,0},{4,-1,0}});
    }

    public String[] solution(int[][] line) {
        String[] answer = {};
        List<long[]> spotList = new ArrayList<>();
        long rowMax = Long.MIN_VALUE;
        long rowMin = Long.MAX_VALUE;
        long colMax = Long.MIN_VALUE;
        long colMin = Long.MAX_VALUE;
        boolean check = false;
        long row , col = 0;
        for(int i=0;i<line.length;i++) {
            for(int j=i+1;j<line.length;j++) {
                long[] position = findSpot(line[i], line[j]);
                if(position[0] != Long.MAX_VALUE && position[1] != Long.MAX_VALUE) {
                    spotList.add(position);
                }
            }
        }

        for (long[] ints : spotList) {
            System.out.println("["+ints[0]+","+ints[1]+"]");
            if (ints[0] != 0 && ints[1] != 0) {
                check = true;
                break;
            }
        }

        if(!check) return new String[]{"*"};

        Collections.sort(spotList, new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2) {
                if (o1[1] == o2[1]) return (int) (o1[0]-o2[0]);
                return (int) (o2[1]-o1[1]);
            }
        });
        System.out.println("정렬 후");
        for (long[] ints : spotList) {
            System.out.println("["+ints[0]+","+ints[1]+"]");
            rowMax = Math.max(rowMax, ints[1]);
            rowMin = Math.min(rowMin, ints[1]);
            colMax = Math.max(colMax, ints[0]);
            colMin = Math.min(colMin, ints[0]);
        }
        System.out.println("Max => ["+colMax+", "+rowMax+"]");
        System.out.println("Min => ["+colMin+", "+rowMin+"]");

        if (rowMax == rowMin) row = rowMax;
        else row = Math.abs(rowMax - rowMin) + 1;

        if (colMax == colMin) col = colMax;
        else col = Math.abs(colMax- colMin) + 1;

        answer = new String[(int)row];
        Arrays.fill(answer, "");
        for(int i=0;i<row;i++) {
            for(int j=0;j<col;j++) {
                answer[i] += ".";
            }
        }
        for (long[] position : spotList) {
            long pCol = position[0] == colMin && position[0] == colMax ? 0 : position[0] + Math.abs(colMin);
            long pRow = position[1] == rowMax && position[1] == rowMin ? 0 : rowMax - position[1];
            System.out.println("현재 row : " + pRow);
            System.out.println("현재 col : " + pCol);
            System.out.println("col >> " + col);
            StringBuilder sb = new StringBuilder(answer[(int)pRow]);
            sb.setCharAt((int)pCol, '*');
            answer[(int)pRow] = sb.toString();
        }

        for (String s : answer) {
            System.out.println(s);
        }
        return answer;
    }

    private long[] findSpot (int[] exp1, int[] exp2) {
        double[] middle = new double[2];
        long[] result = new long[2];
        long a = exp1[0];
        long b = exp1[1];
        long e = exp1[2];
        long c = exp2[0];
        long d = exp2[1];
        long f = exp2[2];
        middle[0] = ((double)(b*f) - (e*d)) / ((a*d) - (b*c));
        middle[1] = ((double)(e*c) - (a*f)) / ((a*d) - (b*c));
        if ((middle[0]-(long)middle[0]) == 0.0 && ((middle[1]-(long)(middle[1]) == 0.0))) {
            result[0] = (long)middle[0];
            result[1] = (long)middle[1];
        } else {
            result[0] = result[1] = Long.MAX_VALUE;
        }
        return result;
    }
}
