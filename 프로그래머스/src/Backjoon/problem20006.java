package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class problem20006 {
    static class Room {
        private int loLevel;
        private int hiLevel;
        private int level;
        private List<Player> list;

        public Room(int loLevel, int hiLevel, int level, List<Player> list) {
            this.loLevel = loLevel;
            this.hiLevel = hiLevel;
            this.level = level;
            this.list = list;
        }
    }

    static class Player {
        private int level;
        private String nickName;

        public Player(int level, String nickName) {
            this.level = level;
            this.nickName = nickName;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();
        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<Room> rooms = new ArrayList<>();
        for(int i=0;i<p;i++) {
            st = new StringTokenizer(bf.readLine());
            int l = Integer.parseInt(st.nextToken());
            String n = st.nextToken();
            Player player = new Player(l, n);
            int findIndex = -1;
            int index = 0;
            // 입장 가능한 room 번호 찾기
            for (Room room : rooms) {
                if (room.list.size() == m || !(room.loLevel <= l && room.hiLevel >= l)) {
                    index++;
                    continue;
                }
                findIndex = index;
                break;
            }
            Room room;
            // 입장 하기
            if (findIndex == -1) {
                List<Player> list = new ArrayList<>();
                list.add(player);
                room = new Room(l - 10, l + 10, l, list);
                rooms.add(room);
            } else {
                room = rooms.get(findIndex);
                room.list.add(player);
            }
        }

        for (Room room : rooms) {
            sb.append(room.list.size() == m ? "Started!" : "Waiting!").append("\n");
            Collections.sort(room.list, (o1, o2) -> o1.nickName.compareTo(o2.nickName));
            room.list.forEach(x -> sb.append(x.level).append(" ").append(x.nickName).append("\n"));
        }
        System.out.println(sb);
    }
}
