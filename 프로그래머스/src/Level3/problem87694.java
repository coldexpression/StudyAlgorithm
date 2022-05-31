package Level3;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class problem87694 {

    static int[] moveX = new int[]{-1,1,0,0};
    static int[] moveY = new int[]{0,0,-1,1};

    public static void main(String[] args) {
        problem87694 problem87694 = new problem87694();
        problem87694.solution(new int[][]{{1,1,7,4},{3,2,5,5},{4,3,6,9},{2,6,8,8}}, 1, 3, 7, 8);
//        problem87694.solution(new int[][]{{2,2,5,5},{1,3,6,4},{3,1,4,6}}, 1, 4, 6, 3);
    }

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        Queue<int[]> queue = new LinkedList<>();
        int answer = 0;
        int maxX = 0;
        int maxY = 0;
        int[][] map;
        HashSet<String> set = new HashSet<>();

        for (int[] pos : rectangle) {
            maxX = Math.max(Math.max(pos[0], maxX), pos[2]);
            maxY = Math.max(Math.max(pos[1], maxY), pos[3]);
        }

        maxX *= 2;
        maxY *= 2;

        map = new int[maxY+1][maxX+1];
        boolean[][] visited = new boolean[maxY+1][maxX+1];
        boolean[][] available = new boolean[maxY+1][maxX+1];

        for (int[] pos : rectangle) {
            int startX = pos[0]*2;
            int startY = pos[1]*2;
            int endX = pos[2]*2;
            int endY = pos[3]*2;

            for(int i=startY+1;i<=endY-1;i++) {
                for(int j=startX+1;j<=endX-1;j++) {
                    map[i][j] = -1;
                }
            }

            for(int i=startX;i<=endX;i++) {
                map[startY][i] = map[startY][i] == -1 ? 0 : 1;
                map[endY][i] = map[endY][i] == -1 ? 0 : 1;
            }

            for(int i=startY;i<=endY;i++) {
                map[i][startX] = map[i][startX] == -1 ? 0 : 1;
                map[i][endX] = map[i][endX] == - 1 ? 0 : 1;
            }

        }

        for (int[] pos : rectangle) {
            int startX = pos[0]*2;
            int startY = pos[1]*2;
            int endX = pos[2]*2;
            int endY = pos[3]*2;

            for(int i=startY+1;i<=endY-1;i++) {
                for(int j=startX+1;j<=endX-1;j++) {
                    map[i][j] = 0;
                }
            }
        }

        System.out.println(set);

        queue.add(new int[]{characterY*2, characterX*2, 0});
        visited[characterY*2][characterX*2] = true;

        while(!queue.isEmpty()) {
            int[] pickPos = queue.poll();
            System.out.println("현재 좌표 : ["+pickPos[1] + ", " + pickPos[0] + "] => " + (pickPos[2]));
            if (pickPos[0] == itemY*2 && pickPos[1] == itemX*2) {
                answer = pickPos[2]/2;
                break;
            }

            for(int i=0;i<4;i++) {
                int nextPosY = pickPos[0] + moveY[i];
                int nextPosX = pickPos[1] + moveX[i];
                if (nextPosY >= 0 && nextPosY <= maxY && nextPosX >= 0 && nextPosX <= maxX && map[nextPosY][nextPosX] == 1 && !visited[nextPosY][nextPosX] && check(pickPos[1], pickPos[0], nextPosX, nextPosY, rectangle)) {
                    System.out.println("["+nextPosX + ", " + nextPosY + "] => " + (pickPos[2] + 1));
                    if (set.contains(pickPos[1]+","+ pickPos[0]) && set.contains(nextPosX+","+nextPosY)) {
                    } else {
                        System.out.println("추가된 좌표 : ["+nextPosX + ", " + nextPosY + "] => " + (pickPos[2] + 1));
                        queue.add(new int[]{nextPosY, nextPosX, pickPos[2] + 1});
                        visited[nextPosY][nextPosX] = true;
                    }
                }
            }

        }

        for(int i=0;i< map.length;i++) {
            System.out.println();
            for(int j=0;j<map[i].length;j++) {
                System.out.print("[" + map[i][j] + "] ");
            }
        }

        System.out.println(answer);

        return answer;
    }

    public boolean check(int targetStartX, int targetStartY, int targetEndX, int targetEndY, int[][] rectangle) {

        for (int[] pos : rectangle) {
            int startX = pos[0]*2;
            int endX = pos[2]*2;
            int startY = pos[1]*2;
            int endY = pos[3]*2;
            System.out.println("비교 사각형 : [" + startX + ", " + startY + "] [" + endX + ", " + endY + "]");

            if (targetStartX >= startX && targetStartX <= endX && targetEndX >= startX && targetEndX <= endX && targetStartY >= startY && targetStartY <= endY && targetEndY >= startY && targetEndY <= endY) {
                if (targetStartY == targetEndY) {
                    System.out.println("같은 X좌표 포함 >> [" + targetStartX + ", " + targetStartY + "] [" + targetEndX + ", " + targetEndY + "]");
                    return true;
                } else if (targetStartX == targetEndX) {
                    System.out.println("같은 Y좌표 포함 >> [" + targetStartX + ", " + targetStartY + "] [" + targetEndX + ", " + targetEndY + "]");
                    return true;
                }
            }

        }
        return false;
    }
}
