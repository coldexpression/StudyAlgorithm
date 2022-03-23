package Level3;

import java.util.*;

public class problem60059 {

    static int[] pivotSlot;
    static int[] pivotHome;

    public static void main(String[] args) {
        problem60059 problem60059 = new problem60059();
        problem60059.solution(new int[][]{{0,0,0},{1,0,0},{0,1,1}}, new int[][]{{1,0,1},{0,1,1},{1,1,1}});
//        problem60059.solution(new int[][]{{1,1},{0,1}}, new int[][]{{1,1,1},{1,1,0},{1,0,1}});
    }

    public boolean solution(int[][] key, int[][] lock) {
        HashSet<String> origin_slotBox = new HashSet<>();
        HashSet<String> slotBox = new HashSet<>();
        HashSet<int[]> homeBox = new HashSet<>();
        HashSet<String> transHomeBox = new HashSet<>();
        int moveRow = 0;
        int moveCol = 0;
        int count = 0;
        int index = 0;
        boolean answer = false;
        pivotSlot = new int[2];
        pivotHome = new int[2];
        pivotSlot[0] = pivotHome[0] = 100;
        pivotSlot[1] = pivotHome[1] = 100;
        origin_slotBox = findSlot(lock, origin_slotBox);
        homeBox = findHome(key, homeBox);
        System.out.println("-회전 전-");
        printf(homeBox);
        while(!answer) {
            if (index == 4) break;
            transHomeBox.clear();
            slotBox.clear();
            Iterator<String> it = origin_slotBox.iterator();
            while(it.hasNext()) {
                String word = it.next();
                slotBox.add(word);
            }

            count = 0;
            index++;
            homeBox = rotation(homeBox, key.length - 1);
            System.out.println("-회전 후-");
            printf(homeBox);

            System.out.println("pivotSlot : [" + pivotSlot[0] + ", " + pivotSlot[1] + "]");
            System.out.println("pivotHome : [" + pivotHome[0] + ", " + pivotHome[1] + "]");
            moveRow = pivotSlot[0] - pivotHome[0];
            moveCol = pivotSlot[1] - pivotHome[1];

            Iterator<int[]> iter = homeBox.iterator();
            while (iter.hasNext()) {
                int[] position = iter.next();
                int transRow = position[0] + moveRow;
                int transCol = position[1] + moveCol;
                if (transRow >= 0 && transRow < lock.length && transCol >= 0 && transCol < lock.length) {
                    System.out.println("transPosition : ["+transRow+","+transCol+"]");
                    transHomeBox.add(transRow + "," + transCol);
                }
            }

            System.out.println("변환 후 좌표 : " + transHomeBox);
            Iterator<String> iterTr = transHomeBox.iterator();
            while (iterTr.hasNext()) {
                String word = iterTr.next();
                if (slotBox.contains(word)) {
                    slotBox.remove(word);
                    count++;
                }
//                count = slotBox.contains(word) ? count + 1 : count;
            }
            answer = slotBox.isEmpty() && transHomeBox.size() == count;
//            answer = count == slotBox.size();
        }
        System.out.println(slotBox);
        System.out.println(origin_slotBox);
        System.out.println(answer);
        return answer;
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
        pivotHome[0] = pivotHome[1] = 100;
        while(iter.hasNext()) {
            int[] position = iter.next();
            int rtRow = 0;
            int rtCol = 0;
            rtRow = position[1];
            rtCol = Math.abs(position[0]-size);
            if(pivotHome[0] >= rtRow) {
                pivotHome[0] = rtRow;
                pivotHome[1] = rtCol;
            }
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
                    if (pivotSlot[0] >= i) {
                        pivotSlot[0] = i;
                        pivotSlot[1] = j;
                    }
                    position[0] = i;
                    position[1] = j;
                    slotBox.add(i+","+j);
                }
            }
        }

        return slotBox;
    }
}
