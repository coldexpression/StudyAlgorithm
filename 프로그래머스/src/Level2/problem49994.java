package Level2;

import java.util.*;

public class problem49994 {

    public static void main(String[] args) {

    }

    public int solution(String dirs) {
        int answer = 0;
        int[] nextDistance = new int[2];
        int[] nextPosition = new int[2];
        int[] currentPosition = new int[2];
        String current = "";
        String next = "";
        HashMap<String, String> store = new HashMap<>();

        currentPosition[0] = 0;
        currentPosition[1] = 0;

        for(char key: dirs.toCharArray()) {
            current = String.valueOf(currentPosition[0]) + "" + String.valueOf(currentPosition[1]);
            nextDistance = pressKey(key);

            if ((currentPosition[0] + nextDistance[0] >= -5 && currentPosition[0] + nextDistance[0] <= 5)
                    && (currentPosition[1] + nextDistance[1] >= -5 && currentPosition[1] + nextDistance[1] <= 5)) {
                currentPosition[0] += nextDistance[0];
                currentPosition[1] += nextDistance[1];
                next = String.valueOf(currentPosition[0]) + "" + String.valueOf(currentPosition[1]);
                store.put(current+"/"+next, "");
                store.put(next+"/"+current, "");
            }


        }

        answer = store.size() / 2;
        return answer;
    }

    private int[] pressKey(char key) {
        int[] movePosition = new int[2];
        switch(key) {
            case 'U': {
                movePosition[0] = 0;
                movePosition[1] = 1;
                break;
            }
            case 'D': {
                movePosition[0] = 0;
                movePosition[1] = -1;
                break;
            }
            case 'L': {
                movePosition[0] = -1;
                movePosition[1] = 0;
                break;
            }
            case 'R': {
                movePosition[0] = 1;
                movePosition[1] = 0;
            }
            default: break;
        }
        return movePosition;
    }
}
