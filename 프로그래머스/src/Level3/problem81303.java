package Level3;

import java.util.*;

public class problem81303 {

    public static void main(String[] args) {
        problem81303 problem81303 = new problem81303();
//        problem81303.solution(8, 2, new String[]{"D 2","C","U 3","C","D 4","C","U 2","Z","Z"});
        problem81303.solution(8, 2, new String[]{"D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"});
    }

    public class User {
        private int name;
        private int index;

        public User(int name, int index) {
            this.name = name;
            this.index = index;
        }
    }

    public String solution(int n, int k, String[] cmd) {
        char[] map = new char[n];
        Stack<User> junk = new Stack<>();
        String answer = "";
        int up = Math.max(k - 1, 0);
        int down = Math.min(k + 1, k);
        LinkedList<Integer> list = new LinkedList<>();
        for(int i=0;i<n;i++) list.add(i);

        Arrays.fill(map, 'O');

        for (String command : cmd) {
            String key = command.split(" ")[0];
            System.out.println("현재 인덱스 : " + k);
            System.out.println("현재 리스트 : " + list);
            System.out.println("쓰레기통 : " + junk);
            if (key.equals("U") || key.equals("D")) {
                int dst = Integer.parseInt(command.split(" ")[1]);
                System.out.println("["+key+"] : " + dst);
                k = key.equals("U") ? k - dst : k + dst;
//                k += findIndex(key, k, dst, junk);
                if (k<0) k = 0;
                else if (k>=n-1) k = n-1;
            } else if (key.equals("C")) {
                junk.add(new User(list.get(k), k));
                list.remove(k);
                k = Math.min(k, list.size() - 1);
            } else if (key.equals("Z")) {
                User user = junk.pop();
                list.add(user.index, user.name);
                k = k > user.index ? k + 1 : k;
            }
        }

        while(!junk.isEmpty()) {
            User user = junk.pop();
            System.out.println("index >> " + user.name);
            map[user.name] = 'X';
        }


        for (char c : map) {
            answer += c;
        }
        System.out.println(answer);
        return answer;
    }

    public int findUp(Stack<Integer> j, int k) {
        while(true) {
            k--;
            if (!j.contains(k) || k < 0) break;
        }
        return Math.max(k, 0);
    }

    public int findDown(Stack<Integer> j, int k, int n) {
        while(true) {
            k++;
            if (!j.contains(k) || k > n - 1) break;
        }
        return Math.min(k, n - 1);
    }


    public int findIndex(String key, int k, int dst, Stack<Integer> j) {
        Stack<Integer> junk = (Stack<Integer>) j.clone();
        int upIdx = 0;
        int downIdx = 0;
        dst = key.equals("U") ? dst : dst*(-1);
        dst += k;
        System.out.println("현재 위치 : " + k);
        System.out.println("쓰레기통 : " + j);
        while(!junk.isEmpty()) {
            int ele = junk.pop();
            if (key.equals("U") && (ele >= k && ele <= dst)) {
                upIdx++;
            } else if (key.equals("D") && (ele>= dst && ele <= k)) {
                downIdx++;
            }
        }
        return key.equals("U") ? upIdx*(-1) : downIdx;
    }

//    public String solution(int n, int k, String[] cmd) {
//        String answer = "";
//        HashMap<Integer, Integer> board = new HashMap<>();
//        boolean[] visited = new boolean[n];
//        Stack<Integer> junk = new Stack<>();
//        int lastIndex = n-1;
//
//        Arrays.fill(visited, true);
//
//
//        for(String command: cmd) {
//            System.out.println("pos : " + k);
//            System.out.println("현재 커맨드 : " + command);
//            if (command.charAt(0) == 'C') {
//                visited[k] = false;
//                junk.add(k);
//                if (k == lastIndex) {
//                    lastIndex = findLastIndex(visited, lastIndex);
//                    k = lastIndex;
//                } else {
//                    k = findIndex(visited, k);
//                }
//
//            } else if (command.charAt(0) == 'Z') {
//                int rollBackIndex = junk.pop();
//                lastIndex = Math.max(rollBackIndex, lastIndex);
//                visited[rollBackIndex] = true;
//            } else {
//                String[] miniCommand = command.split(" ");
//                char direction = miniCommand[0].charAt(0);
//                int distance = Integer.parseInt(miniCommand[1]);
//                k = move(visited, direction, k, distance, junk);
//            }
//        }
//        answer = check(visited);
//        return answer;
//    }
//
//    private int findIndex(boolean[] visited,int index) {
//        for(int i=index+1;i<visited.length;i++)
//            if (visited[i]) return i;
//
//        return index;
//    }
//
//    private int findLastIndex(boolean[] visited, int index) {
//        for(int i=index;i>=0;i--) {
//            if (visited[i]) return i;
//        }
//        return index;
//    }
//
//    private String check(boolean[] visited) {
//        String answer = "";
//        StringBuilder sb = new StringBuilder(answer);
//        for(int i=0;i<visited.length;i++) {
//            if (!visited[i]) {
//                sb.append("X");
//            } else {
//                sb.append("O");
//            }
//        }
//
//        answer = sb.toString();
//        System.out.println(answer);
//        return answer;
//    }
//
//    private int move(boolean[] visited, char direction, int currentIndex, int distance, Stack<Integer> j) {
//        int nextIndex = 0;
//        int upIdx = 0;
//        int downIdx = 0;
//        System.out.println("현재 위치 : " + currentIndex);
//        System.out.println("주어진 거리 : " + distance);
//        Stack<Integer> junk = (Stack<Integer>)j.clone();
//        while(!junk.isEmpty()) {
//            int ele = junk.pop();
//            if (direction == 'U' && (ele >= currentIndex-distance && ele <= currentIndex)) {
//                upIdx++;
//            } else if (direction == 'D' && (ele >= currentIndex && ele <= currentIndex+distance)) {
//                downIdx++;
//            }
//        }
//
//        if (direction == 'U') {
//            nextIndex = currentIndex - distance - upIdx;
//            nextIndex = Math.max(nextIndex, 0);
//        } else {
//            nextIndex = currentIndex + distance + downIdx;
//            nextIndex = nextIndex > visited.length ? visited.length-1 : nextIndex;
//        }
////         if (direction == 'U') {
//
////             for(int i=currentIndex-1;i>=0;i--) {
////                 if (distance == 0) break;
////                 if (visited[i]) {
////                     nextIndex = i;
////                     distance--;
////                 }
////             }
////         } else {
////             for(int i=currentIndex+1;i<visited.length;i++) {
////                 if (distance == 0) break;
////                 if(visited[i]) {
////                     nextIndex = i;
////                     distance--;
////                 }
////             }
////         }
//        return nextIndex;
//    }

}
