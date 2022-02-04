package Level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class problem81302 {


    public static void main(String[] args) {
        problem81302 problem81302 = new problem81302();
        String[][] place = new String[5][5];
//        String[][] test = new String[][]{{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},{"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
//                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},{"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
        String[][] test = new String[][]{{"XPXPX", "PXPXP", "XPXPX", "PXPXP", "XPXPX"}, {"OOOXX", "OOOXX", "OOOXX", "OXXXO", "OOOXX"},{"OOOXX", "OOOXX", "OOOXX", "OOOXX", "OOOXX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},{"OOOXX", "OOOXX", "OOOXX", "OOOXX", "OOOXX"}};
        problem81302.solution(test);
    }

    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        char[][] room = new char[5][5];
        int col = 0;
        int row_pivot = 0;
        int col_pivot = 0;
        int distance = 0;
        int check = 1;

        /*
        * 각 강의실에 들어있는 값들을
        * String -> char[] 형태로 변환
        */
        for(int i=0;i<places.length;i++) {
            for (int j = 0; j < places[i].length; j++) {
                room[j] = places[i][j].toCharArray();
            }
            Map<Integer, List<Integer>> store = new HashMap<>();


            System.out.println("강의실 입장 !!");
            for (int x = 0; x < 5; x++) {
                for (int y = 0; y < 5; y++) {
                    System.out.print(room[x][y] + " | ");
                }
                System.out.println();
            }

            /*
             * 응시자가 앉아있는 위치 좌표값을 저장한다
             */
            for (int x = 0; x < 5; x++) {
                List<Integer> numStore = new ArrayList<>();
                for (int y = 0; y < 5; y++) {
                    if (room[x][y] == 'P') {
                        numStore.add(y);
                    }
                }
                store.put(x, numStore);
            }

            /*
             * 응시자중 한명을 기준으로 잡고,
             * 각 응시자간의 맨해튼 거리를 계산한다.
             */
            System.out.println("스토어 값 : " + store);
            for (Integer key : store.keySet()) {
                System.out.println("현재 키값 : " + key);
                check = 1;
                if (store.isEmpty()) break;
                row_pivot = key;
                for (Integer key2 : store.keySet()) {
                    if (store.get(key).isEmpty()) break;
                    int row = key2;
                    col_pivot = store.get(key).get(0);
                    for (int count = 0; count < store.get(key2).size(); count++) {
                        System.out.println("col 값 : " + store.get(key2).get(count));
                        if ((row_pivot != row || col_pivot != store.get(key2).get(count))) {
                            col = store.get(key2).get(count);
                            distance = Math.abs(col - col_pivot) + Math.abs(row - row_pivot);
                            System.out.println("[row_pivot, col_pivot] : [" + row_pivot + ", " + col_pivot + "]");
                            System.out.println("[row, col] : [" + row + ", " + col + "]");
                            System.out.println("distance : " + distance);
                            if (distance == 1) {
                                // 거리가 1인 경우에는 어떠한 경우라도 거리두기를 지키지 못함
                                check = 0;
                                break;
                            } else if (distance <= 2) {
                                // 거리가 2인 경우에는, 같은 행 또는 열 에있는지 파악 하거나 서로다른 행 또는 열에 있는지 파악
                                if (col == col_pivot) {
                                    int new_row = (row + row_pivot) / 2;
                                    if (room[new_row][col] == 'O') {
                                        // 같은 Col 사이에 'O' 가 존재하면 거리두기를 지키지 못함
                                        check = 0;
                                        break;
                                    }
                                } else if (row == row_pivot) {
                                    int new_col = (col + col_pivot) / 2;
                                    if (room[row][new_col] == 'O') {
                                        // 같은 Row 사이에 'O' 가 존재하면 거리두기를 지키지 못함
                                        check = 0;
                                        break;
                                    }
                                } else {
                                    if (room[row][col_pivot] == 'O' || room[row_pivot][col] == 'O') {
                                        // 다른 Row, Col 사이에 빈 테이블이 하나라도 있다면 거리두기를 지키지 못함
                                        check = 0;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    if (check == 0) break;
                }
                if (check == 0) break;
            }
            System.out.println("체크 값 " + check);
            answer[i] = check;
        }
        for (int i : answer) {
            System.out.println(i);
        }
        return answer;
    }
}
