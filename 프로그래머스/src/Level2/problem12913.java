package Level2;

import java.util.*;

public class problem12913 {


    public static void main(String[] args) {
        problem12913 problem12913 = new problem12913();
//        problem12913.solution(new int[][]{{1,2,3,5},{5,6,7,8},{4,3,2,1}});
        problem12913.solution(new int[][] {{1,1,1,1}, {2,2,2,3}, {3,3,3,6}, {4,4,4,7}});
    }

    public int solution(int[][] land) {
        int answer = -1;

        for(int i=1;i<land.length;i++) {
            land[i][0] += Math.max(Math.max(land[i-1][1], land[i-1][2]), land[i-1][3]);
            land[i][1] += Math.max(Math.max(land[i-1][0], land[i-1][2]), land[i-1][3]);
            land[i][2] += Math.max(Math.max(land[i-1][0], land[i-1][1]), land[i-1][3]);
            land[i][3] += Math.max(Math.max(land[i-1][0], land[i-1][1]), land[i-1][2]);
        }
        int[] store = new int[4];
        for(int i=0;i<4;i++) store[i] = land[land.length-1][i];
        Arrays.sort(store);

        answer = store[store.length-1];
        return answer;
    }


//    public int solution(int[][] land) {
//        int answer = -1;
//        int[] store = new int[2];
//        int currentExclusiveIndex = -1;
//        List<Integer> indexBox = new ArrayList<>();
//
//        if (land.length == 1) {
//            for(int ele: land[0]) answer = Math.max(answer, ele);
//            return answer;
//        }
//
//        store = firstFind(land, 0);
//        answer = store[0];
//        currentExclusiveIndex = store[1];
//        for(int i=1;i<land.length-1;i++) {
//            answer += land[i][currentExclusiveIndex];
//            currentExclusiveIndex = etcFind(land, i, currentExclusiveIndex);
//        }
//
//        answer += land[land.length-1][currentExclusiveIndex];
//
//        System.out.println(answer);
//
//        return answer;
//    }

//    private int etcFind(int[][] land, int startRow, int currentExclusiveIndex) {
//        int max = -1;
//        int nextExclusiveIndex = 0;
//        for(int i=0;i<4;i++) {
//            if (i != currentExclusiveIndex) {
//                if (max < land[startRow][currentExclusiveIndex] + land[startRow+1][i]) {
//                    max = land[startRow][currentExclusiveIndex] + land[startRow+1][i];
//                    nextExclusiveIndex = i;
//                }
//            }
//        }
//        return nextExclusiveIndex;
//    }
//
//    private int[] firstFind(int[][] land, int startRow) {
//        int[] answer = new int[2];
//        int currentExclusiveIndex = -1;
//        int nextExclusiveIndex = -1;
//        int max = -1;
//        for(int i=0;i<4;i++) {
//            for(int j=0;j<4;j++) {
//                if (i != j) {
//                    if (max < land[startRow][i] + land[startRow+1][j]) {
//                        max = land[startRow][i] + land[startRow+1][j];
//                        currentExclusiveIndex = i;
//                        nextExclusiveIndex = j;
//                    }
//                }
//            }
//        }
//        answer[0] = land[startRow][currentExclusiveIndex];
//        answer[1] = nextExclusiveIndex;
//        return answer;
//    }

}
