package Codility.lesson4;

public class MaxCounters {

    public int[] solution(int N, int[] A) {
        // write your code in Java SE 8
        int[] map = new int[N];
        int maxVal = 0;
        int currentMaxVal = 0;
        for(int i=0;i<A.length;i++) {
            int key = A[i] - 1;
            if (key > N - 1) {
                currentMaxVal = maxVal;
            } else {
                if (map[key] <= currentMaxVal) {
                    map[key] = currentMaxVal;
                }
                map[key]++;
                maxVal = Math.max(map[key], maxVal);
            }
        }

        for(int i=0;i<N;i++) {
            if (map[i] < currentMaxVal) map[i] = currentMaxVal;
        }
        return map;
    }

}
