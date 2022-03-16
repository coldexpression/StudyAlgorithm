package Level2;
import java.util.*;
import java.util.stream.Collectors;

public class problem12978 {


//    static HashMap<Integer, HashMap<Integer, PriorityQueue<Integer>>> loadInfo = new HashMap<>();
//    static Stack<Integer> passList = new Stack<>();
//    static int sum;
//    static boolean check;

    public static void main(String[] args) {
        problem12978 problem12978 = new problem12978();
//        problem12978.solution(5, new int[][]{{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}}, 3);
//        problem12978.solution(6, new int[][]{{1,2,1},{1,3,2},{2,3,2},{3,4,3},{3,5,2},{3,5,3},{5,6,1}}, 4);
//        problem12978.solution(5, new int[][]{{1,2,4},{1,3,1},{3,4,1},{4,2,1},{2,5,1}},4);
        problem12978.solution(6, new int[][]{{1,2,2},{1,3,1},{3,1,2},{3,4,3},{3,5,1},{6,5,2},{4,6,2},{2,4,1}}, 3);
    }

    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int[][] board = new int[N][N];
        board = init(board, N);
        board = loadData(board, road);
        answer = searchLoad(board, N, K);
        System.out.println(answer);
        return answer;
    }

    private void printBoard(int[][] board, int n) {
        System.out.println("출력 시작");
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("출력 종료");
    }

    private int searchLoad(int[][] board, int n, int k) {
        int answer = 1;
        int currentScore = 0;
        int[] values = new int[n];
        int[] visited = new int[n];
        boolean check = false;

        Queue<Integer> nextList = new LinkedList<>();
        Queue<Integer> passList = new LinkedList<>();
        Queue<Integer> scoreList = new LinkedList<>();
        Arrays.fill(values, 500001);
        Arrays.fill(visited, 0);
        // 1번 마을과 근접한 마을 저장
//        for(int i=0;i<n;i++) {
//            if (board[0][i] != 500001 && currentScore + board[0][i] <= k) {
//                nextList.add(i);
//                scoreList.add(board[0][i]);
//            }
//        }

        for(int i=0;i<n;i++) {
            values[i] = board[0][i] == 500001 ? 500001 : board[0][i];
        }

//        passList.add(0);
        values[0] = 0;
        visited[0] = 1;

        while(true) {
            for(int i=0;i<n;i++) {
                System.out.print(values[i] + " ");
            }
            System.out.println();
            int pick = 500001;
            int pickIndex = -1;
            for(int i=0;i<n;i++) {
                if (visited[i] != 1 && values[i] < pick) {
                    pick = values[i];
                    pickIndex = i;
                }
            }

            if (pick == 500001 || pickIndex == -1) break;

            visited[pickIndex] = 1;

            System.out.println("pick >> " + pick);
            System.out.println("pickIndex >> " + pickIndex);

            for(int i=0;i<n;i++) {
                if (visited[i] != 1 && board[i][pickIndex] != 500001) {
                    System.out.println("들어온 i :" + i);
                    values[i] = values[pickIndex] + board[i][pickIndex];

                }
            }


        }

        System.out.println("종료");
        for (int value : values) {
            System.out.print(value+ " ");
        }

        System.out.println();

        return (int) Arrays.stream(values).filter(i -> i <= k).count();

        // 대기열에 있는 마을들을 순차적으로 방문
//        while(true) {
//            if (nextList.isEmpty()) break;
//            int pick = nextList.poll();
//            answer++;
//            currentScore = scoreList.poll();
//
//            System.out.println("passList >> " + passList);
//            System.out.println("nextList >> " + nextList);
//            System.out.println("뽑은 마을 : " + pick);
//            for (int i = 0; i < n; i++) {
//                int scoreNum = board[pick][i];
//                if (board[pick][i] != -1 && currentScore + scoreNum <= k) {
//                    System.out.println(board[pick][i]);
//                    System.out.println("현재 마을 : " + i);
//                    System.out.println("현재 점수 : " + currentScore);
//                    nextList.add(i);
//                    scoreList.add(currentScore + scoreNum);
//                }
//            }
//            passList.add(pick);
//        }
//
//
//        System.out.println(passList);
//
//
//        return 0;
    }

    private int[][] loadData(int[][] board, int[][] road) {
        int p1;
        int p2;
        int distance;
        for(int i=0;i< road.length;i++) {
            p1 = road[i][0] - 1;
            p2 = road[i][1] - 1;
            distance = road[i][2];
            if (board[p1][p2] != 500001) {
                board[p1][p2] = Math.min(board[p1][p2], distance);
                board[p2][p1] = Math.min(board[p2][p1], distance);
            } else {
                board[p1][p2] = distance;
                board[p2][p1] = distance;
            }
        }
        return board;
    }

    private int[][] init(int[][] board, int n) {
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                board[i][j] = 500001;
            return board;
    }

//    public int solution(int N, int[][] road, int K) {
//        Stack<Integer> waitingList = new Stack<>();
//        HashMap<Integer, Integer> answerStore = new HashMap<>();
//        int answer = 0;
//        int villiageNumber = 1;
//        sum = 0;
//        check = false;
//        while(villiageNumber != N+1) {
//            HashMap<Integer, PriorityQueue<Integer>> distanceInfo = new HashMap<>();
//            for(int i=0;i<road.length;i++) {
//                PriorityQueue<Integer> dst = new PriorityQueue<>();
//                if (road[i][0] == villiageNumber && road[i][0] < K) {
//                    if (distanceInfo.containsKey(road[i][1])) {
//                        dst = distanceInfo.get(road[i][1]);
//                        dst.add(road[i][2]);
//                        distanceInfo.put(road[i][1], dst);
//                    } else {
//                        dst.add(road[i][2]);
//                        distanceInfo.put(road[i][1], dst);
//                    }
//                }
//                else if (road[i][1] == villiageNumber && road[i][0] < K) {
//                    if (distanceInfo.containsKey(road[i][0])) {
//                        dst = distanceInfo.get(road[i][0]);
//                        dst.add(road[i][2]);
//                        distanceInfo.put(road[i][0], dst);
//                    } else {
//                        dst.add(road[i][2]);
//                        distanceInfo.put(road[i][0], dst);
//                    }
//                }
//            }
//            loadInfo.put(villiageNumber, distanceInfo);
//            villiageNumber++;
//        }
//
//        for(int villiageNum: loadInfo.get(1).keySet()) {
//            passList.push(1);
//            waitingList.push(villiageNum);
//            loadSearch(waitingList, K, 1, 1);
//            for (int ele : passList) {
//                answerStore.put(ele, 0);
//            }
//            passList.clear();
//        }
//
//        answer = answerStore.size();
//
//        return answer;
//    }
//
//    static void loadSearch(Stack<Integer> waitingList, int time, int currentVilliage, int prevVilliage) {
//        System.out.println("현재 거주중인 마을 : " + currentVilliage );
//        System.out.println("passList >> " + passList);
//        System.out.println("waitingList >> " + waitingList);
//        System.out.println("loadInfo >> " + loadInfo);
//        while(!waitingList.isEmpty()) {
//
//            int pickVilliage = waitingList.peek();
//            if (pickVilliage == currentVilliage) {
//                return;
//            }
//            for(int dstNum: loadInfo.get(currentVilliage).get(pickVilliage)) {
//                System.out.println("선택한 마을 : " + pickVilliage);
//                System.out.println("현재 마을 : " + currentVilliage);
//                System.out.println("안에서 waitList >> " + waitingList);
//                System.out.println("dstNum : " + dstNum);
//                if (sum + dstNum <= time) {
//                    sum += dstNum;
//                    passList.add(waitingList.peek());
////                    System.out.println(loadInfo.get(currentVilliage).get(pickVilliage));
////                    System.out.println("sum : " + sum);
//                    for (int villNum : loadInfo.get(pickVilliage).keySet()) {
//                        if (currentVilliage != villNum) {
//                            waitingList.push(villNum);
//                        }
//                    }
//                    loadSearch(waitingList, time, pickVilliage, currentVilliage);
//                    System.out.println("끝난 시점 현재 마을 : " + currentVilliage);
//                    System.out.println("끝난 시점 골랐던 마을 : " + pickVilliage);
////                waitingList.pop();
//                    sum -= dstNum;
//                } else {
//                    break;
//                }
//            }
//            if (!waitingList.isEmpty()) waitingList.pop();
//            System.out.println("[현재 마을: " + currentVilliage + "] >> " + waitingList);
//        }
//
//    }

}
