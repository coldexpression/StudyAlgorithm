package Level2;

import java.util.*;

public class problem68936 {
    static HashMap<Integer, Integer> store = new HashMap<>();

    public static void main(String[] args) {
        problem68936 problem68936 = new problem68936();
//        problem68936.solution(new int[][]{{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}});
        problem68936.solution(new int[][]{{1, 1, 1, 1, 1, 1, 1, 1},{0, 1, 1, 1, 1, 1, 1, 1},{0, 0, 0, 0, 1, 1, 1, 1},
                {0, 1, 0, 0, 1, 1, 1, 1},{0, 0, 0, 0, 0, 0, 1, 1},{0, 0, 0, 0, 0, 0, 0, 1},{0, 0, 0, 0, 1, 0, 0, 1},
                {0, 0, 0, 0, 1, 1, 1, 1}});
    }

    public int[] solution(int[][] arr) {
        int[] answer = {};
        int boxSize = (int)Math.pow(arr.length, 2);
        store.put(0, 0);
        store.put(1, 0);
        divide(arr, 0, 0, arr.length-1, arr.length-1, boxSize);
        System.out.println(store);
        answer = new int[]{store.get(0), store.get(1)};
        return answer;
    }

    private void divide(int[][] arr, int startRow, int startCol, int endRow, int endCol, int boxSize) {

        int colLength = endCol - startCol + 1;
        int rowLength = endRow - startRow + 1;

        if (boxSize == 1) {
            endRow = startRow;
            endCol = startCol;
        }

        int count = 0;
        for(int i=startRow;i<=endRow;i++) {
            for(int j=startCol;j<=endCol;j++) {
                count = arr[i][j] == 1 ? count+1 : count;
            }
        }

        System.out.println("start >> ["+startRow+","+startCol+"]");
        System.out.println("end >> ["+endRow+","+endCol+"]");
        System.out.println("boxSize >> " + boxSize);
        System.out.println("count >> " + count);



        if (count != 0 && count != boxSize) {
//            if (boxSize != 4) {
                // area 1
                divide(arr, startRow, startCol, startRow + ((rowLength) / 2 - 1), startCol + ((colLength) / 2 - 1), boxSize / 4);

                // area 2
                divide(arr, startRow, startCol + (colLength) / 2, startRow + (rowLength / 2 - 1), endCol, boxSize / 4);

                // area 3
                divide(arr, startRow + (rowLength) / 2, startCol, endRow, startCol + ((colLength) / 2 - 1), boxSize / 4);

                // area 4
                divide(arr, startRow + (rowLength) / 2, startCol + (colLength) / 2, endRow, endCol, boxSize / 4);
//            } else {
//                // area 1
//                divide(arr, startRow, startCol, startRow, startCol, boxSize / 4);
//
//                // area 2
//                divide(arr, startRow, startCol+1, startRow, startCol+1, boxSize / 4);
//
//                // area 3
//                divide(arr, startRow+1, startCol, startRow+1, startCol, boxSize / 4);
//
//                // area 4
//                divide(arr, startRow+1, startCol+1, startRow+1, startCol+1, boxSize / 4);
//            }
        } else {
            if (count == 0) store.put(0, store.get(0)+1);
            else store.put(1, store.get(1)+1);
        }
    }
}
