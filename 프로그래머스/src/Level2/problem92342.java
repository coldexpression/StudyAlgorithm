package Level2;

import java.util.*;

public class problem92342 {

    static boolean[] visited;
    static int maxDistance;
    static int[] ryanScoreBoard;
    static int[] winner;
    static int dst;
    static HashMap<Integer, List<int[]>> map;

    public static void main(String[] args) {
        problem92342 problem92342 = new problem92342();
//        problem92342.solution(5, new int[]{2,1,1,1,0,0,0,0,0,0,0});
//        problem92342.solution(1, new int[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        problem92342.solution(10, new int[]{0,0,0,0,0,0,0,0,3,4,3});
//        problem92342.solution(3, new int[]{0,0,1,0,0,0,0,0,0,1,0});
    }

    public int[] solution(int n,int[] info) {
        int[] answer = {};
        int[] ryan = new int[11];
        int sum = 0;
        for(int i=0;i<info.length;i++) {
            sum = info[i]  > 0 ? sum + (10-i) : sum;
        }
        dst = -1;
        map = new HashMap<>();
        dfs(info, ryan, 0, 0, 0, n);

        if (dst == -1) return new int[]{-1};

        List<int[]> list = map.get(dst);

        int index = 12;
        int data = Integer.MAX_VALUE;
        int count = 0;
        int res = 0;

//        for (int[] ints : list) {
//            for(int i=10;i>=0;i--) {
//                if (ints[i] != 0 && i < index && data > ints[i]) {
//                    index = i;
//                    data = ints[i];
//                    res = count;
//                    break;
//                }
//            }
//            count++;
//        }

//        System.out.println(list.size());

        answer = list.get(res);
        return answer;
    }

    public void pt(int[] a) {
        for(int i=0;i<a.length;i++) {
            System.out.print("["+a[i]+"] ");
        }
        System.out.println();
    }

    public void printf(int[] ryan, int[] apeach) {
        System.out.println("라이언");
        for(int i=0;i<ryan.length;i++) {
            System.out.print("["+ryan[i]+"] ");
        }
        System.out.println();

        System.out.println("어피치");
        for(int i=0;i<apeach.length;i++) {
            System.out.print("["+apeach[i]+"] ");
        }
        System.out.println();
    }

    public void dfs(int[] apeach, int[] ryan, int apeachScore, int ryanScore, int currentIndex, int useableArrowCount) {
        if (currentIndex > 10 && useableArrowCount == 0 && ryanScore > apeachScore && ryanScore - apeachScore >= dst) {
            dst = ryanScore - apeachScore;
            List<int[]> orDefault = map.getOrDefault(dst, new ArrayList<>());
            orDefault.add(ryan.clone());
            Collections.sort(orDefault, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    for(int i=10;i>=0;i--) {
                        if (o1[i] > o2[i]) return -1;
                        else if (o1[i] < o2[i]) return 1;
                    }
                    return 0;
                }
            });
            if (orDefault.size() > 1) {
                orDefault.remove(1);
            }
            System.out.println("===================");
            for (int[] ints : orDefault) {
                pt(ints);
            }

            System.out.println("===================");
            map.put(dst, orDefault);
                    System.out.println("현재 라이언 점수 : " + ryanScore);
        System.out.println("현재 어피치 점수 : " + apeachScore);
            printf(ryan, apeach);
            return;
        }

        if (currentIndex > 10) return;
//        System.out.println("===========================================");
//        System.out.println("현재 인덱스 : " + currentIndex);
//        System.out.println("현재 사용 가능 화살 : " + useableArrowCount);
//        System.out.println("현재 라이언 점수 : " + ryanScore);
//        System.out.println("현재 어피치 점수 : " + apeachScore);
//        printf(ryan, apeach);
//        System.out.println("===========================================");

        int arrowCount = apeach[currentIndex];
        if (useableArrowCount == 0) {
            if (arrowCount == 0 && ryan[currentIndex] == 0) {
                dfs(apeach, ryan, apeachScore, ryanScore, currentIndex + 1, 0);
            } else {
                dfs(apeach, ryan, apeachScore + (10 - currentIndex), ryanScore, currentIndex + 1, 0);
            }
        } else {
            for (int i = arrowCount + 1; i >= 0; i--) {
                if (useableArrowCount - i < 0) continue;
                int init = ryan[currentIndex];
                ryan[currentIndex] = i;
                if (i > arrowCount) {
                    dfs(apeach, ryan, apeachScore, ryanScore + (10 - currentIndex), currentIndex + 1, Math.max(useableArrowCount - i, 0));
                } else {
                    if (arrowCount == 0 && i == 0) {
                        dfs(apeach, ryan, apeachScore, ryanScore, currentIndex + 1, Math.max(useableArrowCount - i, 0));
                    } else {
                        dfs(apeach, ryan, apeachScore + (10 - currentIndex), ryanScore, currentIndex + 1, Math.max(useableArrowCount - i, 0));
                    }
                }
                ryan[currentIndex] = 0;
            }
        }
    }

//    public int[] solution(int n, int[] info) {
//        int[] answer = {};
//        int count = 10;
//        HashMap<Integer, Integer> apeachScoreBoard = new HashMap<>();
//        visited = new boolean[11];
//        maxDistance = 0;
//        ryanScoreBoard = new int[11];
//        winner = new int[11];
//        Arrays.fill(ryanScoreBoard,-1);
//        Arrays.fill(visited, false);
//        Arrays.fill(winner, -1);
//        for(int ele: info) {
//            apeachScoreBoard.put(count, ele);
//            count--;
//        }
//
//        dfs(0, 11, apeachScoreBoard, n, 0);
//
//        if (winner[0] == -1 || maxDistance <= 0) {
//            answer = new int[1];
//            answer[0] = -1;
//        } else answer = winner;
//
//        return answer;
//    }
//
//    private void dfs(int start, int end, HashMap<Integer, Integer> apeachScoreBoard, int pivotArrowCount, int arrowCount) {
//        if (arrowCount > pivotArrowCount) return;
//
//        if (start == end && pivotArrowCount == arrowCount) {
//
//            int count = 10;
//            int distance = -1;
//            int ryanScore = 0;
//            int apeachScore = 0;
//
//            for(int arrow: ryanScoreBoard) {
//                if (!(apeachScoreBoard.get(count) == 0 && arrow == 0)) {
//                    if (apeachScoreBoard.get(count) < arrow) ryanScore += count;
//                    else apeachScore += count;
//                }
//                count--;
//            }
//            distance = ryanScore-apeachScore;
//
//            if (distance <= 0) return;
//
//            if (maxDistance <= distance) {
//                if (distance == maxDistance) winner = thanBigger();
//                else winner = ryanScoreBoard.clone();
//                maxDistance = distance;
//            }
//        }
//
//        for(int i=start;i<=10;i++) {
//            if (!visited[i]) {
//                int[] scoreList = findScoreList(apeachScoreBoard.get(10-i));
//                visited[i] = true;
//                for(int j=scoreList.length-1;j>=0;j--) {
//                    ryanScoreBoard[i] = scoreList[j];
//                    dfs(start + 1, end, apeachScoreBoard, pivotArrowCount, arrowCount + scoreList[j]);
//                    ryanScoreBoard[i] = -1;
//                }
//                visited[i] = false;
//            }
//        }
//    }
//
//    private int[] findScoreList(int number) {
//        int[] answer;
//        if (number == 0) {
//            answer = new int[2];
//            answer[0] = 0;
//            answer[1] = 1;
//        } else {
//            answer = new int[number+2];
//            for(int i=0;i<answer.length;i++) answer[i] = i;
//        }
//        return answer;
//    }
//
//    private int[] thanBigger() {
//        int ryan1 = 0;
//        int ryan2 = 0;
//        int[] answer = new int[11];
//
//        for(int i=10;i>=0;i--) {
//            ryan1 = winner[i];
//            ryan2 = ryanScoreBoard[i];
//            if (ryan1 > ryan2) {
//                answer = winner.clone();
//                break;
//            }
//            else if (ryan1 < ryan2) {
//                answer = ryanScoreBoard.clone();
//                break;
//            }
//        }
//
//        return answer;
//    }
}
