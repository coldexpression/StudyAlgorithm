package Level3;

import java.util.*;

public class problem60061 {

    static HashSet<String> installablePillar;
    static HashSet<String> currentPillar;
    static HashSet<String> installablePaper;
    static HashSet<String> currentPaper;

    public static void main(String[] args) {
        problem60061 problem60061 = new problem60061();
        problem60061.solution(5, new int[][]{{1,0,0,1},{1,1,1,1},{2,1,0,1},{2,2,1,1},{5,0,0,1},{5,1,0,1},{4,2,1,1},{3,2,1,1}});
//        problem60061.solution(5, new int[][]{{0,0,0,1},{2,0,0,1},{4,0,0,1},{0,1,1,1},{1,1,1,1},{2,1,1,1},{3,1,1,1},{2,0,0,0},{1,1,1,0},{2,2,0,1}});
    }

    public int[][] solution(int n, int[][] build_frame) {
        int[][] answer = {};
        installablePillar = new HashSet<>();
        currentPillar = new HashSet<>();
        installablePaper = new HashSet<>();
        currentPaper = new HashSet<>();
        List<int[]> store = new ArrayList<>();
        int[][] board = new int[n+1][n+1];
        for(int i=0;i<n+1;i++) {
            installablePillar.add(0+","+i);
        }

        for(int i=0;i<build_frame.length;i++) {
            int col = build_frame[i][0];
            int row = build_frame[i][1];
            int type = build_frame[i][2];
            int delType = build_frame[i][3];
            if (delType == 1) {
                HashSet<String> prevPillar = new HashSet<>(currentPillar);
                HashSet<String> prevPaper = new HashSet<>(currentPaper);
                if (type == 0) {
                    currentPillar.add(row+","+col);
                    currentPillar = !validation(type, n) ? new HashSet<>(prevPillar) : currentPillar;
//                    installablePillar.remove(row+","+col);
                } else if (type == 1) {
                    currentPaper.add(row+","+col);
                    currentPaper = !validation(type, n) ? new HashSet<>(prevPaper) : currentPaper;
//                    installablePaper.remove(row+","+col);
                }
//                findInstallPillar(row, col, n, type);
//                findInstallPaper(row, col, n, type);
                System.out.println("설치 기둥 : " + currentPillar);
                System.out.println("설치 보 : " + currentPaper);
            } else {
                HashSet<String> prevPillar = new HashSet<>(currentPillar);
                HashSet<String> prevPaper = new HashSet<>(currentPaper);
                if (type == 0) {
                    System.out.println("제거 한 기둥 좌표 :" + row+","+col);
                    currentPillar.remove(row+","+col);
                    currentPillar = !validation(type, n) ? new HashSet<>(prevPillar) : currentPillar;
                } else {
                    System.out.println("제거 한 보 좌표 :" + row+","+col);
                    currentPaper.remove(row+","+col);
                    currentPaper = !validation(type, n) ? new HashSet<>(prevPaper) : currentPaper;
                }
            }
            System.out.println("설치 기둥 : " + currentPillar);
            System.out.println("설치 보 : " + currentPaper);
        }
        for (String s : currentPillar) {
            int[] position = new int[]{Integer.parseInt(s.split(",")[1]), Integer.parseInt(s.split(",")[0]), 0};
            store.add(position);
        }

        for (String s : currentPaper) {
            int[] position = new int[]{Integer.parseInt(s.split(",")[1]), Integer.parseInt(s.split(",")[0]), 1};
            store.add(position);
        }

        Collections.sort(store, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    if (o1[1] == o2[1]) return o1[2]-o2[2];
                    return o1[1]-o2[1];
                }
                return o1[0]-o2[0];
            }
        });
        answer = new int[store.size()][3];
        for(int i=0;i<store.size();i++) {
            answer[i] = store.get(i);
        }
        return answer;
    }

    private boolean validation(int type, int n) {
        boolean check = false;
        int row = 0;
        int col = 0;
        if (type == 0) {
            for(String position: currentPillar) {
                check = false;
                row = Integer.parseInt(position.split(",")[0]);
                col = Integer.parseInt(position.split(",")[1]);
                if (row == 0) check = true;
                else if (row > 0 && row < n) {
                    if (col > 0 && col < n && (currentPillar.contains((row-1)+","+col) || currentPaper.contains(row+","+(col-1)) || currentPaper.contains(row+","+col))) check = true;
                    else if (col == n && (currentPillar.contains((row-1)+","+col) || currentPaper.contains(row+","+(col-1)))) check = true;
                    else if (col == 0 && (currentPillar.contains((row-1)+","+col) || currentPaper.contains(row+","+col))) check = true;
                }
                if (!check) return false;
            }
        } else {
            for(String position: currentPaper) {
                check = false;
                row = Integer.parseInt(position.split(",")[0]);
                col = Integer.parseInt(position.split(",")[1]);
                if (row == 0) return false;
                if (col == 0) {
                    if (currentPillar.contains((row-1)+","+col) || currentPillar.contains((row-1)+","+(col+1)) || currentPaper.contains(row+","+(col+1))) check = true;
                } else if (col > 0 && col < n) {
                    if (currentPillar.contains((row-1)+","+col) || currentPillar.contains((row-1)+","+(col+1)) || (currentPaper.contains(row+","+(col-1)) && currentPaper.contains(row+","+(col+1)))) check = true;
                }
                if (!check) return false;
            }
        }
        return check;
    }

    private void findInstallPillar(int row, int col, int n, int type) {
        if (type == 0) {
            if (row == 0) {
                installablePillar.add((row + 1) + "," + col);
            } else if (row > 0 && row < n) {
                installablePillar.add((row - 1) + "," + col);
                installablePillar.add((row + 1) + "," + col);
            }
        } else if (type == 1) {
            if (row == 1) {
                if (col == n) {
                    installablePillar.add(row+","+col);
                } else {
                    installablePillar.add(row + "," + col);
                    installablePillar.add(row + "," + (col + 1));
                    installablePillar.add((row - 1) + "," + (col + 1));
                }
            } else if (row > 0 && row <= n) {
                installablePillar.add(row+","+col);
                installablePillar.add(row+","+(col+1));
            }
        }
    }

    private void findInstallPaper(int row, int col, int n, int type) {
        if (type == 0) {
            if (col == 0) installablePaper.add((row+1)+","+col);
            else if (col > 0 && col <= n) {
                installablePaper.add((row+1)+","+col);
                installablePaper.add((row+1)+","+(col-1));
            } else installablePaper.add((row+1)+","+(col-1));
        } else if (type == 1) {
            if (col-2 >= 0) {
                if (currentPaper.contains((row)+","+(col-2))) installablePaper.add(row+","+(col-1));
            } else if (col+2 < n) {
                if (currentPaper.contains((row)+","+(col+2))) installablePaper.add(row+","+(col+2));
            }
        }
    }
}
