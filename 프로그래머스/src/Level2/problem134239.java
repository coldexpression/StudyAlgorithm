package Level2;

import java.util.ArrayList;
import java.util.List;

public class problem134239 {
    public static void main(String[] args) {

    }

    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        List<Double> list = new ArrayList<>();

        int height = 1;
        int prevK = 0;
        int up = 0;
        int down = 0;

        list.add(0.0);

        while(true) {

            prevK = k;
            if (k % 2 == 0) {
                k = k / 2;
            } else {
                k = (k * 3) + 1;
            }

            up = k;
            down = prevK;

            list.add(list.get(list.size()-1) + ((up+down))*height/2.0);

            if (k == 1) break;
        }

        for(int i=0;i<ranges.length;i++) {
            int start = ranges[i][0];
            int end = list.size()-1 + ranges[i][1];


            answer[i] = ((start >= list.size() && end <= 0) || (start - end > 0)) ? -1.0 : list.get(end) - list.get(start);
        }

        return answer;
    }
}
