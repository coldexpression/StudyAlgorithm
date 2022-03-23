package Level3;

import java.util.*;

public class problem60059 {

    static int[] pivotSlot;
    static int[] pivotHome;

    public static void main(String[] args) {
        problem60059 problem60059 = new problem60059();
        problem60059.solution(new int[][]{{0,0,0},{1,0,0},{0,1,1}}, new int[][]{{1,1,1},{1,1,0},{1,0,1}});
//        problem60059.solution(new int[][]{{1,1},{0,1}}, new int[][]{{1,1,1},{1,1,0},{1,0,1}});
    }

    public boolean solution(int[][] key, int[][] lock) {
        HashSet<int[]> origin_slotBox = new HashSet<>();
        HashSet<String> slotBox = new HashSet<>();
        HashSet<int[]> homeBox = new HashSet<>();
        HashSet<String> transHomeBox = new HashSet<>();
        int[][] boxes = new int[][]{};
        int moveRow = 0;
        int moveCol = 0;
        int count = 0;
        int index = 0;
        boolean answer = false;
        pivotSlot = new int[2];
        pivotHome = new int[2];
        pivotSlot[0] = pivotHome[0] = 100;
        pivotSlot[1] = pivotHome[1] = 100;
        slotBox = findSlot(lock, slotBox);
        homeBox = findHome(key, homeBox);
        System.out.println("-회전 전-");
        printf(homeBox);
        while(!answer) {
            int transSize = 0;
            int transIndex = 0;
            if (index == 4) break;
            transHomeBox.clear();
//            slotBox.clear();
//            Iterator<String> it = origin_slotBox.iterator();
//            while(it.hasNext()) {
//                String word = it.next();
//                slotBox.add(word);
//            }

            count = 0;
            index++;
            homeBox = rotation(homeBox, key.length - 1);
            System.out.println("-회전 후-");
            printf(homeBox);

//            System.out.println("pivotSlot : [" + pivotSlot[0] + ", " + pivotSlot[1] + "]");
//            System.out.println("pivotHome : [" + pivotHome[0] + ", " + pivotHome[1] + "]");
//            moveRow = pivotSlot[0] - pivotHome[0];
//            moveCol = pivotSlot[1] - pivotHome[1];

            Iterator<int[]> iter = homeBox.iterator();
            transSize = homeBox.size();
            boxes = new int[transSize][2];
            while (iter.hasNext()) {
                int[] item = iter.next();
                boxes[transIndex][0] = item[0];
                boxes[transIndex][1] = item[1];
                transIndex++;
            }
            // 좌/우 방향성 조절 for 문
            for (int a = 0; a < 2; a++) {
                int[][] originalBoxes = arrayCopy(boxes);
                // 좌/우 이동 for 문
                for (int i = 0; i < lock.length; i++) {
                    int opA = a == 0 ? -1 : 1;
                    int[][] transBoxes = transPosition(0, i*opA, originalBoxes);
                    // 상/하 방향성 조절 for 문
                    for (int j = 0; j < 2; j++) {
                        int[][] middleBoxes = arrayCopy(transBoxes);
                        // 상/하 이동 for 문
                        for (int k = 0; k < lock.length; k++) {
                            int[][] subBoxes = arrayCopy(middleBoxes);
                            int[][] resultBoxes;
                            int opB = j == 0 ? -1 : 1;
                            resultBoxes = transPosition(k*opB, 0, subBoxes);
                            answer = executeLocker(resultBoxes, slotBox, lock.length - 1);
                            System.out.println("answer >> " + answer);
                            if (answer) return true;
                        }
                    }
                }
//            while (iter.hasNext()) {
//                int[] position = iter.next();
//                int transRow = position[0] + moveRow;
//                int transCol = position[1] + moveCol;
//                if (transRow >= 0 && transRow < lock.length && transCol >= 0 && transCol < lock.length) {
//                    System.out.println("transPosition : ["+transRow+","+transCol+"]");
//                    transHomeBox.add(transRow + "," + transCol);
//                }
//            }

//            System.out.println("변환 후 좌표 : " + transHomeBox);
//            Iterator<String> iterTr = transHomeBox.iterator();
//            while (iterTr.hasNext()) {
//                String word = iterTr.next();
//                if (slotBox.contains(word)) {
//                    slotBox.remove(word);
//                    count++;
//                }
////                count = slotBox.contains(word) ? count + 1 : count;
//            }
//            answer = slotBox.isEmpty() && transHomeBox.size() == count;
////            answer = count == slotBox.size();
            }
        }
        System.out.println(slotBox);
        System.out.println(origin_slotBox);
        System.out.println(answer);
        return answer;
    }

    private int[][] arrayCopy(int[][] original) {
        int[][] copy = new int[original.length][2];
        for(int i=0;i<original.length;i++) {
            for(int j=0;j<2;j++) {
                copy[i][j] = original[i][j];
            }
        }
        return copy;
    }

    private boolean executeLocker(int[][] boxes, HashSet<String> slotBox, int length) {
        HashSet<String> temp = new HashSet<>(slotBox);
        System.out.println("자물쇠 구멍 : " + temp);
        int count = 0;
        int boxSize = boxes.length;
        for(int i=0;i<boxes.length;i++) {
            int row = boxes[i][0];
            int col = boxes[i][1];
            String position = row + "," + col;
            if (row >= 0 && row <= length && col >= 0 && col <= length) {
                System.out.println("열쇠 홈 : [" + row + "," + col + "]");
                System.out.println("제거 전 : " + temp);
                System.out.println("count : " + count);
                if (temp.contains(position)) {
                    count++;
                    temp.remove(position);
                }
                System.out.println("제거 후 : " + temp);
                System.out.println("count : " + count);
            } else boxSize--;
        }
        return temp.isEmpty() && count == boxSize;
    }

    private int[][] transPosition(int row, int col, int[][] transBoxes) {
        int[][] temp = arrayCopy(transBoxes);
        for(int i=0;i<transBoxes.length;i++) {
            temp[i][0] += row;
            temp[i][1] += col;
        }
        return temp;
    }

    private void printf(HashSet<int[]> homeBox) {
        Iterator<int[]> iterator = homeBox.iterator();
        while(iterator.hasNext()) {
            int[] next = iterator.next();
            for (int i : next) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    private HashSet<int[]> rotation(HashSet<int[]> homeBox, int size) {
        Iterator<int[]> iter = homeBox.iterator();
        HashSet<int[]> resultHomeBox = new HashSet<>();
//        pivotHome[0] = pivotHome[1] = 100;
        while(iter.hasNext()) {
            int[] position = iter.next();
            int rtRow = 0;
            int rtCol = 0;
            rtRow = position[1];
            rtCol = Math.abs(position[0]-size);
//            if(pivotHome[0] >= rtRow) {
//                pivotHome[0] = rtRow;
//                pivotHome[1] = rtCol;
//            }
            resultHomeBox.add(new int[]{rtRow, rtCol});
        }
        return resultHomeBox;
    }

    private HashSet<int[]> findHome(int[][] key, HashSet<int[]> homeBox) {
        for(int i=0;i<key.length;i++) {
            for(int j=0;j<key[i].length;j++) {
                if (key[i][j] == 1) {
                    int[] position = new int[2];
                    System.out.println("찾은 홈 : [" + i + "," + j + "]" );
                    position[0] = i;
                    position[1] = j;
                    homeBox.add(position);
                }
            }
        }
        return homeBox;
    }

    private HashSet<String> findSlot(int[][] lock, HashSet<String> slotBox) {
        for(int i=0;i<lock.length;i++) {
            for(int j=0;j<lock[i].length;j++) {
                if (lock[i][j] == 0) {
                    int[] position = new int[2];
//                    if (pivotSlot[0] >= i) {
//                        pivotSlot[0] = i;
//                        pivotSlot[1] = j;
//                    }
                    position[0] = i;
                    position[1] = j;
                    slotBox.add(i+","+j);
                }
            }
        }

        return slotBox;
    }
}
