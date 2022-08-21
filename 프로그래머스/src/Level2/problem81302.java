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
        String[][] test = new String[][]{{"PXXXX", "XPXXX", "XXXPP", "XXXXX", "XXXXX"}, {"OOOXX", "OOOXX", "OOOXX", "OXXXO", "OOOXX"},{"OOOXX", "OOOXX", "OOOXX", "OOOXX", "OOOXX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},{"OOOXX", "OOOXX", "OOOXX", "OOOXX", "OOOXX"}};
        problem81302.solution(test);
    }

    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        int index = 0;
        char[][] room = new char[5][5];

        for(int i=0;i<5;i++) answer[i] = 1;

        for (String[] place : places) {
            for(int i=0;i<place.length;i++) {
                for(int j=0;j<place[i].length();j++) {
                    room[i][j] = place[i].charAt(j);
                }
            }

            for(int i=0;i<5;i++) {
                for(int j=0;j<5;j++) {
                    char pivot = room[i][j];
                    char right = 0;
                    char bottom = 0;
                    char rightCross = 0;
                    char rightPlus = 0;
                    char bottomPlus = 0;
                    char leftCross = 0;
                    char left = 0;


                    if (i + 1 < 5) bottom = room[i+1][j];
                    if (j + 1 < 5) {
                        right = room[i][j+1];
                        if (i + 1 < 5) rightCross = room[i+1][j+1];
                    }
                    if (i + 2 < 5) bottomPlus = room[i+2][j];
                    if (j + 2 < 5) rightPlus = room[i][j+2];
                    if (j >= 1) {
                        left = room[i][j-1];
                        if (i + 1 < 5) leftCross = room[i+1][j-1];
                    }

                    if (pivot == 'P') {
                        if ((right == 'O' || bottom == 'O') && rightCross == 'P') {
                            answer[index] = 0;
                            break;
                        }

                        if((left == 'O' || bottom == 'O') && leftCross == 'P') {
                            answer[index] = 0;
                            break;
                        }

                        if (right == 'P' || bottom == 'P') {
                            answer[index] = 0;
                            break;
                        }

                        if ((right == 'O' && rightPlus == 'P') || (bottom == 'O' && bottomPlus == 'P')) {
                            answer[index] = 0;
                            break;
                        }

                    }
                }
                if (answer[index] == 0) {
                    break;
                }
            }
            System.out.println("answer["+index+"] : " + answer[index]);
            index++;
        }
        return answer;
    }
}
