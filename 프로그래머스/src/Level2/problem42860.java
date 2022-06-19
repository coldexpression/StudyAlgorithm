package Level2;

import java.util.*;

public class problem42860 {

    public static void main(String[] args) {

    }

    public int solution(String name) {
        int answer = 0;
        boolean[] visited = new boolean[name.length()];
        int[] values = new int[name.length()];
        int currentIndex = 0;

        for(int i=0;i<name.length();i++) {
            char word = name.charAt(i);
            int up = 0;
            int down = 0;

            for(int j=0;j<=25;j++) {
                if ((char)('A'+j) == word) {
                    up = j;
                    break;
                }
            }

            for(int j=0;j<=25;j++) {
                if ((char)('Z' - j) == word) {
                    down = j + 1;
                    break;
                }
            }

            values[i] = Math.min(up, down);
            if (values[i] == 0) visited[i] = true;
        }

        answer += values[0];
        visited[0] = true;

        for (int value : values) {
            System.out.println(value);
        }

        while(true) {
            int rightMin = Integer.MAX_VALUE;
            int rightMinIndex = -1;
            int leftMin = Integer.MAX_VALUE;
            int leftMinIndex = -1;

            for(int i=1;;i++) {
                int nextIndex = currentIndex + i >= values.length ? (currentIndex + i) - values.length : currentIndex + i;
                if (nextIndex == currentIndex) break;
                if (!visited[nextIndex] && values[nextIndex] + i < rightMin) {
                    rightMin = values[nextIndex] + i;
                    rightMinIndex = nextIndex;
                }
            }

            for(int i=1;;i++) {
                int nextIndex = currentIndex - i < 0 ? (currentIndex - i) + values.length : currentIndex - i;
                if (nextIndex == currentIndex) break;
                if (!visited[nextIndex] && values[nextIndex] + i < leftMin) {
                    leftMin = values[nextIndex] + i;
                    leftMinIndex = nextIndex;
                }
            }

            System.out.println("현재 인덱스 : " + currentIndex);
            System.out.println("LEFT : " + leftMin);
            System.out.println("RIGHT : " + rightMin);
            if (rightMinIndex == -1 && leftMinIndex == -1) break;

            if (leftMin > rightMin) {
                currentIndex = leftMinIndex;
                answer += values[leftMinIndex];
                visited[leftMinIndex] = true;
            } else {
                currentIndex = rightMinIndex;
                answer += values[rightMinIndex];
                visited[rightMinIndex] = true;
            }
        }

        return answer;
    }
}
