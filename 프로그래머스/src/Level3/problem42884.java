package Level3;

import java.util.*;

public class problem42884 {

    public static void main(String[] args) {
        problem42884 problem42884 = new problem42884();
//        problem42884.solution(new int[][]{{-20,-15},{-14,-5},{-18,-13},{-5,-3}});
        problem42884.solution(new int[][]{{0,2},{1,2},{3,4},{0,5},{0,3},{1,6},{9,11},{7,9}});
    }

    public int solution(int[][] routes) {
        int answer = 0;
        int maxNum = 0;
        int start = 0;
        boolean[] visited = new boolean[routes.length];
        for(int i=0;i<routes.length;i++) visited[i] = false;
        Arrays.sort(routes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) return o1[0] - o2[0];
                return o1[1] - o2[1];
            }
        });
        maxNum = routes[0][0] < 0 ? routes[0][0] * (-1) : 0;
        for (int i = 0; i < routes.length; i++) {
            routes[i][0] += maxNum;
            routes[i][1] += maxNum;
        }
        printf(routes);

        for (int i = start; i < routes.length; i++) {
            int index = Integer.MAX_VALUE;
            visited[i] = true;
            System.out.println("현재 i : " + i);
            for (int j = i + 1; j < routes.length; j++) {
                int pickNum = routes[i][1];
                if (!visited[j] && routes[j][0] <= pickNum && routes[j][1] >= pickNum) {
                    visited[j] = true;
                }
                else if (!visited[j] && routes[j][0] > pickNum && index > j) index = j;
            }
            i = index - 1;
            answer++;
        }
        System.out.println(answer);
        return answer;
    }

    private void printf(int[][] routes) {
        for(int i=0;i<routes.length;i++) {
            for(int j=0;j<routes[i].length;j++) {
                System.out.print("["+routes[i][j]+"]");
            }
            System.out.println();
        }
    }
}

/*
* cout << solution({ {-20, 15}, {-14, -5}, {-18, -13}, {-5, -3} }); //2
cout << endl;
cout << solution({ {-2, -1}, {1, 2}, {-3, 0} });//2
cout << endl;
cout << solution({ {0, 0}, });//1
cout << endl;
cout << solution({ {0, 1}, {0, 1}, {1, 2} });//1
cout << endl;
cout << solution({ {0, 1}, {2, 3}, {4, 5}, {6, 7} });//4
cout << endl;
cout << solution({ {-20, -15}, {-14, -5}, {-18, -13}, {-5, -3} });//2
cout << endl;
cout << solution({ {-20, 15}, {-20, -15}, {-14, -5}, {-18, -13}, {-5, -3} });//2
cout << endl;
cout << solution({ {2,2},{0,1},{-10,9} });//2
cout << endl;
cout << solution({ {-7, 0}, {-6, -4}, {-5, -3}, {-3, -1}, {-1, 4}, {1, 2}, {3, 4} });//4
cout << endl;
cout << solution({ {-5, -3}, {-4, 0}, {-4, -2}, {-1, 2}, {0, 3}, {1, 5}, {2, 4} });//2
cout << endl;
cout << solution({ {0, 1}, {1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}, {7, 8}, {8, 9}, {9, 10}, {10, 11}, {11, 12}, {12, 13}, {13, 14}, {14, 15} });//8
cout << endl;
cout << solution({ {0, 12}, {1, 12}, {2, 12}, {3, 12}, {5, 6}, {6, 12}, {10, 12} });//2
cout << endl;
cout << solution({ {-191, -107}, { -184,-151 }, { -150,-102 }, { -171,-124 }, { -120,-114 } }); // 2
cout << endl;
* */
