package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class problem25565 {
    public static int[] findStartCol(int[][] map, int r) {
        for(int i=0;i<map[0].length;i++) if (map[r][i] == 1) return new int[]{r, i};
        return new int[2];
    }
    public static int[] findStartRow(int[][] map, int c) {
        for(int i=0;i<map.length;i++) if (map[i][c] == 1) return new int[]{i, c};
        return new int[2];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int count = 0;
        int[][] map = new int[n][m];
        int[][] colSum = new int[n][m];
        int[][] rowSum = new int[n][m];
        for(int i=0;i<n;i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j=0;j<m;j++) map[i][j] = Integer.parseInt(st.nextToken());
            count += (int) Arrays.stream(map[i]).filter(x -> x == 1).count();
        }
        System.out.println(count);
        if (count < k || count > 2*k) {
            sb.append(0);
        } else {
            // 가로 합 구하기
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < m; col++) {
                    if (col == 0) colSum[row][col] = map[row][col];
                    else colSum[row][col] += colSum[row][col - 1] + map[row][col];
                }
            }

            // 세로 합 구하기
            for (int col = 0; col < m; col++) {
                for (int row = 0; row < n; row++) {
                    if (row == 0) rowSum[row][col] = map[row][col];
                    else rowSum[row][col] += rowSum[row - 1][col] + map[row][col];
                }
            }
            System.out.println("세로 합 배열");
            for (int i = 0; i < n; i++)
                System.out.println(Arrays.toString(rowSum[i]));
            System.out.println("가로 합 배열");
            for (int i = 0; i < n; i++)
                System.out.println(Arrays.toString(colSum[i]));

            PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
                if (o2[2] == o1[2]) return o1[3] - o2[3];
                return o2[2]-o1[2];
            });
            for(int i=0;i<n;i++) pq.add(new int[]{i, m-1, colSum[i][m-1], 0});
            for(int i=0;i<m;i++) pq.add(new int[]{n-1, i, rowSum[n-1][i], 1});

            // [row, col, 최대값, flag (0 == 가로, 1 == 세로)]

            while(!pq.isEmpty()) {
                int[] info = pq.poll();
                int[] nextInfo = pq.peek();
                int r = info[0]; int c = info[1]; int sum = info[2]; int flag = info[3];
                int nr = nextInfo[0]; int nc = nextInfo[1]; int nSum = nextInfo[2]; int nFlag = nextInfo[3];
                System.out.println("현재 정보 : " + Arrays.toString(info));
                System.out.println("다음 정보 : " + Arrays.toString(nextInfo));
                if (sum == k) {
                    // 한줄에 겹쳐 있거나, 엇갈린 경우

                    if (nSum == k) {
                        // 서로 엇갈리 경우
                        if (flag == nFlag) {
                            sb.append("0").append("\n");
                        } else {
                            if (flag == 0) {
                                int[] colSums = findStartCol(map , r);
                                if (colSums[1] <= nc && nc <= colSums[1] + k) sb.append(1).append("\n").append(colSums[0]+1).append(" ").append(nc+1).append("\n");
                                else sb.append(0);
                            } else {
                                int[] rowSums = findStartRow(map, c);
                                int[] colSums = findStartCol(map, nr);
                                if (rowSums[0] <= nr && nr <= rowSums[0] + k) sb.append(1).append("\n").append(nr+1).append(" ").append(rowSums[1]+1).append("\n");
                                else sb.append(0);
                            }
                        }
                    } else {
                        // 한줄에 겹쳐있는 경우
                        sb.append(k).append("\n");
                        if (flag == 0) {
                            int[] colSums = findStartCol(map, r);
                            for(int i=0;i<k;i++) sb.append(colSums[0]+1).append(" ").append(colSums[1]+i+1).append("\n");
                        }
                        else {
                            int[] rowSums = findStartRow(map, c);
                            for(int i=0;i<k;i++) sb.append(rowSums[0]+i+1).append(" ").append(rowSums[1]+1).append("\n");
                        }
                    }
                } else {
                    System.out.println("여기 ?");
                    // 무조건 한줄에 겹치는게 한개 이상인 경우 [모두 겹치진 않다]
                    if (sum == 2*k) {
                        // 한 줄에 모두 다 있는 경우
                        sb.append(0).append("\n");
                    } else {
                        if (flag == 0) {
                            int[] colSums = findStartCol(map , r);
                            int end = colSums[1] + sum - 1;
                            sb.append(colSums[1]+k-1 - (end-k+1)+1).append("\n");
                            for(int i=end-k+1;i<=colSums[1]+k-1;i++) sb.append(colSums[0]+1).append(" ").append(i+1).append("\n");
                        } else {
                            int[] rowSums = findStartRow(map , c);
                            int end = rowSums[0] + sum - 1;
                            sb.append(rowSums[0]+k-1-(end-k+1)+1).append("\n");
                            for(int i=end-k+1;i<=rowSums[0]+k-1;i++) sb.append(i+1).append(" ").append(rowSums[1]+1).append("\n");
                        }
                    }
                }
                break;
            }
        }
        System.out.println(sb);
    }
}
