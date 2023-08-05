package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem4014 {

    static int n;
    static int x;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());

        for(int t=1;t<=T;t++) {
            st = new StringTokenizer(bf.readLine());
            n = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            map = new int[n][n];
            int ans = 0;

            for(int i=0;i<n;i++) {
                st = new StringTokenizer(bf.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 가로 줄 먼저 보기
            for(int r=0;r<n;r++) {
                System.out.println("r 현재 번호 : [" + r + "]");
                int currentNum = map[r][0];
                int cnt = 1;
                boolean check = true;
                boolean downCheck = false;
                for(int c=1;c<n;c++) {
                    if (map[r][c] == currentNum) {
                        cnt++;
                        if (downCheck) {
                            if (cnt == x) {
                                cnt = 0;
                                downCheck = false;
                            }
                        }
                    }
                    else if (map[r][c] == currentNum + 1) {
                        System.out.println("여기서 c ount : " + cnt);
                        if (downCheck) {
                            downCheck = false;
                            if (cnt < x) {
                                check = false;
                                break;
                            }
                        }

                        if (cnt >= x) {
                            cnt = 1;
                            currentNum = map[r][c];
                        } else {
                            check = false;
                            break;
                        }
                    } else if (map[r][c] == currentNum - 1){
                        if (downCheck) {
                            if (cnt < x) {
                                check = false;
                                break;
                            }
                            cnt = 1;
                            currentNum = map[r][c];
                        } else {
                            downCheck = true;
                            cnt = 1;
                            currentNum = map[r][c];
                        }
                    } else {
                        check = false;
                        break;
                    }
                }

                if (downCheck) {
                    if (cnt >= x) ans = check ? ans + 1 : ans;
                } else {
                    ans = check ? ans + 1 : ans;
                }
                System.out.println("정답 ! : [" + ans + "]");
            }

            // 세로 줄 보기
            for(int c=0;c<n;c++) {
                System.out.println("r 현재 번호 : [" + c + "]");
                int currentNum = map[0][c];
                int cnt = 1;
                boolean check = true;
                boolean downCheck = false;
                for(int r=1;r<n;r++) {
                    if (map[r][c] == currentNum) {
                        cnt++;
                        if (downCheck) {
                            if (cnt == x) {
                                cnt = 1;
                                downCheck = false;
                            }
                        }
                    }
                    else if (map[r][c] == currentNum + 1) {
                        if (downCheck) {
                            downCheck = false;
                            if (cnt < x) {
                                check = false;
                                break;
                            }
                        }

                        if (cnt >= x) {
                            cnt = 1;
                            currentNum = map[r][c];
                        } else {
                            check = false;
                            break;
                        }
                    } else if (map[r][c] == currentNum - 1){
                        if (downCheck) {
                            if (cnt < x) {
                                check = false;
                                break;
                            }
                            cnt = 1;
                            currentNum = map[r][c];
                        } else {
                            downCheck = true;
                            cnt = 1;
                            currentNum = map[r][c];
                        }
                    } else {
                        check = false;
                        break;
                    }
                }

                if (downCheck) {
                    if (cnt >= x) ans = check ? ans + 1 : ans;
                } else {
                    ans = check ? ans + 1 : ans;
                }
                System.out.println("정답 ! : [" + ans + "]");
            }
            sb.append("#").append(t).append(" ").append(ans).append("\n");
        }
        System.out.println(sb);
    }
}
